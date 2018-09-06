package com.controller;

import com.common.Matches;
import com.common.Path;
import com.common.SystemOut;
import com.common.Time;
import com.github.pagehelper.PageInfo;
import com.model.Appraise;
import com.model.Goods;
import com.model.domain.StandAppraise;
import com.model.domain.StandProduct;
import com.service.AppraiseService;
import com.service.SelectPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author caishengtang
 * @AppraiseController 评论栏
 */
@RestController
public class AppraiseController {
    public static Logger logger = LogManager.getLogger(AppraiseController.class);
    @Autowired
    private AppraiseService appraiseService;
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private Path sourcePath;

    @RequestMapping("/getAllAppraise.do")
    public List<StandAppraise> getAllAppraise(HttpServletRequest request) {
        List<StandAppraise> list = new ArrayList<StandAppraise>();

        /*每页显示*/
        String getPageSize = request.getParameter("pageSize");
        Integer pageSize = getPageSize == null ? 10 : Integer.valueOf(getPageSize);
        /*页码*/
        String getPageIndex = request.getParameter("pageIndex");
        Integer pageIndex = getPageIndex == null ? 1 : Integer.valueOf(getPageIndex);

        String getProductId = request.getParameter("productId");
        if (getProductId == null)
            return null;
        Integer productId = Integer.valueOf(getProductId);
        PageInfo<Appraise> pageInfo;
        //获取产品  准备分页
//        类别获取产品  集体获取产品

        pageInfo = selectPageService.selectAppraise(pageSize, pageIndex, productId);
        logger.info(pageInfo.getTotal());
        StandAppraise standAppraise;

        for (int i = 0; i < pageInfo.getList().size(); i++) {

            standAppraise = new StandAppraise();
            standAppraise.setAddTime(pageInfo.getList().get(i).getAddTime());
            standAppraise.setAppraiseId(pageInfo.getList().get(i).getAppraiseId());
            standAppraise.setAvatarImg(pageInfo.getList().get(i).getAvatarImg());
            standAppraise.setCommentator(pageInfo.getList().get(i).getCommentator());
            standAppraise.setDescrible(pageInfo.getList().get(i).getDescrible());
            String[] imglist = pageInfo.getList().get(i).getImgList().split(";");
            standAppraise.setImgList(imglist);
            standAppraise.setStatus(pageInfo.getList().get(i).getStatus() == 1 ? "通过" : "禁止");
            standAppraise.setOrder(pageInfo.getList().get(i).getOrder());
            standAppraise.setUpper(pageInfo.getList().get(i).getUpper());
            list.add(standAppraise);

        }
        return list;
    }

    /*获取对应的productId的总数*/
    @RequestMapping("/getAppraiseCount.do")
    public Integer getAppraiseCount(HttpServletRequest request) {
        String getproductId = request.getParameter("productId");

        Integer getCount = appraiseService.countAppraise(Integer.valueOf(getproductId));
        return getCount;
    }

    /*获取对应产品*/
    @RequestMapping("/getAppraiseById.do")
    public Appraise getAppraseById(HttpServletRequest request) {
        String getId = request.getParameter("appraiseId");

        if (getId == null || !getId.matches(Matches.num))
            return null;
        Appraise appraise = appraiseService.getAppraiseById(Integer.valueOf(getId));
        return appraise;
    }

    //    修改status
    @RequestMapping("/updateAppraiseStatus.do")
    public String changeStutas(HttpServletRequest request) {
        String getAppraiseId = request.getParameter("AppraiseId");
        Integer appraiseId = Integer.valueOf(getAppraiseId);

        Appraise appraise = appraiseService.getAppraiseById(appraiseId);
        if (appraise.getStatus() == 1)
            appraise.setStatus(0);
        else
            appraise.setStatus(1);
        appraiseService.updateAppraise(appraise);
        return "修改成功";
    }
//编辑

    @RequestMapping("/updateAppraiseImg.do")
    public String updateAppraiseImg(HttpServletRequest request) {
        String getAppraiseId = request.getParameter("appraiseId");
        Integer appraiseId = Integer.valueOf(getAppraiseId);
        String getImgPath = request.getParameter("imgpath");
        if (getImgPath == null || !getAppraiseId.matches(Matches.num))
            return null;
        Appraise appraise = appraiseService.getAppraiseById(appraiseId);
        String[] imgListPath = appraise.getImgList().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < imgListPath.length; i++) {
            if (!imgListPath[i].trim().equals(getImgPath.trim())) continue;
            stringBuilder.append(imgListPath[i]+";");
        }
        appraise.setImgList(stringBuilder.toString());
        appraiseService.updateAppraise(appraise);
        return "修改成功";
    }

    //    删除
    @RequestMapping("/delAppraise.do")
    public String delAppraise(HttpServletRequest request) {
        String getAppraiseId = request.getParameter("AppraiseId");
        Integer appraiseId = Integer.valueOf(getAppraiseId);
        appraiseService.delAppraise(appraiseId);
        return "删除成功";
    }

    //    增加评论
    @RequestMapping("/addApprasise.do")
    public String assApprasie(HttpServletRequest request, @RequestParam("args[file_main_photo]") MultipartFile multipartFile) {


        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("args[file_appraise_photo]");
        String avatarImg = SingeImgUp(multipartFile);
        String imgList = multipartImg(files);
        String getName = request.getParameter("customername");
        String getOrderValue = request.getParameter("product-appraise-order-value");

        String getContent = request.getParameter("product-appraise-content");
        if (getContent == null )
            return null;
        String productId = request.getParameter("productName");
        String appraiseId=request.getParameter("appraiseName");
        Appraise appraise;
        if (appraiseId == null) {
            if(productId==null)
                return null;
            appraise = new Appraise();
            appraise.setStatus(0);
            appraise.setAddTime(Time.getCurrentTime());
            appraise.setAvatarImg(avatarImg);
            appraise.setImgList(imgList);
            appraise.setCommentator(getName);
            appraise.setOrder(Integer.valueOf(getOrderValue));
            appraise.setUpper(Integer.valueOf(productId));
            appraise.setDescrible(getContent);
            appraiseService.saveAppraise(appraise);
        } else {
            if( appraiseId == null)
                return  null;
            appraise = appraiseService.getAppraiseById(Integer.valueOf(appraiseId));
            if (!StringUtils.isEmpty(avatarImg))
                appraise.setAvatarImg(avatarImg);
            else
                  appraise.setAvatarImg(appraise.getAvatarImg());
            if (!StringUtils.isEmpty(imgList))
                appraise.setImgList(appraise.getImgList()+imgList);
            appraise.setCommentator(getName);
            appraise.setOrder(Integer.valueOf(getOrderValue));
            appraise.setUpper(appraise.getUpper());
            appraise.setDescrible(getContent);
            appraiseService.updateAppraise(appraise);
        }

        return "成功";
    }

    /*单图上传*/
    public String SingeImgUp(MultipartFile file) {
        Logger logger = LogManager.getLogger(Test.class);
        Integer thumId = null;
//        先判断是否上传 先获取goods.getImg
        if (!file.isEmpty()) {
            try {
                //获取原文件名
                String fileName = file.getOriginalFilename();
                logger.info(fileName);
                //文件后缀带点
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //新文件名 防止重复
                String name = UUID.randomUUID() + suffix;
                //文件地址
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                logger.info(sourcePath.imgPath);
                //图片的路径
                String imgp = sourcePath.imgPath + name;
                File upload = new File(path.getAbsolutePath(), imgp);
                if (!path.exists())
                    path.mkdirs();

                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(upload));
                /*返回一个路径*/
                /* 直接把路径保存到file_url type=goods   return Id；
                 * */
                return imgp;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /*多图上传 or（可转化成text）*/
    public String multipartImg(List<MultipartFile> files) {
        StringBuilder ulrList = new StringBuilder();
        /*先把存在好的file_url id 跟新一下 获取旧的url */

        if (files.size() > 0) {
            try {
                for (int i = 0; i < files.size(); i++) {
                    if (StringUtils.isEmpty(files.get(i)) || files.get(i).getSize() < 1) {
                        SystemOut.show("NullAble 147 is e");
                        return ulrList.toString();
                    }
                    if (StringUtils.isEmpty(files.get(i).getOriginalFilename())) {
                        SystemOut.show("Name is empty NullAble");
                        return ulrList.toString();
                    }
                    String fileName = files.get(i).getOriginalFilename();
                    logger.info(fileName);
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String name = UUID.randomUUID() + suffix;
                    File path = new File(ResourceUtils.getURL("classpath:").getPath());
                    logger.info(sourcePath + name);
                    String imgp = sourcePath.imgPath + name;
                    File upload = new File(path.getAbsolutePath(), imgp);
                    if (!path.exists())
                        path.mkdirs();

                    FileCopyUtils.copy(files.get(i).getInputStream(), new FileOutputStream(upload));
                    /* model.put("list"+i,Path.imgPath + name);*/
                    ulrList.append(imgp + ";");
                }

                return ulrList.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}