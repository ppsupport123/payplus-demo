package com.yeepay.payplus.demo.trade.divide;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 我只是想测试一下
 */
public class Divide {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/divide/divide";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", "BM12345678901234");//商户编号
        request.addParam("divideDetail", "BL12345678901245:1");//分账详情
        request.addParam("serverCallbackUrl", "http://www.yeepay.com/servercallback?id=1");//分钟完成主动通知地址
        request.addParam("trxRequestNo", "1473133974327");//原交易流水号
        
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
