package com.example.GrandWorldM.controllers;

import com.example.GrandWorldMSpec.generated.controller.interfaces.RuleManagementApi;
import com.example.GrandWorldMSpec.generated.model.InlineResponse200;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class RuleManagementController implements RuleManagementApi {

    @Override
    public ResponseEntity<InlineResponse200> pushRuleBundles(String types, String tenantId, String version, @Valid MultipartFile ruleZip) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> rulesGet() {
        String path = "/Users/zhao/Downloads/GrandWorldG.zip";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(path));
    }
}
