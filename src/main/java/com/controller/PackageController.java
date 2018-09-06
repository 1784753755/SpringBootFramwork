package com.controller;

import com.common.Matches;
import com.common.Path;
import com.model.Color;
import com.model.Goods;
import com.model.Package;
import com.model.Picture;
import com.service.ColorService;
import com.service.FileService;
import com.service.PackageService;
import com.service.ProductService;
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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
public class PackageController {
    public static Logger logger = LogManager.getLogger(PackageController.class);
    @Autowired
    private PackageService packageService;
    @Autowired
    private Path sourcePath;
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService;



    @RequestMapping("/addPackage.do")
    public String addColor(HttpServletRequest request, @RequestParam("args[file_upload_photo]") MultipartFile multipartFile) throws IOException {

        String getTitle = request.getParameter("product-color-writeColor");
        String getPrice = request.getParameter("product-color-price");
        Integer getGoodId = Integer.valueOf(request.getParameter("product-good-id"));
        Goods goods = productService.getGoodsById(getGoodId);
         float price  ;
        if(StringUtils.isEmpty(getPrice)){
            price =  goods.getGoodsPrice();
        }
        else{
             if (!getPrice.matches(Matches.numPrice))
                return "价格不能非数字";
                price =  Float.parseFloat(getPrice);
        }
        //保存图片
        List<Package> getPackages = packageService.getPackageByProductId(goods.getGoodsId());
        for (int i = 0; i < getPackages.size(); i++) {
            if (getTitle.trim().matches(getPackages.get(i).getTitle()))
                return "套餐重复";
        }
        Package aPackage = new Package();
        aPackage.setTitle(getTitle);
        aPackage.setGoodsId(goods.getGoodsId());
        aPackage.setStatus(goods.getStatus());
        aPackage.setGoodsPrice(price);
        aPackage.setType(goods.getType());

        packageService.insertPackage(aPackage);

        Package aPackage1 = packageService.getPackageByProductIdAndTitle(goods.getGoodsId(), getTitle);
       logger.info(aPackage1);
        savePackageImg(multipartFile, aPackage1.getPackageId());
        return "添加成功";
    }

    public void savePackageImg(MultipartFile multipartFile, Integer getPackageId) {
        if (!multipartFile.isEmpty()) {
            //获取原文件名
            String fileName = multipartFile.getOriginalFilename();
            logger.info(fileName);
            //文件后缀带点
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //新文件名 防止重复
            String name = UUID.randomUUID() + suffix;
            //文件地址
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            logger.info(sourcePath.imgPath);
            //图片的路径
            String imgp = sourcePath.imgPath + name;
            File upload = new File(path.getAbsolutePath(), imgp);
            if (!path.exists())
                path.mkdirs();
            try {
                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(upload));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Picture picture = new Picture();
            picture.setImgUrl(imgp);
            picture.setType("package");
            picture.setImgPid(getPackageId);
            picture.setIsThumb(0);
            fileService.savePic(picture);
        }

    }

  @RequestMapping("/getPackageByGoodId.do")
    public Map<String, Object> getOptionColor(HttpServletRequest request) {
        Map<String, Object> mapColor = null;
        String getProductId = request.getParameter("ProductId");
        Integer productId = Integer.valueOf(getProductId);
        List<Package> getPackages = packageService.getPackageByProductId(productId);
        if (getPackages == null)
            return null;
        else {
            mapColor = new HashMap<>();
            for (int i = 0; i < getPackages.size(); i++) {
                mapColor.put(getPackages.get(i).getPackageId() + "", getPackages.get(i).getTitle());
            }
        }
        return mapColor;
    }

    @RequestMapping("/editorPackage.do")
    public String editorPackage(HttpServletRequest request, @RequestParam("args[file_upload_photo_editor]") MultipartFile multipartFile) throws IOException {
        String getTitle = request.getParameter("product-package-name");
        String getPrice = request.getParameter("product-package-NewPrice");
        Integer getGoodId = Integer.valueOf(request.getParameter("product-good-id"));
        Integer getPackageId = Integer.valueOf(request.getParameter("product-package-id"));
        Goods goods = productService.getGoodsById(getGoodId);
       if(!Matches.numPrice.matches(getPrice))
            return "价格不能非数字";
        //修改color  修改图片
        float price;
        if (StringUtils.isEmpty(getPrice))
            price = goods.getGoodsPrice();
        else {
             if (!getPrice.matches(Matches.numPrice))
                return "价格不能非数字";
            price = Float.parseFloat(getPrice);
        }
        // 修改package
        Package package1 = packageService.getPackageByID(getPackageId);
        //保存图片
        if (!multipartFile.isEmpty())
            updateColorImg(multipartFile, package1.getPackageId());
        package1.setTitle(getTitle);
        package1.setStatus(goods.getStatus());
        package1.setGoodsPrice(price);
        packageService.updatePackage(package1);
        return "修改成功";
    }

    //    保存图片
    public void updateColorImg(MultipartFile multipartFile, Integer getPackageId) {
        if (!multipartFile.isEmpty()) {
            //获取原文件名
            String fileName = multipartFile.getOriginalFilename();
            logger.info(fileName);
            //文件后缀带点
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //新文件名 防止重复
            String name = UUID.randomUUID() + suffix;
            //文件地址
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            logger.info(sourcePath.imgPath);
            //图片的路径
            String imgp = sourcePath.imgPath + name;
            File upload = new File(path.getAbsolutePath(), imgp);
            if (!path.exists())
                path.mkdirs();
            try {
                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(upload));
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean save=false;
            Picture picture = fileService.getPackagePicByImgId(getPackageId);
             if(picture==null)
            {
                picture=new Picture();
                picture.setImgPid(getPackageId);
                picture.setType("package");
                save=true;
            }
            picture.setImgUrl(imgp);
            picture.setIsThumb(0);
                if(save)
              {
                   fileService.savePic(picture);
                   return;
              }
            fileService.updatePic(picture);
        }

    }

 @RequestMapping("/delPackage.do")
    public String delColor(HttpServletRequest request) {
        String getPackageId = request.getParameter("getId");
        if (StringUtils.isEmpty(getPackageId))
            return null;
        Integer packageId = Integer.valueOf(getPackageId);
        try {
            packageService.deletePackage(packageId);
            fileService.delColorById(packageId);
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

}
