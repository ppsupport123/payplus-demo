package com.yeepay.payplus.demo.trade.transfer;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class Transfer {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/transfer/transfer";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("transferType", "USER_TO_USER");//用户到用户转账
        request.addParam("fromUserNo", Config.USER_ID_MARCOJAN);//请求转账用户
        request.addParam("toUserNo", Config.TO_USER);//转账到的账户
        request.addParam("amount", "0.01");//转账金额
        //request.addParam("bindCardId", "37595983");//如果是卡到账户时候，必传bindCardId
        request.addParam("token", "821738127391283sndjifuiewhfuegf");//用户密码校验token
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
