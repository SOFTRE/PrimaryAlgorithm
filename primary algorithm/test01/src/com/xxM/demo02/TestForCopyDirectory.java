package com.xxM.demo02;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-27 19:26:51 周三
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
import java.io.*;

/**
 * CopyDocJob定义了实际执行的任务，即
 * 从源目录拷贝文件到目标目录
 */
public class TestForCopyDirectory {
    public static void main(String[] args) {
        try {
            copyDirectiory("d:/301sxt","d:/301sxt2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 复制单个文件
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @throws IOException
     */
    private static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            // 新建文件输出流
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

    /**
     * 复制目录
     * @param sourceDir 源目录
     * @param targetDir 目标目录
     * @throws IOException
     */
    private static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        // 检查源目录
        File fSourceDir = new File(sourceDir);
        if(!fSourceDir.exists() || !fSourceDir.isDirectory()){
            return;
        }
        //检查目标目录，如不存在则创建
        File fTargetDir = new File(targetDir);
        if(!fTargetDir.exists()){
            fTargetDir.mkdirs();
        }
        // 遍历源目录下的文件或目录
        File[] file = fSourceDir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(fTargetDir, file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            //递归复制子目录
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String subSourceDir = sourceDir + File.separator + file[i].getName();
                // 准备复制的目标文件夹
                String subTargetDir = targetDir + File.separator + file[i].getName();
                // 复制子目录
                copyDirectiory(subSourceDir, subTargetDir);
            }
        }
    }
}
