package com.dao;

import com.model.Picture;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FileDao {
    //    保存pic
    void savePic(Picture picture);

    //     获取pic
    Picture getPic(@Param("ID") Integer id);

    //    更新pic
    void updatePic(Picture picture);

    //     删除pic
    void DelPic(Integer id);
    //    获取全部
    List<Picture> getAll();
  //获取id 根据id
    Integer getIdByPath(String path);


    Picture gePicByImgId(Integer getColorId);

    Picture getPackagePicById(Integer getPackageId);
}
