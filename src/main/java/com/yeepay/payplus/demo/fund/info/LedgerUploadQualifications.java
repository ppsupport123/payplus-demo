package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分账方资质上传
 * @author：lei.fang
 * @since：2016年09月02日 17:20
 * @version:1.0
 */
public class LedgerUploadQualifications {

    public static final String INTERFACE_URI = "/rest/v1.0/merchant/uploadQualifications";

    public static void main(String [] args) throws IOException {

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //添加参数
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", "BM12345678901234");//商户编号
        request.addParam("ledgerNo", "BL12345678901228");//分账方编号
        request.addParam("qualificationType", "ID_CARD_FRONT");//证件类型,类型详情请参考文档

        File file = new File("/Users/felayman/Desktop/1.png");
        FileInputStream fs = new FileInputStream(file);
        FileChannel channel = fs.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        channel.read(byteBuffer);
        String base64FileStr = org.apache.commons.codec.binary.Base64.encodeBase64String(byteBuffer.array());

        request.addParam("imgBase64Buffer", base64FileStr);//图片转base64编码的字符串

        //发送报文
        YopResponse response = YopClient.post(INTERFACE_URI, request);
        System.out.println(response.toString());//处理返回结果

    }

}
