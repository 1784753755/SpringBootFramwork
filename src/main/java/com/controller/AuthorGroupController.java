package com.controller;

import com.common.GetIp;
import com.common.Time;
import com.github.pagehelper.PageInfo;
import com.model.Admin;
import com.model.AuthorGroup;
import com.service.AdminService;
import com.service.AuthorService;
import com.service.impl.SelectPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class AuthorGroupController {
    public static Logger logger = LogManager.getLogger(AuthorGroupController.class);
    /*public static Logger logger = LogManager.getLogger(ProductResController.class);public static Logger logger = LogManager.getLogger(ProductResController.class);*/
    @Autowired
    private AuthorService authorService;
    @Autowired
    private SelectPage selectPage;
    @Autowired
    private AdminService adminService;
   @Autowired
    private GetIp getIp;
    @RequestMapping("/addAuthorGroup.do")
    public String addAuthorGroup(HttpServletRequest request) throws UnknownHostException {
        String getDoamainName=request.getParameter("product-domain-name");
        if(getDoamainName==null)return "域名为空";
        if(ifExitDomain(getDoamainName))return "域名重复";
        String getUserName=request.getParameter("product-user-name");
         if(getUserName==null)return "用户名为空";
        String getProductGroup=request.getParameter("product-group");
         if(getProductGroup==null)return "分组为空";
        String getArgsType=request.getParameter("args[type]");
         if(Integer.valueOf(getArgsType)==0)return "类型为空";
        String getArgsStatus=request.getParameter("args[status]");
         if(Integer.valueOf(getArgsStatus)==0)return "运营为空";
        String getOrderValue=request.getParameter("product-order-value");
         if(getOrderValue==null)return "排序值为空";
        String getArgsRestate=request.getParameter("args[restate]");
         AuthorGroup authorGroup=new AuthorGroup();

        /* 重新自动添加一个账户 authorGroup.setAdmin();*/

        authorGroup.setAddTime(Time.getCurrentTime());
        authorGroup.setStatus(Integer.valueOf(getArgsRestate));
        authorGroup.setList(Integer.valueOf(getOrderValue));
        authorGroup.setMovement(Integer.valueOf(getArgsStatus)==1?"已运营":"未运营");
        authorGroup.setType(getArgsType);
        authorGroup.setGrouping(getProductGroup);
        authorGroup.setWebUrl(getDoamainName);
        authorGroup.setWebNames(getUserName);
        if(authorService.saveAuthorGroup(authorGroup,getIp.showCurrentIp(request)))
            return "添加成功";
       /* authorService.saveAuthorGroup(authorGroup);*/
        return "添加失败";
    }
    public  boolean ifExitDomain(String getDoaminName){
        /*false 不存在 true  存在*/
        return authorService.selectDomain(getDoaminName);
    }

    @RequestMapping("/editorAuthorGroup.do")
    public  String updateAuthorGroup(HttpServletRequest request){
     String getId=request.getParameter("product-author-id");
    String getDoamainName=request.getParameter("product-domain-name");
        if(getDoamainName==null)return "域名为空";
        String getUserName=request.getParameter("product-user-name");
         if(getUserName==null)return "用户名为空";
        String getProductGroup=request.getParameter("product-group");
         if(getProductGroup==null)return "分组为空";
        String getArgsType=request.getParameter("args[type]");
         if(Integer.valueOf(getArgsType)==0)return "类型为空";
        String getArgsStatus=request.getParameter("args[status]");
         if(Integer.valueOf(getArgsStatus)==0)return "运营为空";
        String getOrderValue=request.getParameter("product-order-value");
         if(getOrderValue==null)return "排序值为空";
        String getArgsRestate=request.getParameter("args[restate]");
         AuthorGroup authorGroup=authorService.getAuthorById(Integer.valueOf(getId));

        /* 重新自动添加一个账户 authorGroup.setAdmin();*/
        authorGroup.setStatus(Integer.valueOf(getArgsRestate));
        authorGroup.setList(Integer.valueOf(getOrderValue));
        authorGroup.setMovement(Integer.valueOf(getArgsStatus)==1?"已运营":"未运营");
        authorGroup.setType(getArgsType);
        authorGroup.setGrouping(getProductGroup);
        authorGroup.setWebUrl(getDoamainName);
        authorGroup.setWebNames(getUserName);
       try{
           authorService.updateService(authorGroup);
            return "添加成功";}catch (Exception e){
               return "添加失败";
       }
    }
    @RequestMapping("/getAllAuthorGroup.do")
    public List<AuthorGroup> getAllAuthorGroup(HttpServletRequest request) {
        String getPageSize = request.getParameter("pageSize");
        String getPageIndex = request.getParameter("pageIndex");
        Integer pageSize = getPageSize == null ? 10 : Integer.valueOf(getPageSize);
        Integer pageIndex = getPageIndex == null ? 10 : Integer.valueOf(getPageIndex);
        PageInfo<AuthorGroup> pageInfo;

        pageInfo = selectPage.selectAuthorGroup(pageSize, pageIndex);
       for (int i = 0; i < pageInfo.getList().size(); i++) {
            logger.info(pageInfo.getList().get(i).toString());
            Integer uid = pageInfo.getList().get(i).getUid();
            Admin admin = (Admin) adminService.getAdminById(uid);
            pageInfo.getList().get(i).setAdmin(admin);
        }
  /*    List<AuthorGroup> list=pageInfo.getList();
   for (int i = 0; i <list.size(); i++) {
              logger.info(list.get(i).toString());
            Integer uid = list.get(i).getUid();
            Admin admin = (Admin) adminService.getAdminById(uid);
           list.get(i).setAdmin(admin);
        }*/
        return  pageInfo.getList();
    }

    @RequestMapping("/getAuthorGroupCount.do")
    public Integer getCountAuthorGroup() {
        return authorService.getCount();
    }

    @RequestMapping("/limitAuthorGroup.do")
    public String upDateStatus(HttpServletRequest request) {
        try {
            String getId = request.getParameter("id");
            AuthorGroup authorGroup = authorService.getAuthorById(Integer.valueOf(getId));
            if (authorGroup.getStatus() == 1)
                authorGroup.setStatus(0);
            else
                authorGroup.setStatus(1);
            authorService.updateService(authorGroup);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
    }

    @RequestMapping("/deleteGroup.do")
    public String deleteStatus(HttpServletRequest request) {
        try {
            String getId = request.getParameter("id");
            authorService.deleteGroup(Integer.valueOf(getId));
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }
     @RequestMapping("/getAuthorGroupById.do")
     public  AuthorGroup getAuthorGroupById(HttpServletRequest request){
        String getId= request.getParameter("getID");
       AuthorGroup authorGroup= authorService.getAuthorById(Integer.valueOf(getId));
       if (authorGroup==null)
           return null;
      Admin admin= adminService.getAdminById(authorGroup.getUid());
      authorGroup.setAdmin(admin);
      return  authorGroup;
    }

    @RequestMapping("/getAuthorByName.do")
    public  List<AuthorGroup> getAuthorGroupByMethod(HttpServletRequest request){
         List<AuthorGroup> getList=null;
        /*获取的字段*/
        String getText=request.getParameter("way");
        /*查询的方式*/
        String  getMethod= request.getParameter("method");
        switch (getMethod){
            case "1":{
             getList= authorService.getAuthorByName(getText.trim());
                break;
            }
            case "2":{
                getList= authorService.getAuthorByGroup(getText.trim());
                  break;
            }
            case "3":{
                getList= authorService.getAuthorByType(getText.trim());
                  break;
            }
            case "4":{
                getList= authorService.getAuthorByMoveMent(getText.trim());
                  break;
            }
        }

        if(getList!=null){
             for (int i = 0; i < getList.size(); i++) {

            Integer uid = getList.get(i).getUid();
            Admin admin = (Admin) adminService.getAdminById(uid);
            getList.get(i).setAdmin(admin);
        }
        }

        return getList;
    }
}
