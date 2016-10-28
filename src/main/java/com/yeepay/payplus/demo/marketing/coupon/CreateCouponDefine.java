package com.yeepay.payplus.demo.marketing.coupon;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * <p>创建卡券</p>
 * @author: siyu.xu
 * @Date: 2016:09:02 下午3:07
 * @company: 易宝支付(YeePay)
 */
public class CreateCouponDefine {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/merchant/createCouponDefine";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("sendMerchantNo","BM12345678901234");//	发券方商户编号
        request.addParam("requestNo",System.currentTimeMillis());//	商户请求号
        request.addParam("name","123");//	名称
        request.addParam("fundType","NONE");//	资金类型 NONE|SELF
        request.addParam("value",1000);//	面值
        request.addParam("totalCount",10);//	数量
        request.addParam("isAutoReceive",true);//	是否自动领取
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
