

import com.DemoApplication;
import com.common.SystemOut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class Testpath {
    @Value("${com.img.path}")
    String imgPath;
    @Test
    public void show() throws SocketException {

    }
}
