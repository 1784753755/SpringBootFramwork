package com.service.impl;

import com.common.Matches;
import com.dao.GoodsDao;
import com.model.Color;
import com.model.Goods;
import com.model.Package;
import com.model.Picture;
import com.model.domain.DomainProduct;
import com.service.ColorService;
import com.service.FileService;
import com.service.PackageService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private FileService fileService;

    @Autowired
    private ColorService colorService;
    @Autowired
    private PackageService packageService;

    @Override
    public int countNum() {
        int num = goodsDao.getCountNum();
        return num;
    }

    @Override
    public Goods getGoodsById(int id) {
        Goods goods = goodsDao.getGoodsById(id);
        return goods;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.setGoods(goods);
    }

    @Override
    public void upDates(Goods goods) {
        goodsDao.updateGood(goods);
    }

    @Override
    public void delProduct(Integer productId) {
        goodsDao.delGoods(productId);
    }

    @Override
    public int countNumByCategory(int categoryId) {
        return goodsDao.getCountNumByCategory(categoryId);
    }

    @Override
    public List<Goods> getGoodsByName(String getName) {
        return goodsDao.getGoodsByName(getName);
    }


    /*前台展示一下*/
    @Override
    public List<DomainProduct> getGoodsDisplay() {
        List<Goods> getGoods = goodsDao.getProductDisplay();
        List<DomainProduct> domainProducts = new ArrayList<>();
        DomainProduct domainProduct;
        for (int i = 0; i < getGoods.size(); i++) {
            domainProduct = new DomainProduct();
            domainProduct.setNowPrice(getGoods.get(i).getGoodsPrice());
            domainProduct.setOldPrice(getGoods.get(i).getGoodsOldPrice());
            domainProduct.setName(getGoods.get(i).getTitle());
            domainProduct.setNum(getGoods.get(i).getGoodsStore());
            domainProduct.setId(getGoods.get(i).getGoodsId());
            Integer imgM = getGoods.get(i).getGoodsImg();
            Picture picture = fileService.getPic(imgM);
            if (picture != null)
                domainProduct.setImgMain(picture.getImgUrl());
            domainProducts.add(domainProduct);

        }
        return domainProducts;
    }

    @Override
    public DomainProduct getGoodsDisplayById(Integer productId) {
        Goods goods = goodsDao.getGoodsById(productId);
        if (goods == null)
            return null;
        DomainProduct domainProduct = new DomainProduct();
        Integer imgM = goods.getGoodsImg();
        Picture picture = fileService.getPic(imgM);
        if (picture != null)
            domainProduct.setImgMain(picture.getImgUrl());
        domainProduct.setImgList(getPicByIds(goods.getGoodsListImg().split(",")));
        domainProduct.setNum(goods.getGoodsStore());
        domainProduct.setDetail(goods.getGoodsDetail());
        List<Color> colors = colorService.getColorByProductId(goods.getGoodsId());
        if (colors != null)
            domainProduct.setColor(colors);
        List<Package> packages = packageService.getPackageByProductId(goods.getGoodsId());
        if (packages != null)
            domainProduct.setaPackage(packages);
        domainProduct.setNowPrice(goods.getGoodsPrice());
        domainProduct.setOldPrice(goods.getGoodsOldPrice());
        domainProduct.setName(goods.getTitle());
        domainProduct.setId(goods.getGoodsId());
        return domainProduct;
    }

    public List<String> getPicByIds(String[] imgs) {
        List<String> pictures = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            if (imgs[i].trim().matches(Matches.num)) {
                Picture picture = fileService.getPic(Integer.valueOf(imgs[i]));
                if (picture != null) {
                    pictures.add(picture.getImgUrl());
                }
            }
        }
        return pictures;
    }
}
