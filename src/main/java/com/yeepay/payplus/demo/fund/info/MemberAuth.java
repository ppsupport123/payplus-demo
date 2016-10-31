package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用户实名认证
 *
 * @author：zhaowei.zhang
 * @since：2016年9月2日 下午5:38:47
 * @version:
 */
public class MemberAuth {

    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/auth";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        // 参数 begin
        request.addParam("requestNo", System.currentTimeMillis());// 商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);// 商户编号必填
        request.addParam("merchantUserId", Config.USER_ID_MARCOJAN);// 商户用户标识必填
        request.addParam("webCallbackUrl", "https://www.baidu.com");// 支付+使命完成后返回商户的地址
        request.addParam("returnUrl", "http://www.sina.com.cn");// 点"返回"的返回地址
        // 参数 end

        YopResponse response = YopClient.post(INTERFACE_URI, request);// 发送报文
        System.out.println(ToStringBuilder.reflectionToString(response));// 处理返回结果
    }
}
