package com.service.impl;

import com.dao.FileDao;
import com.model.Picture;
import com.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FileServiceImpl implements FileService{
@Autowired
private FileDao fileDao;

    @Override
    public void savePic(Picture picture) {
       fileDao.savePic(picture);
    }

    @Override
    public Picture getPic(Integer id) {
        return fileDao.getPic(id);
    }

    @Override
    public void updatePic(Picture picture) {
          fileDao.updatePic(picture);
    }

    @Override
    public void DelPic(Integer id) {

    }

    @Override
    public Integer getThumPicId(String picPath)
    {
        return  fileDao.getIdByPath(picPath);
    }

    @Override
    public Picture getPicByImgId(Integer getColorId) {
        return fileDao.gePicByImgId(getColorId);
    }

    @Override
    public Picture getPackagePicByImgId(Integer getPackageId) {
        return fileDao.getPackagePicById(getPackageId);
    }

    @Override
    public void delColorById(Integer colorId) {
        fileDao.DelPic(colorId);
    }


}
