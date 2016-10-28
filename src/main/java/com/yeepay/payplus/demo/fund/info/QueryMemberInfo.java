package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 会员信息查询
 * @author: 王宁
 * @since: 2016年-09月-02日 下午4:09
 * @Version:1.0
 */
public class QueryMemberInfo {

    /**
     * 查询会员信息接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/queryUserInfo";


    public static void main(String[] args){

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号必填
        request.addParam("merchantUserId", Config.MERCHANT_USER_ID);//商户用户标识必填
        //参数 end

        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
