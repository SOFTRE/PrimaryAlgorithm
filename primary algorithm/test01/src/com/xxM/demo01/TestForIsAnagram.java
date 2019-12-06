package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-27 13:17:33 周三
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForIsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("fasa", "ssaf"));
    }
    public static boolean isAnagram(String str1,String str2){
        if (str1.length()!=str2.length()){
            return false;
        }
        int [] data=new int[26];
        for (int i = 0; i < str1.length(); i++) {
            data[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (--data[str2.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
