package com.yeepay.payplus.demo.marketing.coupon;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * <p>领取卡券</p>
 * @author: siyu.xu
 * @Date: 2016:09:02 下午3:08
 * @company: 易宝支付(YeePay)
 */
public class ReceiveCoupon {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/receiveCoupon";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("couponNo", System.currentTimeMillis());//卡劵编号
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号必填
        request.addParam("merchantUserId", Config.MERCHANT_USER_ID);//商户用户标识必填
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
