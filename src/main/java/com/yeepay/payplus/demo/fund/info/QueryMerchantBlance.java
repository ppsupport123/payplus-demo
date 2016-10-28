package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 商户余额查询
 * @author：lei.fang
 * @since：2016年09月06日 12:02
 * @version:1.0
 */
public class QueryMerchantBlance {

    public static final String INTERFACE_URI = "/rest/v1.0/merchant/queryMerchantBalance";

    public static void main(String [] args){

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号,必填
        //参数 end

        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果

    }

}
