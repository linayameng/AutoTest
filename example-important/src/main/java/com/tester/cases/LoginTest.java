package com.tester.cases;

import com.csvreader.CsvReader;
import com.tester.config.TestConfig;
import com.tester.model.InterfaceName;
import com.tester.utils.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class LoginTest {
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest(groups = "loginTrue", description = "测试准备工作,获取HttpClient对象")
    public void beforeTest() {
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
    }

    @Test(groups = "loginTrue", description = "用户登陆成功接口")
    public void loginTrue() throws IOException {
        CsvReader csvReader = new CsvReader("/Users/admin/Desktop/last-auto/autotest/example-important/src/main/resources/testcase/login.csv");
        String loginSuccessName = null;
        String loginSuccessPassword = null;
        while (csvReader.readRecord()) {
            if (csvReader.getCurrentRecord() == 1){
                loginSuccessName = csvReader.get(0);
                loginSuccessPassword = csvReader.get(1);
            }
        }
            /**
             *RawRecord:name,password
             * RawRecord:zhangsan,123456
             * RawRecord:baishi,11111
             * **/
        //System.out.println("RawRecord:" + csvReader.getRawRecord());

        //测试代码编写
            String result;
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost loginTrueTest = new HttpPost(TestConfig.loginUrl);
            //添加参数
            JSONObject param = new JSONObject();
            param.put("name",loginSuccessName);
            param.put("password",loginSuccessPassword);
            System.out.println(param.toString());
            //设置请求头信息 设置header
            loginTrueTest.setHeader("content-type","application/json");
            //将参数信息添加到方法中
            StringEntity entity = new StringEntity(param.toString(),"utf-8");
            loginTrueTest.setEntity(entity);
            //执行post方法
            HttpResponse response1 = defaultHttpClient.execute(loginTrueTest);
            //获取响应结果
            result = EntityUtils.toString(response1.getEntity(),"utf-8");
            System.out.println(result);
            //------获取cookies信息------------
            this.store = defaultHttpClient.getCookieStore();
            List<Cookie> cookieList = store.getCookies();
            //具体的判断返回结果的值 预期 结果
            Assert.assertEquals(result,"true");


    }
}
