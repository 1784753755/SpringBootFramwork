package com.controller;

import com.common.Path;
import com.common.Time;
import com.github.pagehelper.PageInfo;
import com.model.Goods;
import com.model.ProductCategory;
import com.service.ProductCategoryService;
import com.service.SelectPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/*产品类别的添加*/
@RestController
public class ProductCategoryController {
    @Autowired
    private Path sourcePath;

    /*@Value("${com.img.path}")
    private String imgPath(imgPath=Path.imgPath);
    */
    public static Logger logger = LogManager.getLogger(ProductCategoryController.class);
    /*分页查询*/
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private ProductCategoryService productCategoryService;
    /*默认给它10页码的分页*/
    private Integer pageSize = 10;
    private Integer pageIndex = 1;

    @RequestMapping("/forProCategories.do")
    public Map<String, Object> forProductCategory() {

        Map<String, Object> model = new HashMap<>();
        List<ProductCategory> getListCategory = productCategoryService.getProductCategories();
        {
            for (int i = 0; i < getListCategory.size(); i++) {
                model.put(getListCategory.get(i).getCategoryId() + "", getListCategory.get(i).getTitle());//model
            }
        }
        logger.info(model.toString());
        logger.info(model.size());
        return model;
    }

    /*分页*/
    @RequestMapping("/getPageInfoProductCategories.do")
    public List<ProductCategory> getProductCategories(Map<String, Object> model, HttpServletRequest request) throws Exception {

        /*每页显示*/
        String getPageSize = request.getParameter("pageSize");
        pageSize = getPageSize == null ? pageSize : Integer.valueOf(getPageSize);
        /*页码*/
        String getPageIndex = request.getParameter("pageIndex");
        pageIndex = getPageIndex == null ? pageIndex : Integer.valueOf(getPageIndex);
        //获取产品  准备分页
        PageInfo<ProductCategory> pageInfo = selectPageService.selectProductCategory(pageSize, pageIndex);

        List<ProductCategory> list = new ArrayList<ProductCategory>();
        ProductCategory category;
        for (int i = 0; i < pageInfo.getList().size(); i++) {
            category = new ProductCategory();
            category.setUid(pageInfo.getList().get(i).getUid());
            category.setCreateTime(pageInfo.getList().get(i).getCreateTime());
            category.setTitle(pageInfo.getList().get(i).getTitle());
            category.setImg(pageInfo.getList().get(i).getImg());
            category.setUpper(pageInfo.getList().get(i).getUpper());
            category.setList(pageInfo.getList().get(i).getList());
            category.setType(pageInfo.getList().get(i).getType());
            category.setCategoryId(pageInfo.getList().get(i).getCategoryId());
            category.setStatus(pageInfo.getList().get(i).getStatus());
            list.add(category);
        }
        return list;
    }

    @RequestMapping("/getCategoryCount.do")
    public String getCount() {
        /*  制作列表页*/
        int allCount = productCategoryService.Count();
        /* 将数据传回前台制作列表*/
        return allCount + "";
    }

    @RequestMapping("/limitStatus.do")
    public String changeStatus(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id == null)
            return "ok msg is wrong just do it again!";
        Integer categoryId = Integer.valueOf(id);
        ProductCategory productCategory = productCategoryService.getProductCategoryById(categoryId);
        Integer status = Integer.valueOf(productCategory.getStatus()) == 1 ? 0 : 1;
        productCategory.setStatus(status);
        productCategoryService.EditProductCategory(productCategory);
        return "修改成功";
    }
    @RequestMapping("/limitType.do")
    public String changeType(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id == null)
            return "ok msg is wrong just do it again!";
        Integer categoryId = Integer.valueOf(id);
        ProductCategory productCategory = productCategoryService.getProductCategoryById(categoryId);
        Integer type = Integer.valueOf(productCategory.getType()) == 1 ? 0 : 1;
        productCategory.setType(type);
        productCategoryService.EditProductCategory(productCategory);
        return "修改成功";
    }

    @RequestMapping("/addProductCategory.do")
    public String addProductCategory(@RequestParam("args[file_upload_photo]") MultipartFile file, HttpServletRequest request) throws Exception {
        Logger msg = LogManager.getLogger(Test.class);
        String img = "";
        boolean getImg=false;
        String getCategoryId=request.getParameter("product-category-id");
        Integer categoryid=getCategoryId==null?null:Integer.valueOf(getCategoryId);
        String categoryName = request.getParameter("product-category-name");
        if (StringUtils.isEmpty(categoryName)) return "wrong";
        String categoryOrderValue = request.getParameter("product-category-order-value");
        Integer orderValue = categoryOrderValue == null ? 0 : Integer.valueOf(categoryOrderValue);
        if (!file.isEmpty()) {
            try {
                //获取原文件名
                String fileName = file.getOriginalFilename();
                msg.info(fileName);
                //文件后缀带点
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //新文件名 防止重复
                String name = UUID.randomUUID() + suffix;
                //文件地址
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                //存储img路径
                img = sourcePath.imgPath + name;
                File upload = new File(path.getAbsolutePath(), sourcePath.imgPath + name);
                if (!path.exists())
                    path.mkdirs();
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(upload));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       else
          getImg=true;

        ProductCategory productCategory;
        if(categoryid==null)
            productCategory=new ProductCategory();
        else
            productCategory=productCategoryService.getProductCategoryById(categoryid);

        if(getImg){
            img=productCategory.getImg();
        }
        productCategory.setTitle(categoryName);
        productCategory.setImg(img);
        productCategory.setCreateTime(Time.getCurrentTime());
        /*显示状态*/
        productCategory.setList(orderValue);
        productCategory.setUid(0);
        //service 层直接存储起来
        if(categoryid==null){
              productCategoryService.AddProductCategory(productCategory);
               return "添加成功";
        }

        else
            productCategoryService.EditProductCategory(productCategory);

        return "修改成功";

    }

    @RequestMapping("/delCategory.do")
    public String DeleteProCate(HttpServletRequest request) {
        String getId = request.getParameter("id");

        if (StringUtils.isEmpty(getId))
            return "删除出错";
        Integer id = Integer.valueOf(getId);

        //services层进删除
        productCategoryService.Delete(id);
        return "删除成功";
    }

    @RequestMapping("/getCategoryById.do")
    public ProductCategory getCategoryById(HttpServletRequest request){
        String  getId=request.getParameter("id");
        Integer id=Integer.valueOf(getId);
        if (id==null)
            return  null;
        ProductCategory productCategory=productCategoryService.getProductCategoryById(id);
        return productCategory;
    }

}
