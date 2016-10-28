package com.yeepay.payplus.demo.marketing.redpacket;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 作者: 张腾
 * 日期: 2016年09月05日 上午11:29
 * 描述: 红包定义信息查询
 */
public class QueryRedPacketDefine {
    public static final String QUERY_RED_PACKET_DEFINE_URI = "/rest/v1.0/merchant/queryRedPacketDefine";
    public static void main(String[] args){
        YopRequest request = new YopRequest(Config.APP_KEY,Config.APP_SECRET,Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("defineRequestNo","HBDY00033301");//	卡券编号
        request.addParam("sendMerchantNo",Config.MERCHANTNO);//	发券方商户编号
        //参数 end
        YopResponse response = YopClient.post(QUERY_RED_PACKET_DEFINE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
