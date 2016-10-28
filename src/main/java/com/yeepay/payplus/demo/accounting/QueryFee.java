package com.yeepay.payplus.demo.accounting;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;


public class QueryFee {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/accounting/queryFee";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        
        request.addParam("accountingType","FUND");//账务类型，当前默认是FUND-资金
        request.addParam("merchantNo", "BM12345678901234");//商户编号
        request.addParam("requestNo", "140202020202");//原交易请求号
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
