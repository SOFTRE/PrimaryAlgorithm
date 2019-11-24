package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-22 22:35:29 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForPairOfParentheses {
    public static void main(String[] args) {
        String str="(123j)jfksl{}";
        System.out.println(pairOfParentheses(str));
    }
    public static Boolean pairOfParentheses(String s){
        // 空字符串
        if (s.length() == 0)
            return true;
        // 排除奇数长度(位运算)
        if ((s.length() & 1) == 1)
            return false;

        // 栈元素个数
        int index = 0;
        // 栈
        char[] stack = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    // 进栈
                    stack[index++] = s.charAt(i);
                    continue;
                case ')':
                    if (index == 0 || stack[--index] != '(')
                        return false;
                    // stack[--index] == '(' ，才会contniue
                    // --index：相当于满足的元素出栈
                    continue;
                case ']':
                    if (index == 0 || stack[--index] != '[')
                        return false;
                    continue;
                case '}':
                    if (index == 0 || stack[--index] != '{')
                        return false;
                    continue;
            }
        }
        return index == 0; // 判断栈是否为空
    }
}
