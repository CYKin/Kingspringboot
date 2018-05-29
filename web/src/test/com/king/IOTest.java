package com.king;

import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author King
 * @date 2017/12/5
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        File source = new File("D:/file2.txt");
        if (!source.exists()) {
            System.out.println("要读取的文件不存在！");
            return;
        }
        File target = new File("D:/file.txt");
        if (!target.exists()) {
            target.createNewFile();
        }
        long fsStartTime = System.currentTimeMillis();
        copyFileUsingFileStream(source, target);
        long fsEndTime = System.currentTimeMillis();
        System.out.println("FileStream形式拷贝文件时间："+ (fsEndTime-fsStartTime));

        long fcStartTime = System.currentTimeMillis();
        copyFileUsingFileChannel(source, target);
        long fcEndTime = System.currentTimeMillis();
        System.out.println("FileChannel形式拷贝文件时间："+ (fcEndTime-fcStartTime));

        //JDK Files类的copy方法
        FileCopyUtils.copy(source,target);


    }

    /**
     * 文件流的形式复制文件(FileStream)
     * @param source
     * @param target
     */
    public static void copyFileUsingFileStream(File source, File target) {
        try (FileInputStream fileInputStream = new FileInputStream(source); FileOutputStream fileOutputStream = new FileOutputStream(target)) {
            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileChannel形式复制文件
     * @param source
     * @param target
     */
    private static void copyFileUsingFileChannel(File source, File target) {
        try (FileChannel inputChannel = new FileInputStream(source).getChannel();
             FileChannel outputChannel = new FileOutputStream(target).getChannel()) {
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
