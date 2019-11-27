package com.xxM.demo01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-27 12:51:42 周三
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForReplaceAllOfString {
    public static void main(String[] args) {
        System.out.println(replaceAll("helso123", "\\d", "0"));
    }
    public static String replaceAll(String str,String regx,String newStr){
        Pattern pattern=Pattern.compile(regx);
        Matcher matcher=pattern.matcher(str);
        return matcher.replaceAll(newStr);
    }
}
