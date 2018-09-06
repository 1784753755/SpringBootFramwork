package com.service;

import com.model.Color;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorService {
    /*查询*/
    List<Color> getAllColor();
    /*增加*/
    void  insertColor(Color color) ;
    /*查询*/
    Color selectColorById(Integer id);
    /*删除*/
    void  deleteColor(Integer id);
    /*修改*/
    void updateColor(Color color);

    List<Color> getColorByProductId(Integer productId);
    Color getColorByID(Integer id);

    Color getColorByProductIdAndTitle(Integer goodsId, String getTitle);
}
