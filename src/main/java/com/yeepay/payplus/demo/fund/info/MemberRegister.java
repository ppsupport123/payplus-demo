package com.yeepay.payplus.demo.fund.info;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

/**
 *	用户账户注册（会员注册）
 */
public class MemberRegister {
	
	/**
	 * 接口URI地址
	 */
	public static final String INTERFACE_URI = "/rest/v1.0/user/register";

	public static void main(String[] args) throws IOException {
    	YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);
        
        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config .MERCHANTNO);//商户编号
        request.addParam("merchantUserId", Config.USER_ID_MARCOJAN);//商户用户标识
        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = mapper.readValue(response.getStringResult(),Map.class);//response.getStringResult()获取的结果是将返回数据序列化为json
        if("1".equals(map.get("code"))){//如果code为1，表示成功，下面获取业务参数即可
        	System.out.println(map.get("memberNo"));//根据文档获取相应的业务参数做业务处理即可
        }else{
        	System.out.println("返回码:"+map.get("code")+",描述:"+map.get("message"));//如果code不为1，则证明业务处理出错，需要真多code码表做错误处理或者错误展示
        }
	}
}
