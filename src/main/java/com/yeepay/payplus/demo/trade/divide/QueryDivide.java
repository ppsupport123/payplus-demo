package com.yeepay.payplus.demo.trade.divide;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class QueryDivide {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/divide/query";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("divideRequestNo","4869192300387075307");//分账请求号
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("trxRequestNo", "4628987144003894291");//原交易请求号
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
