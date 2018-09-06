import com.common.SystemOut;
import org.junit.Test;

public class TestKey {
    @Test
    public void test(){
        String key=TestBase64.encode("Nice");
        SystemOut.show(key);
        SystemOut.show(TestBase64.decode(key));
    }
}
