package com.yeepay.payplus.demo.trade.refund;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class QueryRefund {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/refund/query";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        
        request.addParam("refundRequestNo", "1473134370873");//退款请求号
        request.addParam("trxRequestNo", "1473133974327");//原交易请求号
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
