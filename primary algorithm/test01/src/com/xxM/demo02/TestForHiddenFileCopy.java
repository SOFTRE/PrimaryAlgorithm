package com.xxM.demo02;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Program: IntelliJ IDEA PrimaryAlgorithm
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-12-08 19:01:19 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
class FileHidden implements FilenameFilter{
    /**
     * 获取隐藏的文件
     * @param dir 文件
     * @param name 文件名
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        return dir.isHidden();
    }
}
public class TestForHiddenFileCopy {
    public static void main(String[] args) {
    File file=new File("C:\\");
        File[] files = file.listFiles(new FileHidden());
        for (File file1 : files) {
            System.out.println(file1);
        }
    }

}
