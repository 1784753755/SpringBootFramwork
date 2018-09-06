package com.service;

import com.model.Picture;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

@Service
public interface FileService {
     void savePic(Picture picture);
     Picture getPic(Integer id);
     void updatePic(Picture picture);
     void DelPic(Integer id);
     Integer getThumPicId(String picPath);


     Picture getPicByImgId(Integer getColorId);
      Picture getPackagePicByImgId(Integer getPackageId);

    void delColorById(Integer colorId);
    //根据img_pid 和 title 来抓取图片
}
