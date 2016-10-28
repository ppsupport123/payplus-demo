package com.yeepay.payplus.demo.marketing.redpacket;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 作者: 张腾
 * 日期: 2016年09月05日 上午11:21
 * 描述: 用户未领取红包查询
 */
public class QueryUnReceivedRedPackets {
    public static final String QUERY_UNRECEIVED_RED_PACKETS_URI = "/rest/v1.0/user/queryUnReceivedRedPackets";
    public static void main(String[] args){
        YopRequest request = new YopRequest(Config.APP_KEY,Config.APP_SECRET,Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("defineRequestNo","HBDY00033301");//	卡券编号
        request.addParam("merchantNo",Config.MERCHANTNO);//	发券方商户编号
        request.addParam("merchantUserId",Config.MERCHANT_USER_ID);//	领券方商户用户标识
        //参数 end
        YopResponse response = YopClient.post(QUERY_UNRECEIVED_RED_PACKETS_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
