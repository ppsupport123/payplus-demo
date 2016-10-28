package com.yeepay.payplus.demo.marketing.redpacket;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 作者: 张腾
 * 日期: 2016年09月05日 上午11:05
 * 描述: 发送现金红包
 */
public class SendCashRedPacket {

    public static final String SEND_CASH_RED_PACKET_URI = "/rest/v1.0/merchant/sendRedPacket";
    public static void main(String[] args){
        YopRequest request = new YopRequest(Config.APP_KEY,Config.APP_SECRET,Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("defineRequestNo","HBDY00033301");//	红包定义编号
        request.addParam("merchantNo",Config.MERCHANTNO);//	发券方商户编号
        request.addParam("merchantUserId",Config.MERCHANT_USER_ID);//	领券方商户用户标识
        request.addParam("expireTime",440);//	过期时间
        //参数 end
        YopResponse response = YopClient.post(SEND_CASH_RED_PACKET_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
