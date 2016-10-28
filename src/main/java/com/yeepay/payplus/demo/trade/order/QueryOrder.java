package com.yeepay.payplus.demo.trade.order;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class QueryOrder {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/order/query";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("trxRequestNo", "9cb8d673e1329119018802ZGT");//商户请求号，投产时请不要使用时间戳，避免并发重复
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
