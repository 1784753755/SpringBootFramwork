package com.controller;

import com.common.Matches;
import com.common.Path;
import com.model.Color;
import com.model.Goods;
import com.model.Picture;
import com.service.ColorService;
import com.service.FileService;
import com.service.ProductService;
import org.apache.ibatis.annotations.Param;
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
public class ColorController {
    public static Logger logger = LogManager.getLogger(ColorController.class);
    @Autowired
    ColorService colorService;
    @Autowired
    private Path sourcePath;
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/getAllColor.do")
    public void getAllColor() {
        List<Color> getlist = colorService.getAllColor();
        logger.info(getlist);
    }

    @RequestMapping("/addColor.do")
    public String addColor(HttpServletRequest request, @RequestParam("args[file_upload_photo]") MultipartFile multipartFile) throws IOException {

        String getTitle = request.getParameter("product-color-writeColor");
        String getPrice = request.getParameter("product-color-price");

        Integer getGoodId = Integer.valueOf(request.getParameter("product-good-id"));
        Goods goods = productService.getGoodsById(getGoodId);
        float price;
        if (StringUtils.isEmpty(getPrice)) {
            price = goods.getGoodsPrice();
        } else {
            if (!getPrice.matches(Matches.numPrice))
                return "价格不能非数字";
            price = Float.parseFloat(getPrice);
        }

        //保存图片
        List<Color> getColors = colorService.getColorByProductId(goods.getGoodsId());
        for (int i = 0; i < getColors.size(); i++) {
            if (getTitle.trim().matches(getColors.get(i).getTitle()))
                return "颜色重复";
        }
        Color color = new Color();
        color.setTitle(getTitle);
        color.setGoodsId(goods.getGoodsId());
        color.setStatus(goods.getStatus());
        color.setGoodsPrice(price);
        color.setType(goods.getType());
        colorService.insertColor(color);
        Color color1 = colorService.getColorByProductIdAndTitle(goods.getGoodsId(), getTitle);

        saveColorImg(multipartFile, color1.getColorId());
        return "添加成功";
    }

    @RequestMapping("/editorColor.do")
    public String editorColor(HttpServletRequest request, @RequestParam("args[file_upload_photo_editor]") MultipartFile multipartFile) throws IOException {
        try {
            String getTitle = request.getParameter("product-color-name");
            String getPrice = request.getParameter("product-color-NewPrice");
            Integer getGoodId = Integer.valueOf(request.getParameter("product-good-id"));
            Integer getColorId = Integer.valueOf(request.getParameter("product-color-id"));
            Goods goods = productService.getGoodsById(getGoodId);

            //修改color  修改图片
            float price;
            if (StringUtils.isEmpty(getPrice))
                price = goods.getGoodsPrice();
            else {
                 if (!getPrice.matches(Matches.numPrice))
                return "价格不能非数字";
                price = Float.parseFloat(getPrice);
            }
            // 修改color
            Color color = colorService.getColorByID(getColorId);
            //保存图片
            if (!multipartFile.isEmpty())
                updateColorImg(multipartFile, color.getColorId());
            color.setTitle(getTitle);
            color.setStatus(goods.getStatus());
            color.setGoodsPrice(price);
            colorService.updateColor(color);
            return "修改成功";
        } catch (Exception e) {
            return null;
        }
    }

    //    保存图片
    public void updateColorImg(MultipartFile multipartFile, Integer getColorId) {
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
            if (!path.exists())
                path.mkdirs();
            File upload = new File(path.getAbsolutePath(), imgp);
            try {
                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(upload));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Picture picture = fileService.getPicByImgId(getColorId);
            boolean save = false;

            if (picture == null) {
                picture = new Picture();
                picture.setImgPid(getColorId);
                picture.setType("color");
                save = true;
            }
            picture.setImgUrl(imgp);
            picture.setIsThumb(0);
            if (save) {
                fileService.savePic(picture);
                return;
            }
            fileService.updatePic(picture);
        }

    }

    public void saveColorImg(MultipartFile multipartFile, Integer getColorId) {
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
            picture.setType("color");
            picture.setImgPid(getColorId);
            picture.setIsThumb(0);
            fileService.savePic(picture);
        }

    }

    @RequestMapping("/delColor.do")
    public String delColor(HttpServletRequest request) {
        String getColorId = request.getParameter("getId");
        if (StringUtils.isEmpty(getColorId))
            return null;
        Integer colorId = Integer.valueOf(getColorId);
        try {
            colorService.deleteColor(colorId);
            fileService.delColorById(colorId);
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/getColorByGoodId.do")
    public Map<String, Object> getOptionColor(HttpServletRequest request) {
        Map<String, Object> mapColor = null;
        String getProductId = request.getParameter("ProductId");
        Integer productId = Integer.valueOf(getProductId);
        List<Color> getColors = colorService.getColorByProductId(productId);
        if (getColors == null)
            return null;
        else {
            mapColor = new HashMap<>();
            for (int i = 0; i < getColors.size(); i++) {
                mapColor.put(getColors.get(i).getColorId() + "", getColors.get(i).getTitle());
            }
        }
        return mapColor;
    }
}
