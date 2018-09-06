package com.service.impl;

import com.dao.ColorDao;
import com.model.Color;
import com.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorDao colorDao;
    @Override
    public List<Color> getAllColor() {

        return colorDao.getAllColor();
    }

    @Override
    public void insertColor(Color color) {
        colorDao.addColor(color);
    }

    @Override
    public Color selectColorById(Integer id) {
        return colorDao.getColorById(id);
    }

    @Override
    public void deleteColor(Integer id) {
         colorDao.delColor(id);
    }

    @Override
    public void updateColor(Color color) {
        colorDao.updateColor(color);
    }

    @Override
    public List<Color> getColorByProductId(Integer productId) {
        return colorDao.getColorByProductId(productId);
    }

    @Override
    public Color getColorByID(Integer id) {
        return colorDao.getColorById(id);
    }

    @Override
    public Color getColorByProductIdAndTitle(Integer goodsId, String getTitle) {
       return colorDao.getColorByProductIdAndTitle( goodsId,  getTitle);
    }
}
