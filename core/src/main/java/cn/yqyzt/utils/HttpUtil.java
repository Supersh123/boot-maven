package cn.yqyzt.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 *@Author:shenhao on 2020/1/9 23:46
 *@Description: Http、Https 请求工具类
 */
@Slf4j
public class HttpUtil {

    /**
     *@Author:shenhao on 2020/1/9 23:50
     *@param: urls 请求地址
     *        type 请求方式 POST 或者 GET
     *        paramsMap 请求参数
     *@return: String 响应报文
     *@Description: 发送Http请求
     */

   public static String send(String urls, String type, Map<String,String> paramsMap){
       String resp = null;
       StringBuffer params = new StringBuffer();
       log.info(params.toString());
       try{
           URL url = new URL(urls);
           //得到connection对象。
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           //设置请求方式
           connection.setRequestMethod(type);
           //需要输出参数
           if(paramsMap==null){
               connection.setDoOutput(true);
               //发起请求
               connection.connect();
               //接受服务器相应信息
               resp = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));
           }else{
               int i = 1;
               for (Map.Entry<String,String> entry : paramsMap.entrySet()) {
                   if(i!=1){
                       params.append("&");
                   }
                   params.append(entry.getKey());
                   params.append("=");
                   params.append(entry.getValue());
                   i+=1;
               }
               connection.setDoOutput(true);
               //写出参数
               connection.getOutputStream().write(URLEncoder.encode(params.toString()).getBytes("UTF-8"));
               //发起请求
               connection.connect();
               //接受服务器相应信息
               resp = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       return resp;
   }

}
