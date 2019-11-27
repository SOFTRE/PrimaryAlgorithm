package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-27 13:01:59 周三
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
    public static String reverse(String string){
        if (string==null||string.length()<=1){
            return string;
        }
        return reverse(string.substring(1))+string.charAt(0);
    }
}
