package com.springboot.login;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/springboot/login")
public class BaiduLoginController {
    @RequestMapping("/baidu")
    public void baiduLogin(String code, HttpServletRequest request){

      String requestUrl = "https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code="+code+"&client_id=gL3CWXPmN2dCencYqH4tHnTafm38X915&client_secret=KVmFziEFcGc7qF16bpFfFRUoqhmcRIW4&redirect_uri=http://10.7.100.104:8080/springboot/login/baidu";
        try{
           /* HttpClient client    = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(requestUrl);
            System.out.println("hello");
            HttpResponse response = client.execute(httpget);
            System.out.println(response);*/
/*
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder().url(requestUrl).build();
            Response response = new Response();
            try {
                response = client.newCall(request).execute()
                if (response!!.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        return GdJsonMapper.readStringValue(response.body()!!.string(), Token::class.java)
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/

/*
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建请求方法的实例， 并指定请求url
            HttpGet httpget=new HttpGet(requestUrl);
            //获取http响应状态码
            CloseableHttpResponse response=httpClient.execute(httpget);
            org.apache.http.HttpEntity entity = response.getEntity();
            //接收响应头
            String content= EntityUtils.toString(entity, "utf-8");
            System.out.println(httpget.getURI());
            System.out.println(content);
            httpClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        /*System.out.println("code= "+code);*/
    }

    @RequestMapping("token")
    public void getTokenAccess(){
        System.out.println("ok");
    }

}
