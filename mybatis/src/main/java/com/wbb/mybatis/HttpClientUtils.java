package com.wbb.mybatis;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 利用HttpClient进行请求的工具类
 *
 * @author 2017-12-21 wbb
 *
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public static String doPost(String url, Map<String, String> header, Map<String, String> body) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            if(header!=null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue());
                }
            }
            List<BasicNameValuePair> paraList = new ArrayList<BasicNameValuePair>(body.size());
            for (Entry<String, String> pEntry : body.entrySet()) {
                if(null != pEntry.getValue()){
                    BasicNameValuePair nv = new BasicNameValuePair(pEntry.getKey(), pEntry.getValue());
                    paraList.add(nv);
                }
            }
            //使用UTF-8
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paraList,Charset.forName("utf-8"));
            entity.setContentEncoding("UTF-8");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (Exception e) {
            logger.error("e",e);
        }
        return "";
    }
}
