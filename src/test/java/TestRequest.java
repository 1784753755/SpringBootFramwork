import com.DemoApplication;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class TestRequest {
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


        /*this.mvc.perform(MockMvcRequestBuilders.get("/getClassTable").accept(MediaType.APPLICATION_JSON).param("scl", "福建工程学院")
                .param("cole", "国脉信息学院").param("dept", "计科系")
                .param("prof", "软工").param("aclass", "1503")
                .param("ud", "up").param("scly", "2018"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
       /* mvc.perform(MockMvcRequestBuilders.get("/helloSb").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
       /**/
      /*  mvc.perform(MockMvcRequestBuilders.get("/forProCategories.do").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
     /*   mvc.perform(MockMvcRequestBuilders.get("/updateProductImg.do").accept(MediaType.APPLICATION_JSON).param("imgpath", "/static/images/upload/addProduct/7738425a-e4a3-4667-a146-58aedaa69c7b.jpg").param("productId",341+""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
        mvc.perform(MockMvcRequestBuilders.get("/getAllAuthorGroup.do").accept(MediaType.APPLICATION_JSON).param("pageSize","5").param("pageIndex","1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

         /* mvc.perform(MockMvcRequestBuilders.get("/getOrderDetailByName.test").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/

    }
}
