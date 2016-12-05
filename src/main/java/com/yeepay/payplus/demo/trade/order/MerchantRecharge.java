package com.yeepay.payplus.demo.trade.order;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class MerchantRecharge {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/order/merchantRecharge";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("orderAmount", "0.01");//订单总金额
        request.addParam("payTool", "SALESB2B");//当前商户充值只能使用B2B网银
        request.addParam("merchantExpireTime", 100);//30分钟，该订单有效期为5分钟到1440分钟，单位是分钟
        request.addParam("merchantOrderDate", "2016-11-21 17:00:30");//商户用户标识
        request.addParam("webCallbackUrl", "https://www.yeepay.com/webcallback?id=1");//页面回调地址
        request.addParam("serverCallbackUrl", "https://www.yeepay.com/servercallback?id=1");//后端回调地址
        //request.addParam("trxExtraInfo", "{mobile:13000000000}");//风控参数
        //request.addParam("bankCode", "ICBC");//网银充值指定银行
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
