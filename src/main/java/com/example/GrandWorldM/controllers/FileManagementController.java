package com.example.GrandWorldM.controllers;

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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
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
            responseEntity = new ResponseEntity<String>(new String(bytes,"utf-8"), headers, HttpStatus.CREATED);
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
}
