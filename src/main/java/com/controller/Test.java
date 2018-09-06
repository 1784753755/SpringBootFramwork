package com.controller;

import com.common.Log;
import com.common.SystemOut;
import com.github.pagehelper.PageInfo;
import com.model.Goods;
import com.model.OrderDetail;
import com.service.OrderDetailService;
import com.service.SelectPageService;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.*;

import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class Test {
    @Value("${com.img.path}")
    private String imgPaht;
    @Autowired
    private ServletContext servletContext;

    /*单图上传*/
   // @PostMapping("/upload.do")
    public String response(@RequestParam("args[file_upload_photo]") MultipartFile file, HttpServletRequest request) throws Exception {
        Logger msg = LogManager.getLogger(Test.class);

        if (!file.isEmpty()) {
            try {
                // getRealPath() 取得 WEB-INF 所在文件夹路径
                // 如果参数是 "/temp", 当 temp 存在时返回 temp 的本地路径, 不存在时返回 null/temp (无效路径)
                //获取原文件名
                String fileName = file.getOriginalFilename();
                msg.info(fileName);
                //文件后缀带点
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //新文件名 防止重复
                String name = UUID.randomUUID() + suffix;
                //文件地址

                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload = new File(path.getAbsolutePath(), "templates/H-ui.admin_v3.0/static/img/" + name);
                if (!path.exists())
                    path.mkdirs();
                msg.info("path:" + path);
                msg.info("path:" + upload);

                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(upload));

                //将上传的文件地址返回
                //        String imgurl = StaticFinalVar.Local_URL+"/uplodefiles/"+ name;
//                System.out.println(imgurl);
//                return imgurl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "1";

    }

//图片的下载

  //  @RequestMapping("/downImg.do")
    public String downImg(HttpServletResponse response) throws Exception {
        Logger msg = LogManager.getLogger(Test.class);

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(), "templates/H-ui.admin_v3.0/static/img/" + "14aa4363-7213-45f6-a4bc-66040a38cf8f.jpg");
        InputStream inputStream = new FileInputStream(upload);
        OutputStream outputStream = response.getOutputStream();
        //设置内容类型为下载类型
        response.setContentType("application/x-download");
        //设置请求头 和 文件下载名称
        response.addHeader("Content-Disposition", "attachment;filename=test.jpg");
        //用 common-io 工具 将输入流拷贝到输出流
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
        return "1";

    }

    /*可以尝试一下formData直接js 上传*/
    @PostMapping("/uploadImgsTest.do")
    public String response(HttpServletRequest request) throws Exception {
        Logger msg = LogManager.getLogger(Test.class);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("args[file_upload_photo]");
        if (files.size() > 0) {

            try {
                for (int i = 0; i < files.size(); i++) {

                    msg.info("101***" + files.get(i).toString());
                    if (StringUtils.isEmpty(files.get(i)) || files.get(i).getSize() < 1) {
                        msg.info("105");
                        msg.info(files.get(i).getName());
                        return "1";
                    }
                    if (StringUtils.isEmpty(files.get(i).getOriginalFilename())) {
                        msg.info("109");

                        return "1";
                    }
                    String fileName = files.get(i).getOriginalFilename();
                    msg.info(fileName);
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String name = UUID.randomUUID() + suffix;
                    File path = new File(ResourceUtils.getURL("classpath:").getPath());
                    File upload = new File(path.getAbsolutePath(), "templates/H-ui.admin_v3.0/static/img/" + name);
                    if (!path.exists())
                        path.mkdirs();
                    msg.info("path:" + path);
                    msg.info("path:" + upload);
                    FileCopyUtils.copy(files.get(i).getInputStream(), new FileOutputStream(upload));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "1";

    }

    @Autowired
    private SelectPageService selectPageService;

    @RequestMapping("/getGoodsTest.do")
    public List<Goods> upImgs(Map<String, Object> model) throws Exception {
        PageInfo ss = selectPageService.selectDemos(10, 2);
        List<Goods> list = new ArrayList<Goods>();
        Goods good;
        for (int i = 0; i < 5; i++) {
            /*ID	分类名称	图片	审核状态	显示状态	排序*/
            good = new Goods();
            good.setGoodsId(i);
            good.setGoodsCategory(2);
            good.setGoodsImg(1);
            good.setStatus(2);
            good.setGoodsOrder(10);
            list.add(good);
        }
        model.put("index", "1");
        model.put("last", "10");
        model.put("size", ss.getPageNum());
        return list;
    }
    @Autowired
    private OrderDetailService orderDetailService;
    @RequestMapping("/getOrderDetailByName.test")
    public void showGetORderDetail(){
      List<OrderDetail>  getOrderDetails = orderDetailService.getOrderDetail("LG15272330431204");
        System.out.println(getOrderDetails);
    }
    /**/
    /*/addCategory.do*/
  //  @RequestMapping("/addCategoryTest.do")
    public String TestFormData(@RequestParam("args[file_upload_photo]") MultipartFile file, HttpServletRequest request) throws Exception {
        Logger msg = LogManager.getLogger(Test.class);

        if (!file.isEmpty()) {
            try {
                // getRealPath() 取得 WEB-INF 所在文件夹路径
                // 如果参数是 "/temp", 当 temp 存在时返回 temp 的本地路径, 不存在时返回 null/temp (无效路径)
                //获取原文件名
                String fileName = file.getOriginalFilename();
                msg.info(fileName);
                //文件后缀带点
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //新文件名 防止重复
                String name = UUID.randomUUID() + suffix;
                //文件地址

                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload = new File(path.getAbsolutePath(), imgPaht + name);
                if (!path.exists())
                    path.mkdirs();
                msg.info("path:" + path);
                msg.info("path:" + upload);

                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(upload));

                //将上传的文件地址返回
                //        String imgurl = StaticFinalVar.Local_URL+"/uplodefiles/"+ name;
//                System.out.println(imgurl);
//                return imgurl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "1";
    }
}
