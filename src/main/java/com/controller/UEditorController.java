package com.controller;

        import com.baidu.ueditor.ActionEnters;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

/**
 * Use for UeDitor
 * 用于文本编辑器提交模板资源
 * Created by ldb on 2017/4/9.
 */
@Controller
public class UEditorController {


    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath ="src/main/resources/static/images/upload/";
        try {
            String exec = new ActionEnters(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/addProduct.do")
    public  String  AddProduct(){
        return "/index";
    }
}
