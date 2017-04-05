package com.adv.manager.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


/**
 * 
* <p>Title: HttpTookit</p>
* <p>Description: 模拟http的get请求</p>
* <p>Company: www.hatchbeen.com</p> 
* @author zhanqq
* @date 2017年1月10日 下午2:21:10
 */
public class HttpTookit {
	
	public static String sendGet(String url, String param) {
	    String result = "";
	    BufferedReader in = null;
	    try {
	        String urlNameString = url + "?" + param;
	        URL realUrl = new URL(urlNameString);
	        // 打开和URL之间的连接
	        URLConnection connection = realUrl.openConnection();
	        // 设置通用的请求属性
	        connection.setRequestProperty("Accept", "text/xml,text/javascript,text/html,application/json");
	        connection.setRequestProperty("connection", "Keep-Alive");
	        connection.setRequestProperty("user-agent",
	                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

	        connection.setDoInput(true);
	        connection.setDoOutput(true);

	        // 建立实际的连接

	            connection.connect();
	            // 获取所有响应头字段
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 遍历所有的响应头字段
	            for (String key : map.keySet()) {
	                System.out.println(key + "--->" + map.get(key));
	            }
	            InputStream inputStream = null;
	            InputStreamReader inputStreamReader = null;
	            BufferedReader reader = null;
	            StringBuffer resultBuffer = new StringBuffer();
	            String tempLine = null;


	            inputStream = connection.getInputStream();
	            inputStreamReader = new InputStreamReader(inputStream);
	            reader = new BufferedReader(inputStreamReader);

	            while ((tempLine = reader.readLine()) != null) {
	                resultBuffer.append(tempLine);
	            }
	        result=  resultBuffer.toString();

	        } catch (Exception e) {
	            System.out.println("发送GET请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输入流
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return result;
	    }

}
