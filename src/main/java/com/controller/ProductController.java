package com.controller;

import com.common.Path;
import com.common.SystemOut;
import com.common.Time;
import com.github.pagehelper.PageInfo;
import com.model.Goods;
import com.model.Picture;
import com.model.ProductCategory;
import com.model.domain.StandProduct;
import com.service.FileService;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.SelectPageService;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@RestController
public class ProductController {
    public static Logger logger = LogManager.getLogger(ProductController.class);
    /* 当前行号  Current.currentLine(    Thread.currentThread().getStackTrace());*/
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService;
    @Autowired
    private Path sourcePath;
    private int pageSize = 5;
    private int pageIndex = 1;
    /*商品添加*/

    @RequestMapping(value = "/addProduct.do", method = RequestMethod.POST)
    public String addGoods(HttpServletRequest request, @RequestParam("args[main_img]") MultipartFile file, Map<String, Object> model) {
        //单图上传
        /*获取产品id*/
        Integer imgMainId = -1;
        String getGoodsId = request.getParameter("args[goods_id]");
        Integer goodId = getGoodsId == null ? null : Integer.valueOf(getGoodsId);
        Goods goods;
        boolean updateBoolean = false;
        if (goodId == null)
            goods = new Goods();
        else {
            updateBoolean = true;
            goods = productService.getGoodsById(goodId);
            if (goods == null) {
                goods = new Goods();
                updateBoolean = false;
            } else {
                imgMainId = goods.getGoodsImg();
            }

        }

        //确保主图id
        Integer mainImg = SingeImgUp(file, imgMainId);
        String getId = goods.getImgMain();
        int mainId = getId == null ? 0 : Integer.valueOf(getId);
        mainImg = mainImg == null ? mainId : mainImg;
        //多图上传
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("args[file_upload_photo]");
        String getListPic = multipartImg(files, mainImg, goods);
        //详情页的传递
        //Ueditor详情的上传
        String getTitle = request.getParameter("args[title]");
        String getCat = request.getParameter("args[goods_category]");
        int category = getCat == null ? 0 : Integer.valueOf(getCat);
        String getOrd = request.getParameter("args[goods_order]");
        int Order = getOrd == null ? 0 : Integer.valueOf(getOrd);
        String getLab = request.getParameter("args[goods_label]");
        int Label = getLab == null ? 0 : Integer.valueOf(getLab);
        String getUni = request.getParameter("args[goods_unit]") == null ? "" : request.getParameter("args[goods_unit]");
        String getCoul = request.getParameter("args[goods_count]");
        int count = getCoul == null ? 0 : Integer.valueOf(getCoul);
        String getMon = request.getParameter("args[goods_moneytype]") == null ? "" : request.getParameter("args[goods_moneytype]");
        String getSto = request.getParameter("args[goods_store]");
        int Store = getSto == null ? 0 : Integer.valueOf(getSto);
        String getTotal = request.getParameter("args[total]");
        int Total = getTotal == null ? 0 : Integer.valueOf(getTotal);
        String getPri = request.getParameter("args[goods_price]") == null ? "" : request.getParameter("args[goods_price]");
        float price = getPri == null ? 0 : Float.parseFloat(getPri);
        String getOld = request.getParameter("args[goods_old_price]");
        float oldPrice = getOld == null ? 0 : Float.parseFloat(getOld);
        String getAdd = request.getParameter("args[goods_address]") == null ? "" : request.getParameter("args[goods_address]");
        String getSiz = request.getParameter("args[goods_size]") == null ? "" : request.getParameter("args[goods_size]");
        String getTop = request.getParameter("args[is_top]");
        int Top = getTop == null ? 0 : Integer.valueOf(getTop);
        String getSort = request.getParameter("args[is_sort]");
        int sort = getSort == null ? 00 : Integer.valueOf(getSort);
        String getSubText = request.getParameter("args[subtxt]") == null ? "" : request.getParameter("args[subtxt]");
        String goodsOnlyPrice = request.getParameter("args[goods_only_price]") == null ? "" : request.getParameter("args[goods_only_price]");
        goods.setTitle(getTitle);
        goods.setGoodsCategory(category);
        goods.setGoodsOrder(Order);
        goods.setGoodsLabel(Label);
        goods.setGoodsUnit(getUni);
        goods.setGoodsCount(count);
        goods.setGoodsMoney(getMon);
        goods.setGoodsStore(Store);
        goods.setTotal(Total);
        goods.setGoodsPrice(price);
        goods.setGoodsOldPrice(oldPrice);
        goods.setGoodsAddress(getAdd);
        goods.setGoodsSize(getSiz);
        goods.setIsTop(Top);
        goods.setIsSort(sort);
        String dealSubText = getSubText.replaceAll("\"", "'");
        goods.setGoodsDetail(dealSubText);
        goods.setGoodsImg(mainImg);
        goods.setGoodsSpec("设置什么了");
        goods.setGoodsColor(0);
        goods.setStatus(0);
        goods.setType(0);
        goods.setCreateTime(Time.getCurrentTime());
        goods.setUpdateTime(Time.getCurrentTime());
        goods.setuId(0);
        goods.setGoodsOnlyPrice(goodsOnlyPrice);
        goods.setGoodsListImg(getListPic);
        logger.info("I'm Here");
        //将图片存到项目下img文件夹中 同时获取图片的路径
        /* updateBoolean==false 默认*/
        if (updateBoolean == false)
            productService.addGoods(goods);
        else {
            productService.upDates(goods);
        }

        System.out.println(goods);
        model.put("success", "success");
        return "/department/addProduct";
    }

    /*单图上传*/
    public Integer SingeImgUp(MultipartFile file, Integer imgId) {
        Logger logger = LogManager.getLogger(Test.class);
        Integer thumId = null;
        Picture oldPic = fileService.getPic(imgId);
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
                if (oldPic != null) {
                    oldPic.setImgUrl(imgp);
                    fileService.updatePic(oldPic);
                    return oldPic.getImgPid();
                }
                Picture picture = new Picture();
                try {
                    picture.setImgUrl(imgp);
                    picture.setType("goods");
                    picture.setIsThumb(1);
                    /*加入主图的时候获取 id*/
                    picture.setImgPid(-1);
                    fileService.savePic(picture);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                thumId = (Integer) fileService.getThumPicId(imgp);
                picture.setFileId(thumId);
                picture.setImgPid(thumId);
                fileService.updatePic(picture);
                return thumId;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (oldPic == null)
                return null;
            else
                return oldPic.getImgPid();
        }
        return null;

    }

    /*多图上传 or（可转化成text）*/
    public String multipartImg(List<MultipartFile> files, int imgPid, Goods goods) {
        StringBuilder ulrList = new StringBuilder();

        /*先把存在好的file_url id 跟新一下 获取旧的url */

        String getUrls = "";
        if (goods != null) {
            logger.info(goods.getGoodsListImg());
            getUrls = goods.getGoodsListImg() == null ? "" : goods.getGoodsListImg();
            //将旧图的img_pid更改一下
            if (!StringUtils.isEmpty(getUrls)) {
                String[] changeImg = getUrls.split(",");
                for (int i = 0; i < changeImg.length; i++) {
                    if (!StringUtils.isEmpty(changeImg[i])) {
                        Picture picture = fileService.getPic(Integer.valueOf(changeImg[i]));
                        picture.setImgPid(imgPid);
                        fileService.updatePic(picture);
                    }
                }
            }
        }
        int id;
        if (files.size() > 0) {
            try {
                for (int i = 0; i < files.size(); i++) {
                    if (StringUtils.isEmpty(files.get(i)) || files.get(i).getSize() < 1) {
                        SystemOut.show("NullAble 147 is e");
                        return getUrls;
                    }
                    if (StringUtils.isEmpty(files.get(i).getOriginalFilename())) {
                        SystemOut.show("Name is empty NullAble");
                        return getUrls;
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
                    Picture picture = new Picture();
                    try {
                        picture.setImgUrl(imgp);
                        picture.setType("goods");
                        picture.setIsThumb(0);
                        picture.setImgPid(imgPid);
                        fileService.savePic(picture);
                        id = fileService.getThumPicId(imgp);
                        logger.info("id----xxxx:" + id);
                        if (i < files.size())
                            getUrls += id + "" + ",";
                        else getUrls += id + "";

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return getUrls;

    }

    /* 获取商品*/
    @RequestMapping("/getGoods.do")
    public List<StandProduct> showProduct(HttpServletRequest request, Map<String, Object> mp) throws Exception {

        //   PageInfo ss= selectPageService.selectDemos(10);
        List<StandProduct> list = new ArrayList<StandProduct>();
        StandProduct good;
        /*每页显示*/
        String getPageSize = request.getParameter("pageSize");
        pageSize = getPageSize == null ? pageSize : Integer.valueOf(getPageSize);
        /*页码*/
        String getPageIndex = request.getParameter("pageIndex");
        pageIndex = getPageIndex == null ? pageIndex : Integer.valueOf(getPageIndex);

        String getCategoryId = request.getParameter("CategoryId");
        PageInfo<Goods> pageInfo;
        //获取产品  准备分页
//        类别获取产品  集体获取产品
        if (!StringUtils.isEmpty(getCategoryId)) {
            Integer categoryId=Integer.valueOf(getCategoryId);
            pageInfo = selectPageService.selectGoodsByCategory(pageSize, pageIndex, categoryId);
        }
        else
            pageInfo = selectPageService.selectGoods(pageSize, pageIndex);

        logger.info(pageInfo.getTotal());

        for (int i = 0; i < pageInfo.getList().size(); i++) {
            logger.info(pageInfo.getList().get(i).toString());
            good = new StandProduct();
            Goods goods = pageInfo.getList().get(i);
            good.setId(goods.getGoodsId());
            good.setOrder(goods.getGoodsOrder());
            good.setName(goods.getTitle());
            /* 查询分类id*/
            ProductCategory productCategory = productCategoryService.getProductCategoryById(goods.getGoodsCategory());
            String category = productCategory == null ? "" : productCategory.getTitle();
            good.setCategory(category);
            /*库存*/
            good.setStoreNum(goods.getGoodsStore());
            /*销售数量*/
            good.setCount(goods.getGoodsCount());
            good.setPrice(goods.getGoodsPrice());
            int type = goods.getType();
            String setShowType = type == 1 ? "显示通过" : "显示不通过";
            good.setType(setShowType);
            int IsTop = goods.getIsTop();
            String SetIsTop = IsTop == 1 ? "推荐" : "不推荐";
            good.setIsTop(SetIsTop);
            int status = goods.getStatus();
            String setStatus = status == 1 ? "通过" : "不通过";
            good.setStatus(setStatus);
            /*关联表查询--状态*/
            /*搜索图片*/

            list.add(good);
        }
        return list;
    }

    /*获取对应分类的商品*/
    @RequestMapping("/getGoodsByCategory.do")
    public List<StandProduct> showProductByCategory(HttpServletRequest request, Map<String, Object> mp) throws Exception {

        //   PageInfo ss= selectPageService.selectDemos(10);
        List<StandProduct> list = new ArrayList<StandProduct>();
        StandProduct good;
        /*每页显示*/
        String getPageSize = request.getParameter("pageSize");
        pageSize = getPageSize == null ? pageSize : Integer.valueOf(getPageSize);
        /*页码*/
        String getPageIndex = request.getParameter("pageIndex");
        pageIndex = getPageIndex == null ? pageIndex : Integer.valueOf(getPageIndex);
        /*获取类别id*/
        String getCategoryId = request.getParameter("CategoryId");

        //获取产品  准备分页

        PageInfo<Goods> pageInfo = selectPageService.selectGoodsByCategory(pageSize, pageIndex, 1);

        logger.info(pageInfo.getTotal());

        for (int i = 0; i < pageInfo.getList().size(); i++) {
            logger.info(pageInfo.getList().get(i).toString());
            good = new StandProduct();
            Goods goods = pageInfo.getList().get(i);
            good.setId(goods.getGoodsId());
            good.setOrder(goods.getGoodsOrder());
            good.setName(goods.getTitle());
            /* 查询分类id*/
            ProductCategory productCategory = productCategoryService.getProductCategoryById(goods.getGoodsCategory());
            String category = productCategory == null ? "" : productCategory.getTitle();
            good.setCategory(category);
            /*库存*/
            good.setStoreNum(goods.getGoodsStore());
            /*销售数量*/
            good.setCount(goods.getGoodsCount());
            good.setPrice(goods.getGoodsPrice());
            int type = goods.getType();
            String setShowType = type == 1 ? "显示通过" : "显示不通过";
            good.setType(setShowType);
            int IsTop = goods.getIsTop();
            String SetIsTop = IsTop == 1 ? "推荐" : "不推荐";
            good.setIsTop(SetIsTop);
            int status = goods.getStatus();
            String setStatus = status == 1 ? "通过" : "不通过";
            good.setStatus(setStatus);
            /*关联表查询--状态*/
            /*搜索图片*/

            list.add(good);
        }
        return list;
    }

    @RequestMapping("/getGoodsById.do")
    public Goods editorProduct(HttpServletRequest request) throws Exception {
        //   PageInfo ss= selectPageService.selectDemos(10);
        String gets = request.getParameter("getId");
        if (StringUtils.isEmpty(gets))
            return null;
        int getId = Integer.valueOf(gets);
        Goods goods = productService.getGoodsById(getId);
        int imgId = goods.getGoodsImg();
        goods.setImgMain(UrlPath(imgId));
        /*在图片名字没有进行base不重复命名设置图片的时候记得把图片的id一并传回去*/
        /*本方案是在图片路径唯一不重复直接传名字回去*/
        String imgList = goods.getGoodsListImg();
        String[] list2 = null;
        if (imgList != null) {
            list2 = imgList.split(",");
            List<String> imgsList2 = new LinkedList<>();
            for (int j = 0; j < list2.length; j++) {
                if (!StringUtils.isEmpty(list2[j])) {
                    imgsList2.add(UrlPath(Integer.valueOf(list2[j].trim())));
                }
            }
            goods.setImgList(imgsList2);
        }
        return goods;
    }

    /*$.post("/getProductByName.do",{'productName':getName},function (data) {
               dressContent(data);
        })*/

    @RequestMapping("/getProductByName.do")
    public List<StandProduct> getProductByName(HttpServletRequest request) throws Exception {
         //   PageInfo ss= selectPageService.selectDemos(10);
        List<StandProduct> list = new ArrayList<StandProduct>();
        StandProduct good;
        String getName = request.getParameter("productName");
        if(StringUtils.isEmpty(getName))
            return null ;
        List<Goods>  getGoods=   productService.getGoodsByName(getName.trim());
         for (int i = 0; i < getGoods.size(); i++) {
            logger.info(getGoods.get(i).toString());
            good = new StandProduct();
            Goods goods = getGoods.get(i);
            good.setId(goods.getGoodsId());
            good.setOrder(goods.getGoodsOrder());
            good.setName(goods.getTitle());
            /* 查询分类id*/
            ProductCategory productCategory = productCategoryService.getProductCategoryById(goods.getGoodsCategory());
            String category = productCategory == null ? "" : productCategory.getTitle();
            good.setCategory(category);
            /*库存*/
            good.setStoreNum(goods.getGoodsStore());
            /*销售数量*/
            good.setCount(goods.getGoodsCount());
            good.setPrice(goods.getGoodsPrice());
            int type = goods.getType();
            String setShowType = type == 1 ? "显示通过" : "显示不通过";
            good.setType(setShowType);
            int IsTop = goods.getIsTop();
            String SetIsTop = IsTop == 1 ? "推荐" : "不推荐";
            good.setIsTop(SetIsTop);
            int status = goods.getStatus();
            String setStatus = status == 1 ? "通过" : "不通过";
            good.setStatus(setStatus);
            /*关联表查询--状态*/
            /*搜索图片*/

            list.add(good);
        }
        return list;
    }


    String UrlPath(int id) {
        String url = "";
        Picture picture = fileService.getPic(id);
        if (picture != null)
            return picture.getImgUrl();
        else return "";
    }

    @RequestMapping("/getAllCount")
    public String getCount() {
        /*  制作列表页*/
        int allCount = productService.countNum();
        /* 将数据传回前台制作列表*/
        return allCount + "";
    }

    @RequestMapping("/getCountByCategory")
    public String getCountByCategory(HttpServletRequest request) {
        String getGoodsCategoryId = request.getParameter("getId");
        if (StringUtils.isEmpty(getGoodsCategoryId))
            return null;
        Integer goodCategoryId = Integer.valueOf(getGoodsCategoryId);
        /*  制作列表页*/
        int allCount = productService.countNumByCategory(goodCategoryId);
        /* 将数据传回前台制作列表*/
        return allCount + "";
    }


    /* 图片的下载*/
    @RequestMapping(value = "/downImg.do", method = RequestMethod.POST)
    public String downImg(HttpServletResponse response) throws Exception {
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


    /*只针对商品相册*/
    @RequestMapping("/updateProductImg.do")
    public String updateProductImg(HttpServletRequest request) {
        try {
            String[] oldImgList = null;
            String newImgList = "";
            String path = request.getParameter("imgpath");
            String productId = request.getParameter("productId");
            int goodId = Integer.valueOf(productId.trim());

            Integer upId = fileService.getThumPicId(path);
            Picture picture = fileService.getPic(upId);
            if (upId == null)
                return null;
            Goods goods = productService.getGoodsById(goodId);
            if (goods != null) {
                oldImgList = goods.getGoodsListImg().split(",");
            }
            if (!StringUtils.isEmpty(oldImgList)) {
                for (int i = 0; i < oldImgList.length; i++) {
                    if (oldImgList[i].trim().matches(String.valueOf(upId)) || StringUtils.isEmpty(oldImgList[i].trim())) {
                        continue;
                    }
                    if (i < oldImgList.length)
                        newImgList += oldImgList[i].trim() + ",";
                    else
                        newImgList += oldImgList[i].trim();
                }
            }
            goods.setGoodsListImg(newImgList);
            logger.info(goods);
            productService.upDates(goods);
            if (picture.getIsThumb().equals(0))
                fileService.DelPic(upId);
            /*更新一下goods imgs 然后跟新一波fileImg*/
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/delProduct.do")
    public String delProduct(HttpServletRequest request) {
        String getProductId = request.getParameter("getId");
        if (StringUtils.isEmpty(getProductId)) return null;
        Integer productId = Integer.valueOf(getProductId);
        productService.delProduct(productId);
        return "删除成功";
    }



}
