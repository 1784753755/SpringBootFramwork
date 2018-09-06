package com.controller;

import com.model.Color;
import com.model.Package;
import com.model.Picture;
import com.service.ColorService;
import com.service.FileService;
import com.service.PackageService;
import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private ColorService colorService;
   @Autowired
   private PackageService packageService;
    @RequestMapping("/getPic.do")
    public Map<String, Object> getPicPathPackage(HttpServletRequest request) {

        Map<String, Object> model = new HashMap<>();
        String getId = request.getParameter("getID");
        String getType = request.getParameter("type");

        Integer Id = getId == null ? -1 : Integer.valueOf(getId);

        if (Id == null)
            return null;
        //这是一对一
        Picture picture;
        if (getType.matches("color")) {
            Color color = colorService.getColorByID(Id);
            picture = fileService.getPicByImgId(Id);
            if (picture == null)
                return null;
            model.put(picture.getImgUrl(), color.getGoodsPrice());
        }
        else if(getType.matches("package"))
        {

            Package aPackage = packageService.getPackageByID(Id);
            picture = fileService.getPackagePicByImgId(Id);
            if (picture == null)
                return null;
            model.put(picture.getImgUrl(), aPackage.getGoodsPrice());
        }
        return model;
    }

   /* @RequestMapping("/getPic.do")
    public Map<String, Object> getPicPath(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        String getColorId = request.getParameter("getID");
        Integer colorId = getColorId == null ? -1 : Integer.valueOf(getColorId);
        if (colorId == null)
            return null;
        //这是一对一
        Color color = colorService.getColorByID(colorId);
        Picture picture = fileService.getPicByImgId(colorId);
        if (picture == null)
            return null;
        model.put(picture.getImgUrl(), color.getGoodsPrice());
        return model;
    }*/


}
