package com.springboot.login;
import com.google.gson.Gson;
import com.springboot.model.Token;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;


@RestController
@RequestMapping("/springboot/login")
public class BaiduLoginController {
    @RequestMapping("/baidu")
    public void baiduLogin(String code, HttpServletRequest request) {
        java.lang.String requestUrl = "https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code=" + code + "&client_id=gL3CWXPmN2dCencYqH4tHnTafm38X915&client_secret=KVmFziEFcGc7qF16bpFfFRUoqhmcRIW4&redirect_uri=http://10.7.100.104:8080/springboot/login/baidu";
        try {
            Request req = new Request.Builder().url(requestUrl).build();
            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = okHttpClient.newCall(req).execute();
            if(response.isSuccessful()){
                Gson gson = new Gson();
                Token token = gson.fromJson(response.body().string(), Token.class);
                String info = new String(userInfo(token).getBytes(), "utf8");
               /* System.out.println(userInfo(token));*/
                System.out.println(info);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String userInfo(Token token){
        String url = "https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser?access_token="+token.getAccess_token();
        Request request = new Request.Builder()
                .url(url)
                .build();
        String userInfo =null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Response  response = okHttpClient.newCall(request).execute();
            userInfo = response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userInfo;
    }

}
