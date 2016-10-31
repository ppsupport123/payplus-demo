package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 * 会员重置支付密码
 *
 * @author：lei.fang
 * @since：2016年09月02日 15:58
 * @version:1.0
 */
public class MemberResetPassword {

    public static final String INTERFACE_URI = "/rest/v1.0/user/getPswdResetUrl";

    public static void main(String[] args) {

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //添加参数
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("merchantUserId", Config.USER_ID_MARCOJAN);//商户用户标识
        request.addParam("passwordBizType", "RESET");//商户用户标识, 这个参数后续版本可能会删掉
        request.addParam("clientSource", "MOBILE"); //不传此参数的话默认为MOBILE
        request.addParam("webCallBackUrl", "http://www.yeepay.com/");//页面回调地址,修改密码完成后返回商户的地址
        request.addParam("returnUrl", "http://www.qq.com/");//返回地址,点击 '返回'的回退地址

        //发送报文
        YopResponse response = YopClient.post(INTERFACE_URI, request);

        System.out.println(response.toString());//处理返回结果

    }
}
