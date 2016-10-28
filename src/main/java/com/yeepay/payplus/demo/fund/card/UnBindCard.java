package com.yeepay.payplus.demo.fund.card;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 解绑卡(注:解绑卡前先要调用对应业务的验密接口生成Token)
 * @author: 王宁
 * @since: 2016年-09月-02日 下午4:45
 * @Version:1.0
 */
public class UnBindCard {

    /**
     * 会员解绑卡接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/unbindCard";


    public static void main(String[] args){

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号必填
        request.addParam("merchantUserId", Config.MERCHANT_USER_ID);//商户用户标识   必填
        request.addParam("bindId","41534210");//需要解绑的绑卡ID(通过绑卡列表查询接口获得) 必填
        request.addParam("reason","apply for unbind card");//解绑卡原因 必填
        request.addParam("requestNo", "unbind_card_1476072280");//商户请求号(注:此流水号为验密的请求流水)必填
        request.addParam("token","9cc8396855f14367b30fe917966b6187");//验密生成的Token值  必填
        //参数 end

        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }


}
