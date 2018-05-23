package com.company.project.util;

/**
 * com.lcworld.chaojishequ.utils.SysConfigConstants
 * @description 
 * 		保存配置文件属性常量类
 * @author yinyouyi@2016年6月17日
 *
 * @modified_by yinyouyi@2016年6月17日
 */
public interface SysConfigConstants {
	 
	
	
	public static String APPID = PropertiesUtils.getProperties().getProperty("appID");
	
	public static String APPSCRET = PropertiesUtils.getProperties().getProperty("appScret");
	
	/*微信网页授权 获取access_tokenUrl*/
	public static String ACCESS_TOKEN_Url="https://api.weixin.qq.com/sns/oauth2/access_token";
	
	/*微信网页授权 获取用户基本信息 url*/
	public static String USERINFO_Url="https://api.weixin.qq.com/sns/userinfo";
	/**协议类型 用于支付宝回调使用*/
	public static String DOMAINURL = PropertiesUtils.getProperties().getProperty("domainurl");
	
	public static String  NoVerifyAction= PropertiesUtils.getProperties().getProperty("NoVerifyAction");
	
	public static String sendSmsType=PropertiesUtils.getProperties().getProperty("sendSmsType");
	public static String sendCaptchaSmsType=PropertiesUtils.getProperties().getProperty("sendCaptchaSmsType");
	public static String LK_URL=PropertiesUtils.getProperties().getProperty("lk_URL");
	public static String LK_ACCOUNT=PropertiesUtils.getProperties().getProperty("lk_userid");
	public static String LK_PASSWORD=PropertiesUtils.getProperties().getProperty("lk_password");
	public static String  NOCHECKUSERACTION= PropertiesUtils.getProperties().getProperty("NoCheckUserAction");
	
	public static String  QRCODE_PATH= PropertiesUtils.getProperties().getProperty("QRCODE_PATH");
	
	public static String IsCheck=PropertiesUtils.getProperties().getProperty("IsCheck");
	
	public static String NoDoCheck=PropertiesUtils.getProperties().getProperty("NoDoCheck");
	
	public static String H5referer=PropertiesUtils.getProperties().getProperty("H5referer");
	
	public static String AL_IMG_PATH=PropertiesUtils.getProperties().getProperty("AL_IMG_PATH");
	
 
	
	public static String WXCERTLOCALPATH=PropertiesUtils.getProperties().getProperty("WXCERTLOCALPATH");
	
	public static String WXCERTPASSWORD=PropertiesUtils.getProperties().getProperty("WXCERTPASSWORD");
	
	public static String WXKEY=PropertiesUtils.getProperties().getProperty("WXKEY");
	public static String WXAPPID=PropertiesUtils.getProperties().getProperty("WXAPPID");
	public static String WXMCHID=PropertiesUtils.getProperties().getProperty("WXMCHID");
	
    public static String WAPWXCERTLOCALPATH=PropertiesUtils.getProperties().getProperty("WAPWXCERTLOCALPATH");
	
	public static String WAPWXCERTPASSWORD=PropertiesUtils.getProperties().getProperty("WAPWXCERTPASSWORD");
	
	public static String WAPWXKEY=PropertiesUtils.getProperties().getProperty("WAPWXKEY");
	public static String WAPWXAPPID=PropertiesUtils.getProperties().getProperty("WAPWXAPPID");
	public static String WAPWXMCHID=PropertiesUtils.getProperties().getProperty("WAPWXMCHID");
	
	public static String WX_PAY_QUERY_API=PropertiesUtils.getProperties().getProperty("WX_PAY_QUERY_API");
	public static String NOCHECKSESSIONACTION=PropertiesUtils.getProperties().getProperty("NoCheckSessionidAction");
	
	public static String AL_NOTIFY_URL=PropertiesUtils.getProperties().getProperty("AL_NOTIFY_URL");
	public static String WAPCERTLOCALPATH=PropertiesUtils.getProperties().getProperty("WAPCERTLOCALPATH");
	public static String WX_NOTIFY_URL=PropertiesUtils.getProperties().getProperty("WX_NOTIFY_URL");
	
	/** 以下是微信支付 需要用到的配置   **/
	
	public static String APP_ID = "wxb61df1859348caa8";//微信开发平台应用id
	public static String APP_SECRET = "a2f3cfc98b707f142b6b6008eb485b17";//应用对应的凭证
	//应用对应的密钥
	public static String APP_KEY = "DSAewi234DAdwewJcmnJgrtl5W36J3FJ";
									
	public static String PARTNER = "1263686701";//财付通商户号
	public static String PARTNER_KEY = "a6mC4mfmeSqXvLiyJn86kWtZcku6xeSm";//商户号对应的密钥
	public static String TOKENURL = "https://api.weixin.qq.com/cgi-bin/token";//获取access_token对应的url
	public static String GRANT_TYPE = "client_credential";//常量固定值 
	public static String EXPIRE_ERRCODE = "42001";//access_token失效后请求返回的errcode
	public static String FAIL_ERRCODE = "40001";//重复获取导致上一次获取的access_token失效,返回错误码
	public static String GATEURL = "https://api.weixin.qq.com/pay/genprepay?access_token=";//获取预支付id的接口url
	public static String ACCESS_TOKEN = "access_token";//access_token常量值
	public static String ERRORCODE = "errcode";//用来判断access_token是否失效的值
	public static String SIGN_METHOD = "sha1";//签名算法常量值
	//package常量值
	public static String packageValue = "bank_type=WX&body=%B2%E2%CA%D4&fee_type=1&input_charset=GBK&notify_url=http%3A%2F%2F127.0.0.1%3A8180%2Ftenpay_api_b2c%2FpayNotifyUrl.jsp&out_trade_no=2051571832&partner=1900000109&sign=10DA99BCB3F63EF23E4981B331B0A3EF&spbill_create_ip=127.0.0.1&time_expire=20131222091010&total_fee=1";
	public static String traceid = "testtraceid001";//测试用户id
}
