package com.xxM.demo02;

import java.io.File;

/**
 * @Program: IntelliJ IDEA PrimaryAlgorithm
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-12-08 19:09:47 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForListFile {
    public static void main(String[] args) {
        File file=new File("c:");
        traverseFolder2(file);
    }
    /**
     * 需要列出的文件
     * @param file
     */
    public static void traverseFolder2(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(new File(file2.getAbsolutePath()));
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
