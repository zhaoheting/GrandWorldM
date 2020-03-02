package com.example.GrandWorldM.controllers;

import com.example.GrandWorldMSpec.generated.controller.interfaces.RuleManagementApi;
import com.example.GrandWorldMSpec.generated.model.RuleResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class RuleManagementController implements RuleManagementApi {

    @Override
    public ResponseEntity<RuleResponse> downLoadZipInBytesGet() {
        File zipFile = new File("C:\\Users\\heting.zhao\\Downloads\\LearnCodeGen.zip");
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteOutPutStream = null;
        try {
            fileInputStream = new FileInputStream(zipFile);
            byteOutPutStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = fileInputStream.read(bytes)) != -1) {
                byteOutPutStream.write(bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteOutPutStream != null) {
                    byteOutPutStream.close();
                }
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        RuleResponse ruleResponse = new RuleResponse();
        ruleResponse.setRuleInBytes(byteOutPutStream.toByteArray());
        //以字节数组返回可直接在swagger页面下载
        ResponseEntity<RuleResponse> responseEntity = new ResponseEntity<RuleResponse>(ruleResponse, HttpStatus.CREATED);
        return responseEntity;
    }

    //只支持从页面点击下载按钮
    @Override
    public ResponseEntity<Resource> downLoadZipInFileGet() {
        String path = "C:\\Users\\heting.zhao\\Downloads\\ZhtLearning.zip";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(path));
    }
}
