package com.yeepay.payplus.demo.fund.info;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.payplus.demo.Config;

import java.rmi.activation.Activatable;

/**
 * 分账方注册
 *
 * @author：lei.fang
 * @since：2016年09月02日 16:57
 * @version:1.0
 */
public class LedgerRegister {

    public static final String INTERFACE_URI = "/rest/v1.0/merchant/registerLedgerMerchant";

    /**
     * 分账方为个人
     */
    public static void registerPerson() {

        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //添加参数
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", "BM12345678901221");//商户编号
        request.addParam("province", "北京");//分账方所在省,请根据数据 字典「易宝省市编号表.xls」,填 写中文。
        request.addParam("city", "北京");//分账方所在市「易宝省市编 号表.xls」,请根据数据字典,填 写中文。
        request.addParam("businessLicence", "123321123321");//customerStyle为ENTERPRISE时必填
        request.addParam("signedName", "易宝支付测试");//customerStyle为INDIVIDUAL时填姓名，为ENTERPRISE填企业名称
        request.addParam("idCard", "513922199006050019");//身份证号,customerStyle为INDIVIDUAL或PERSON时必填
        request.addParam("legalPerson", "刘庆博");//法人,customerStyle为ENTERPRISE时必填
        request.addParam("customerStyle", "PERSON");//个人-PERSON,企业-ENTERPRISE,个体工商户-INDIVIDUAL
        request.addParam("contactor", "刘庆博");//联系人姓名
        request.addParam("bindMobile", "13550311502");//绑定手机
        request.addParam("email", "yang.yang-1@yeepay.com");//邮箱
        request.addParam("bankAccountNumber", "6227003813440208029");//结算银行卡号,结算用的银行卡号，必须为借记卡
        request.addParam("accountName", "刘庆博");//结算用的银行卡号开户名
        request.addParam("bankAccountType", "PRIVATE_CASH");//个人-PRIVATE_CASH,企业-PUBLIC_CASH
        request.addParam("bankName", "中国建设银行成都分行");//银行卡所 在开户行,请根据数据字典「中国 所有银行支行省市库表.xlsx」,填 写中文。
        request.addParam("bankCardProvince", "北京");//银行卡开户行所在省,请根据数据 字典「易宝省市编号表.xls」,填 写中文。
        request.addParam("bankCardCity", "北京");//返银行卡开户行所在市「易宝省市编 号表.xls」,请根据数据字典,填 写中文。
        request.addParam("minSettleAmount", "100");//>= 0.01 的数字,单位:元 例 如,当 minsettleamount=100 时, 意味着当账户的可用余额大 于 或等于 100 元时,才会结 算出 款。
        request.addParam("manualSettle", "false");//是:true 否:false
        request.addParam("riskReserveDay", "2");//正整数，单位:天 例如,当 riskreserveday=N 时, 意味着当天消费的金额,需要在 N 个工作日后才会结算出 款;如当 N=1 时,则当天消费 的金额,会 在第二个工作日 结算出款。

        //发送报文
        YopResponse response = YopClient.post(INTERFACE_URI, request);
        System.out.println(response.toString());//处理返回结果
    }


    /**
     * 分账方为企业
     */
    public static void registerEnterprise() {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //添加参数
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("province", "四川");//分账方所在省,请根据数据 字典「易宝省市编号表.xls」,填 写中文。
        request.addParam("city", "成都");//分账方所在市「易宝省市编 号表.xls」,请根据数据字典,填 写中文。
        request.addParam("businessLicence", "91510100MA61RW4E3K");//customerStyle为ENTERPRISE时必填
        request.addParam("signedName", "四川易源界科技有限公司");//customerStyle为INDIVIDUAL时填姓名，为ENTERPRISE填企业名称
        request.addParam("idCard", "411522********4512");//身份证号,customerStyle为INDIVIDUAL或PERSON时必填
        request.addParam("legalPerson", "吕斌");//法人,customerStyle为ENTERPRISE时必填
        request.addParam("customerStyle", "ENTERPRISE");//个人-PERSON,企业-ENTERPRISE,个体工商户-INDIVIDUAL
        request.addParam("contactor", "吕斌");//联系人姓名
        request.addParam("bindMobile", "13808171303");//绑定手机
        request.addParam("email", "lei.fang@yeepay.com");//邮箱
        request.addParam("bankAccountNumber", "696297919");//结算银行卡号,结算用的银行卡号，必须为借记卡
        request.addParam("accountName", "四川易源界科技有限公司");//结算用的银行卡号开户名
        request.addParam("bankAccountType", "PUBLIC_CASH");//个人-PRIVATE_CASH,企业-PUBLIC_CASH
        request.addParam("bankName", "中国民生银行成都高新支行");//银行卡所 在开户行,请根据数据字典「中国 所有银行支行省市库表.xlsx」,填 写中文。
        request.addParam("bankCardProvince", "四川");//银行卡开户行所在省,请根据数据 字典「易宝省市编号表.xls」,填 写中文。
        request.addParam("bankCardCity", "成都");//返银行卡开户行所在市「易宝省市编 号表.xls」,请根据数据字典,填 写中文。
        request.addParam("minSettleAmount", "100");//>= 0.01 的数字,单位:元 例 如,当 minsettleamount=100 时, 意味着当账户的可用余额大 于 或等于 100 元时,才会结 算出 款。
        request.addParam("manualSettle", "false");//是:true 否:false
        request.addParam("riskReserveDay", "2");//正整数，单位:天 例如,当 riskreserveday=N 时, 意味着当天消费的金额,需要在 N 个工作日后才会结算出 款;如当 N=1 时,则当天消费 的金额,会 在第二个工作日 结算出款。

        //发送报文
        YopResponse response = YopClient.post(INTERFACE_URI, request);
        System.out.println(response.toString());//处理返回结果
    }


    public static void main(String[] args) {
        //registerEnterprise();
        registerPerson();
    }
}
