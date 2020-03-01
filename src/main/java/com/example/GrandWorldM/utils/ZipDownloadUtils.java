package com.example.GrandWorldM.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDownloadUtils {

    public static ResponseEntity<byte[]> downloadZip(String fileName, ByteArrayOutputStream byteArrayOutPutStream) {

        //下载文件
        //String fileName = "批量下载【备案材料】.zip";
        HttpHeaders headers = new HttpHeaders();
        try {
            fileName = new String("附件.zip" .getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);// 文件名称
        //以字节数组返回可直接在swagger页面下载
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(byteArrayOutPutStream.toByteArray(), headers, HttpStatus.CREATED);
        return responseEntity;
    }

    public static void batchFileToZip( ByteArrayOutputStream byteArrayOutPutStream) throws FileNotFoundException {
        File file = new File("/Users/zhao/gitRepoIntelliJ/LearnHowToUseGit/build.gradle");
//        FileInputStream fileInputStream = new FileInputStream(file);

        ZipOutputStream zipOut = new ZipOutputStream(byteArrayOutPutStream);
        FileInputStream IN = new FileInputStream(file);
        BufferedInputStream bins = new BufferedInputStream(IN, 1024);
        try {
            // 使用指定名称创建新的 ZIP 条目 （通俗点就是文件名）
            ZipEntry zipEntry = new ZipEntry(file.getName());
            // 开始写入新的 ZIP 文件条目并将流定位到条目数据的开始处
            zipOut.putNextEntry(zipEntry);
            //直接写入到压缩输出流中即可

            int nNumber;
            byte[] buffer = new byte[1024];
            while ((nNumber = bins.read(buffer)) != -1) {
                zipOut.write(buffer, 0, nNumber);
            }
            zipOut.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zipOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
