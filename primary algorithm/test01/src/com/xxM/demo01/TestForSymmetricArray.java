package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 对称数组
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-13 10:40:57 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForSymmetricArray {
    public static void main(String[] args) {
        //对称数组
        int[] arr = new int[]{1, 2, 3, 4, 3, 2, 1};
        System.out.println(symmetricArray(arr));
    }

    /**
     * 一般情况下去反面可以避免掉很多漏洞
     *
     * @param array int [] array
     * @return boolean
     */
    public static boolean symmetricArray(int[] array) {
        int head = 0;
        int tail = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[head++] != array[tail--]) {
                return false;
            }
        }
        return true;
    }
}
