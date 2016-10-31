package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用户验证密码
 *
 * @author：zhaowei.zhang
 * @since：2016年9月2日 下午5:38:59
 * @version:
 */
public class MemberPswdVerifyUrl {

    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/getPswdVerifyUrl";

    public static void main(String[] args) {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        // 参数 begin
        request.addParam("requestNo", System.currentTimeMillis());// 商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);// 商户编号必填
        request.addParam("merchantUserId", Config.USER_ID_MARCOJAN);// 商户用户标识必填
        /**
         * 实名认证-VERIFY
         * 修改支付密码-MODIFY
         * 充值-RECHARGE
         * 提现-WITHDRAW
         * 转账-TRANSFER
         * 绑卡-BIND_CARD
         * 解绑卡-UN_BIND_CARD
         * 支付-PAY
         */
        request.addParam("tokenBizType", "UN_BIND_CARD");// 生成token业务类型
        request.addParam("webCallBackUrl", "https://www.baidu.com");// 密码校验完成后返回商户的地址
        request.addParam("returnUrl", "http://www.qq.com"); // 点击“返回”的回退地址
        // 参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);// 发送报文
        System.out.println(ToStringBuilder.reflectionToString(response));// 处理返回结果
    }
}
