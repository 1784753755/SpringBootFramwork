package com.controller;

import com.common.RandomValidateCodeUtil;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


@RestController
public class ValidateCodeController {
    @Autowired
    private RandomValidateCodeUtil randomValidateCodeUtil;
    public static Logger logger = LogManager.getLogger(ValidateCodeController.class);

    @RequestMapping("/getValidateImg.do")
    public void getValidateImg(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);

            randomValidateCodeUtil.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }

    /*@RequestMapping("/getTestImg.test")
    public void getTestImg(HttpServletResponse response){
        response.setContentType("image/png");
        //告诉浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        BufferedImage bufferedImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics g=  bufferedImage.getGraphics();
        Color color=new Color(121,165,131);
        g.setColor(color);
        g.setFont(new Font("方正舒体",Font.BOLD,12));

        try {
            ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

