package com.example.GrandWorldM.controllers;

import com.example.GrandWorldM.model.FileResponse;
import com.example.GrandWorldM.utils.ZipDownloadUtils;
import com.example.GrandWorldMSpec.generated.controller.interfaces.FileManagementApi;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileManagementController implements FileManagementApi {
    @Override
    public ResponseEntity<Resource> downLoadZipInFileGet() {
        String path = "/Users/zhao/Downloads/GrandWorldG.zip";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(path));
    }

    @Override
    public ResponseEntity<List<String>> downLoadZipInBytesGet() {
        String path = "/Users/zhao/Downloads/GrandWorldG.zip";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ArrayList<String>());
    }

    @Override
    public ResponseEntity<String> downloadZipInStringGet() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ZipDownloadUtils.batchFileToZip(byteArrayOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String zipName = "zzz.zip";
        //下载文件
        HttpHeaders headers = new HttpHeaders();
        try {
            zipName = new String("附件.zip".getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", zipName);// 文件名称
        byte[] bytes = byteArrayOutputStream.toByteArray();

        //以string类型返回在swagger页面无法下载
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<String>(new String(bytes, "utf-8"), headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/rulesG")
    public ResponseEntity<byte[]> rulesGet() throws FileNotFoundException {

        ByteArrayOutputStream byteOutPutStream = new ByteArrayOutputStream();
        ZipDownloadUtils.batchFileToZip(byteOutPutStream);
        String zipName = "zzz.zip";
        ResponseEntity<byte[]> responseEntity = ZipDownloadUtils.downloadZip(zipName, byteOutPutStream);
        return responseEntity;
    }

    @GetMapping("/zipFile")
    public ResponseEntity<FileResponse> zipFileGet() throws IOException {
        File zipFile = new File("C:\\Users\\heting.zhao\\Downloads\\LearnCodeGen.zip");
        FileInputStream fileInputStream = new FileInputStream(zipFile);
        ByteArrayOutputStream byteOutPutStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int i = 0;
        while ((i = fileInputStream.read(bytes)) != -1) {
            byteOutPutStream.write(bytes, 0, bytes.length);
        }
        byteOutPutStream.close();
        fileInputStream.close();
//        HttpHeaders headers = new HttpHeaders();
//        String fileName = new String("zzz.zip".getBytes("UTF-8"), "ISO-8859-1");
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDispositionFormData("attachment", fileName);// 文件名称
        FileResponse fileResponse = new FileResponse();
        fileResponse.setBytes(byteOutPutStream.toByteArray());
        fileResponse.setStr(new String(byteOutPutStream.toByteArray(),"utf-8"));
        //以字节数组返回可直接在swagger页面下载
        ResponseEntity<FileResponse> responseEntity = new ResponseEntity<FileResponse>(fileResponse, HttpStatus.CREATED);
        return responseEntity;
    }
}
