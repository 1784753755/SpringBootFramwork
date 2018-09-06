package com.displayController;

import com.common.Matches;
import com.common.Path;
import com.controller.ProductController;
import com.model.Goods;
import com.model.domain.DomainProduct;
import com.service.FileService;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.SelectPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductControllerShow {
     public static Logger logger = LogManager.getLogger(ProductController.class);
    /* 当前行号  Current.currentLine(    Thread.currentThread().getStackTrace());*/
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService;
    @Autowired
    private Path sourcePath;
    @RequestMapping("/getProduct.html")
    public List<DomainProduct> showProduct(){

        return  productService.getGoodsDisplay();
    }
     @RequestMapping("/getProductById.html")
    public  DomainProduct detailProduct(HttpServletRequest request){
        String id=request.getParameter("productId");
        if(id==null||!id.matches(Matches.num))
            return null ;

        return  productService.getGoodsDisplayById(Integer.valueOf(id));
    }


}
