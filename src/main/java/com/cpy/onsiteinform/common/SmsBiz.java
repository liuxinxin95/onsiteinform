package com.cpy.onsiteinform.common;


import com.alibaba.fastjson.JSONObject;
import com.cpy.onsiteinform.exception.RRException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author Carl
 * @ClassName SmsUtil
 * @Description
 * @date 2019-10-08 21:27
 **/
@Component
public class SmsBiz {

    private static Logger logger = LoggerFactory.getLogger(SmsBiz.class);
    private static final String VERIFY_CODES = "0123456789";

    private int appid = 23881946;

    private String appkey = "a2b1b109b487a38cf32840e29ff30bbd";

    private String smsSign = "";

    private int templateId = 7839;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 手机号正则
     */
    private final Pattern p = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\\d{8}$");

    /**
     * 发送短信验证码
     *
     * @param phone
     */
    public void sendSms(String phone) {
        if (StringUtils.isBlank(phone) || !p.matcher(phone).matches()) {
            throw new RRException("手机号不正确");
        }
        try {
            String captcha = generateVerifyCode(4);
            ArrayList<String> params = new ArrayList<>();
            params.add(captcha);
            redisTemplate.opsForValue().set(phone, captcha, 60, TimeUnit.SECONDS);
            SmsSingleSender sender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = sender.sendWithParam("86", phone,
                    templateId, params, smsSign, "", "");
            logger.info("{}手机号验证码为{}", phone, captcha);
            System.out.println(JSONObject.toJSONString(result));
        } catch (Exception e) {
            // HTTP 响应码错误
            e.printStackTrace();
        }
    }

    /**
     * 验证码校验
     *
     * @param phone
     * @param captcha
     */
    public void checkCode(String phone, String captcha) {
        String code = redisTemplate.opsForValue().get(phone);
        if (!captcha.equals(code)) {
            throw new RRException("验证码不正确");
        }
    }

    /**
     * 使用系统默认字符源生成验证码
     *
     * @param verifySize 验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize) {
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }

    /**
     * 使用指定源生成验证码
     *
     * @param verifySize 验证码长度
     * @param sources    验证码字符源
     * @return
     */
    private static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }
}
