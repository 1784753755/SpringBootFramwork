package com.dao;

import com.model.Color;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColorDao {

    List<Color> getAllColor();

    void addColor(Color color);

    Color getColorById(Integer id);

    void delColor(Integer id);

    void updateColor(Color color);

    List<Color> getColorByProductId(Integer ProductId);

    Color getColorByProductIdAndTitle(@Param("GID") Integer goodsId,@Param("Title") String getTitle);
}
