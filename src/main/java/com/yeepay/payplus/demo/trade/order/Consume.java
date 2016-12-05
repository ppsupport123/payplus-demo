package com.yeepay.payplus.demo.trade.order;

import com.yeepay.g3.sdk.yop.auth.YopSigner;
import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.g3.sdk.yop.encrypt.YopSignUtils;
import com.yeepay.payplus.demo.Config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Consume {
    /**
     * 接口URI地址
     */
    public static final String INTERFACE_URI = "/rest/v1.0/order/consume";

    public static void main(String[] args) throws IOException {
        YopRequest request = new YopRequest(Config.APP_KEY, Config.APP_SECRET, Config.URL);
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(Config.SIGN_ALG);

        //YopSignUtils.sign();

        String payTool = "YEEPAYCASHIER";

        //参数 begin
        request.addParam("requestNo", System.currentTimeMillis());//商户请求号，投产时请不要使用时间戳，避免并发重复
        request.addParam("merchantNo", Config.MERCHANTNO);//商户编号
        request.addParam("merchantUserId", Config.YANGYANG);//商户用户标识
        request.addParam("orderAmount", "0.01");//订单总金额
        request.addParam("fundAmount", "0.01");//资金金额即用户能看到的最后需要支付的金额
        //request.addParam("couponNos", "1,2,3");//营销卡券号，该请求号为商户发送的卡券编号
        //request.addParam("payTool", payTool);//指定支付方式，当指定支付方式，不再展示收银台，直接展示支付密码
        //request.addParam("bindCardId", "51650796");//指定支付方式如果是绑卡BINDCARD bindCardId必须为空
        request.addParam("merchantExpireTime", 120);//30分钟
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.addParam("merchantOrderDate", format.format(new Date()));//商户订单交易时间
        request.addParam("webCallbackUrl", "https://www.yeepay.com/webcallback?id=1");//页面回调地址
        request.addParam("serverCallbackUrl", "https://www.yeepay.com/servercallback?id=1");//后端回调地址
        request.addParam("productName", "购买东西");//商品名称
        request.addParam("productCatalog", "30");//产品类别码
        request.addParam("productDesc", "鹦鹉美家有限公司");//商品描述
        request.addParam("mcc", "3101");//商品类别码


        //参数 end
        YopResponse response = YopClient.post(INTERFACE_URI, request);//发送报文
        System.out.println(response.toString());//处理返回结果

        if (payTool.equals("WECHATSCAN")) {

            String hexImageString = response.getStringResult();

            hexImageString="89504E470D0A1A0A0000000D494844520000008B0000008B0802000000DE7BFDA8000003B24944415478DAEDDD4172E3300C4451DDFFD2CE328B542212FD0131F6D7D2B12D914F659068D5CCF5F238FBB89C82FF217465C7F7D7FDFEA7F03D2B67FFF9F1952FDCFAF85F53B973D2F57129A49042ACD0DE4F643647B537D7DEB335D75B1FDF3A7BE1A40A29A45093D056D5A95D5CED877BAB6851858D122ACCAA420A29749410F5A99001AF43B50D86420A29F4C642B501D426ABAFB4F4DD310A29A4D0E342E196BBB6E10F4BC2806BD89278BEEBA390421F2F44E543BE727A82E72B0A7D9810F6600AD4F10C63A1B0B74B9D827CD647218514CA8406E21CAA9E5195925AAC875748EE87145248A1DF85C2DF62AA4F8A57262AB90F1F05489A2F0A29A41022D47D1AF0699B7066FBCE4ED53C851452A855283C5FB8C80E67845A52F7F5530AD7AC90420A3509F565DE549E7D48C3141F8E420A29D421343048EA95B024504D0ABC5BA190420AB50A51B90E5536C2B57EDF17E20DE5ED145C2185142A09D5D6D6B5B91E58C71F926723ED0685145208110A7B7CE12AB9AF05D0176EE18BFED5CEA9420A295412AA5D770D2F7C10A75651FA729DDAF7ACFF492185146285261FCD09939EB0C2F5F541D878492185144284C2C53195A384F3186EF827D7D6F57C482185142A091D122D77EFCFC1CA14F65BD7AF472185144284A885EF23290EB2A89D6916172AA5420A29840885BFBCE1B23B4CA6F1B3E3952949C21452482156081FC06465A22228AAB1823482155248214428AC04E15C53C04D3974DEB7AD3D13A090420A81428744CB618A539B8830DCA29AB3406F5B2185148284FA7EB8C3B53E55126AB7175505155248A10E213CFFA062ECC9107DF2D659BF1B145248214408CFB3F1C246F502A8BEEDC09E412185141A160AAF129F23FCF9A4303AA23A110A29A4D03942B8623824FCA403ED86DE3AA490420A65FF9A736D6CD4DD406D03A8B137E5550A29A4102B149E98AA4CF86340E1CD843FD9B39D822BA490429950586CA82D776D48544BE2CA8E3017BFA9430A29A4102484FF16E3FD024A919A74BC5B715387145248A14C289C9A81EC877A735FDB82ADA60A29A4102214EECFF1164077E80216516AB1BE9A0F29A49042500A3E90F4846D4DA42FD9DAED0D811552482150886A1A3EB258AF3555C3CBA05ED95E6D2BA4904299505875C2B12143021B9D78CCAF90420A9D238424B8AF87FEAF6E3C71EF6B25DC5229A4904247091D1B1451352FBCAB0A17AF90420ABD8110D58E9CECDBE289D1CDB33E0A29A4102DD497885095206CCE52F71055EA145248A119216AC7FE60AB713743A22E2CDC2AACF614145248A19290C7B18742A71F5F5D6FC5A7B5CF0D980000000049454E44AE426082";
            genImg(hexImageString);

        }
    }

    public static void genImg(String hexImgString) throws IOException {
        System.out.println(hexImgString);

        //转成image
        byte[] b = hex2byte(hexImgString);
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        BufferedImage image = ImageIO.read(in);
        //输出
        ImageIO.write(image, "jpg", new File("/Users/edison/Downloads/im.jpg"));
    }

    public static byte[] hex2byte(String s) {
        byte[] src = s.toLowerCase().getBytes();
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')
                    : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')
                    : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }
}
