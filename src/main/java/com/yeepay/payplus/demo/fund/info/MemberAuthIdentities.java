package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 用户上传实名信息
 *
 * @author：yang.yang-1
 * @since：2016年10月26日 下午3:38:47
 * @version:
 */
public class MemberAuthIdentities {

    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/user/authCredentials";

    public static void main(String[] args) throws IOException {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        // 参数 begin
        request.addParam("requestNo", System.currentTimeMillis());// 商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);// 商户编号必填
        request.addParam("merchantUserId", Config.MERCHANT_USER_ID);// 商户用户标识必填
        request.addParam("fileType", "ID_CARD_BACK");// 支付+使命完成后返回商户的地址

        File file = new File("/Users/edison/Downloads/3.jpeg");
        FileInputStream fs = new FileInputStream(file);
        FileChannel channel = fs.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        channel.read(byteBuffer);
        String base64FileStr = org.apache.commons.codec.binary.Base64.encodeBase64String(byteBuffer.array());

        request.addParam("file", base64FileStr);//图片转base64编码的字符串
        // 参数 end

        YopResponse response = YopClient.post(INTERFACE_URI, request);// 发送报文
        System.out.println(ToStringBuilder.reflectionToString(response));// 处理返回结果
    }
}
