package com.xxM.demo;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-13 09:03:46 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForSplitNumberAccount {
    private static int count = 0;

    public static void main(String[] args) {

        String bigStr = "chinawoaichina,chinabutongyuusa," +
                "wulunchinazainali,shengshengshishidoushipeopleofchina";
        String smallStr = "china";
        /*System.out.println(strSplit(bigStr,smallStr));*/
        System.out.println(subString(bigStr, smallStr));
    }

    /**
     * 方法一：
     * 巧妙利用split分割原理对现有方式根据其是否以smallStr结尾进行结果处理
     *
     * @param bigStr   被分割的参数
     * @param smallStr 分割参数
     * @return 统计个数
     */
    public static int strSplit(String bigStr, String smallStr) {
        if (bigStr.indexOf(smallStr) != 1) {
            if (bigStr.endsWith(smallStr)) {
                return bigStr.split(smallStr).length;
            }
            if (!bigStr.endsWith(smallStr)) {
                return bigStr.split(smallStr).length - 1;
            }
        }
        return -1;
    }

    /**
     * 方法二：
     * 使用字符串截取方法(subString)进行指定截取
     *
     * @param bigStr   被截取的参数
     * @param smallStr 截取参数
     * @return 截取次数
     */
    public static int subString(String bigStr, String smallStr) {
        if (bigStr.indexOf(smallStr) != -1) {
            bigStr = bigStr.substring(bigStr.indexOf(smallStr) + smallStr.length());
            subString(bigStr, smallStr);
            count++;
        }
        return count;
    }
}
