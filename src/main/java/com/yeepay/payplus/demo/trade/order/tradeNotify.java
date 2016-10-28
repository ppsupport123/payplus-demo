package com.yeepay.payplus.demo.trade.order;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.payplus.demo.Config;


public class tradeNotify {
public static void main(String[] args) {
    //URL获取接收通知
    //String response = request.getParameter("response");
    String response = " {'response':'{\'doSignature\':\'true\',\'signatureAlg\':\'SHA1\',\'encryption\':\'W6DHzPfmOfPZiIL6WBJca+5UI74kPb64tHWa9EswilmMh5M+sZSu++ZeryqhZZmFRwfhex70YVLIeFVTqMj1+bXSQhfHk1EXyuikj+PCQycKdqD3\\/+G3YCdgDJ9DndTKSU4YTxXRO8jmpc\\/tLWHBWyPL+qB8nzSQR0TYH4mB1pIgRsmCe0mcpXimuTgnqljbJMSzc66Abeta2V7GMXolQ97RBo\\/p23oCbu9B2E3ntutPqT2juEeendlSFiO4+yhlS2gt06NG\',\'encryptionAlg\':\'BLOWFISH\',\'customerIdentification\':\'10000449634\',\'signature\':\'870187906b4427cfb31aceb1d1350e5abaa9f67c\',\'doEncryption\':\'true\'}','customerIdentification':'10000449634'}";
    //APP_SECRET是商户密钥
    YopClient.acceptNotificationAsJson(Config.APP_SECRET, response);
    
    //或者
    //YopClient.acceptNotificationAsMap(Config.APP_SECRET, response);
}
}
