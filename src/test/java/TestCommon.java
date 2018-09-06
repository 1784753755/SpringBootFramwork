import com.common.SystemOut;
import org.junit.Test;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCommon {
@Test
    public void test() {
        String testTxt = "个文件";
        String getsString = "1231313xx";
        //  注意[\u4E00-\u9FA5]里面的斜杠字符，千万不可省略，不区分大小写
        /* Pattern pat = Pattern.compile("^[\u4E00-\u9FA5]{3}$");

        Matcher mat = pat.matcher(testTxt);

        if(mat.matches()) {
            System.out.println(mat.group(0));
        }*/

        Pattern pat = Pattern.compile("^(\\d){0,}$");
        Matcher mat = pat.matcher(getsString);
        if (mat.matches()) {
            System.out.println(mat.group(0));
        } else
            SystemOut.show("Wrong");
    }

    //正则表达
    public void Regex() {
        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);


    }

    @Test
    public void testDate() {
       

    }

}
