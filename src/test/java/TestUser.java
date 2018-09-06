import com.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.DemoApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
        /*老版本@SpringApplicationConfiguration被取代掉了@SpringBootTest*/
@SpringBootTest(classes = DemoApplication.class)
public class TestUser {
    /*获取properties注释中value*/
   /* @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;*/

    //省略getter settet方法
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception {
        //这里实例化是的是全局类
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
  /*  @Before
    public void setUp() throws Exception {
//        通过构建请求实例 模拟服务请求 这里只是实例化一个类
        mvc = MockMvcBuilders.standaloneSetup(new ClassTableController()).build();
    }*/

    @Test
    public void getHello() throws Exception {
       /* System.out.println(title.toString());
        System.out.println(title+"-我的-"+description);*/

       /*  String scl = request.getParameter("scl");
        /*学院*/
        //  String cole = request.getParameter("cole");
        //  /*系别*/
        //   String dept = request.getParameter("dept");
        /*专业*/
//        /*班级*/
        //  String aclass = request.getParameter("aclass");
        /*学年*/
        // String scly = request.getParameter("scly");*/

       /* mvc.perform(MockMvcRequestBuilders.get("/login").accept(MediaType.APPLICATION_JSON).param("username","3158900").param("pwd","123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
        this.mvc.perform(MockMvcRequestBuilders.get("/getMyTable").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
