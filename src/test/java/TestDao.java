import com.DemoApplication;
import com.common.SystemOut;
import com.dao.*;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.ProductCategoryService;
import com.service.SelectPageService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class TestDao {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private com.dao.TestDao testDao;
    @Autowired
    private ConfigDao configDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private FileDao fileDao;
    @Autowired
    private  PackageDao packageDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    //   @Test
    public void getAdmin() {
        List<Admin> ls = this.adminDao.getAdmins();

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        for (int i = 0; i < ls.size(); i++) {

            System.out.println(bf.format(ls.get(i).getAddTime()));
        }
    }

    // @Test
    public void addAdmin() {
        Admin a = new Admin();
        a.setAdminId(30);
        a.setName("admin_30");
        this.adminDao.addAdmin(a);
    }


    // @Test
    public void getConfig() {
        List<Config> ls = this.configDao.getConfig();
        for (int i = 0; i < ls.size(); i++) {
            SystemOut.show(ls.get(i).toString());
        }
    }

    // @Test
    public void getGoods() {
//       查询所有商品的列表需要啊经过SelectPageService
        PageInfo pageInfo = selectPageService.selectGoods(3, 2);
    }

    @Autowired
    HttpServletRequest request;

    //@Test
    public void addGoods() {
        URL url = this.getClass().getClassLoader().getResource("file");
        System.out.println("URL:" + request.getServletContext().getRealPath("/"));

    }
    @Test
    public  void testFileDao(){

        orderDetailDao.getDetailByOrderNum("LG15272331598388");
    }
}
