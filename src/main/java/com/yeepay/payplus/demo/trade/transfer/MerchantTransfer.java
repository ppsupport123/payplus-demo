package com.yeepay.payplus.demo.trade.transfer;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class MerchantTransfer {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/transfer/merchantTransfer";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("toUserType", "MEMBER");//转账到用户账户
        request.addParam("toUserNo", Config.TO_USER);//转账到的支付+账户
        request.addParam("amount", "0.01");//转账金额
        request.addParam("rechargeRequestNo", "bd209ee36ee44b559414d18d63030294");
        request.addParam("transferType", "USER_TO_USER");
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
