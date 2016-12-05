package com.yeepay.payplus.demo.trade.order;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Recharge {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/order/recharge";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("merchantUserId", Config.USER_ID_MARCOJAN);//商户用户标识
        request.addParam("orderAmount", "0.01");//订单总金额
        request.addParam("fundAmount", "0.01");//资金金额即用户能看到的最后需要支付的金额
        //request.addParam("couponNos", "1,2,3");//营销卡卷号
        //request.addParam("payTool", "DIRECTFIRST");//指定支付方式，当指定支付方式，不再展示收银台，直接展示支付密码
        //request.addParam("bindCardId", "48013708");//指定支付方式如果是绑卡BINDCARD bindCardId必须为空
        request.addParam("merchantExpireTime", 30);//30分钟
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.addParam("merchantOrderDate", format.format(new Date()));//商户用户标识
        request.addParam("webCallbackUrl", "https://www.yeepay.com/webcallback?id=1");//页面回调地址
        request.addParam("serverCallbackUrl", "https://www.yeepay.com/servercallback?id=1");//后端回调地址
        //request.addParam("productCatalog", "30");//产品类别码
        //request.addParam("productDesc", "易宝支付有限公司");//商品描述


        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果
    }
}
