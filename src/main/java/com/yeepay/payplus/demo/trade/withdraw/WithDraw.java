package com.yeepay.payplus.demo.trade.withdraw;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class WithDraw {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/withdraw/withdraw";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", "BM12345678901234");//商户编号
        request.addParam("merchantUserId", "C01010010100101");//转账到的账户
        request.addParam("bindCardId", "2010010");//如果是卡到账户时候，必传bindCardId
        request.addParam("amount", "0.01");//转账金额
        request.addParam("serverCallbackUrl", "http://www.yeepay.com/servercallback?id=1");//请求转账用户
        request.addParam("token", "821738127391283sndjifuiewhfuegf");//用户密码校验token
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
