package com.yeepay.payplus.demo.marketing.redpacket;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 作者: 张腾
 * 日期: 2016年09月05日 上午10:33
 * 描述: 创建现金红包
 */
public class CreateRedPacket {
    public static final String CREATE_REDPACKET_URI = "/rest/v1.0/merchant/createRedPacketDefine";
    public static void main(String[] args){
        YopRequest request = new YopRequest(Config.APP_KEY,Config.APP_SECRET,Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("requestNo",System.currentTimeMillis());//	商户请求号
        request.addParam("sendMerchantNo",Config.MERCHANTNO);//	发券方商户编号
        request.addParam("name","123");//	名称
        request.addParam("value",1000);//	面值
        request.addParam("totalCount",10);//	数量
        //参数 end
        YopResponse response = YopClient.post(CREATE_REDPACKET_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
