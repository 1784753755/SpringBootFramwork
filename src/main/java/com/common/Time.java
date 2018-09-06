package com.common;

import org.springframework.util.StringUtils;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {
    public static final String WEB_URL1 = "http://www.bjtime.cn";// bjTime
	public static final String WEB_URL2 = "http://www.baidu.com";// 百度
	public static final String WEB_URL3 = "http://www.taobao.com";// 淘宝
	public static final String WEB_URL4 = "http://www.ntsc.ac.cn";// 中国科学院国家授时中心
	public static final String WEB_URL5 = "http://www.360.cn";// 360
	public static final String WEB_URL6 = "http://www.beijing-time.org";// beijing-time
	public static final String WEB_URL7 = "http://www.jd.com/";// 京东

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String format = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 根据URL和格式化类型获取时间
	 *
	 * @param webuUrl
	 *            网络URL
	 * @param format
	 *            格式
	 * @return
	 */
	public static String getWebsiteDatetime(String webuUrl, String format) {
		try {
			// 判断当前是否传入URL
			if (!StringUtils.isEmpty(webuUrl)) {
				URL url = new URL(webuUrl);// 获取url对象
				URLConnection uc = url.openConnection();// 获取生成连接对象
				uc.connect();// 发出连接请求
				long ld = uc.getDate();// 读取网站日期时间
				Date date = new Date(ld);// 转化为时间对象
				SimpleDateFormat sdf = new SimpleDateFormat(
						format != null ? format : DEFAULT_FORMAT, Locale.CHINA);// 输出北京时间
				return sdf.format(date);
			} else {
				System.out.println("URL Error!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

  public static String  getCurrentTime(){
    return  getWebsiteDatetime(WEB_URL2, format);

  }
	/**
	 * 测试
	 *
	 * @param args
	 */
	/*public static void main(String[] args) {

		System.out.println(getWebsiteDatetime(WEB_URL1, format)
				+ " [bjtime]");
		System.out.println(getWebsiteDatetime(WEB_URL2, format)
				+ " [百度]");
		System.out.println(getWebsiteDatetime(WEB_URL3, format)
				+ " [淘宝]");
		System.out.println(getWebsiteDatetime(WEB_URL4, format)
				+ " [中国科学院国家授时中心]");
		System.out.println(getWebsiteDatetime(WEB_URL5, format)
				+ " [360安全卫士]");
		System.out.println(getWebsiteDatetime(WEB_URL6, format)
				+ " [beijing-time]");
		System.out.println(getWebsiteDatetime(WEB_URL7, format)
				+ " [京东-time]");
	}*/

	/*比较时间大小*/
	    public static Date FormateDate(String DATE1) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);

         return  dt1;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    return  null;
	    }
}
