package com.common;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QRcode {
@RequestMapping("/getQRcode.do")
    public String getqrCode() {
        Random random = new Random();
        List<Object> list=new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            list.add((int)random.nextInt(10));
        }

        for (int j = 0; j < 2; j++) {
            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写还是小写
           list.add((char) (choice + random.nextInt(26)));
        }

    return  list.toString();
    }


}
