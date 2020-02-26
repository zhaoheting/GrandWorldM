package com.example.GrandWorldM.controllers;

import com.example.GrandWorldMSpec.generated.controller.interfaces.RuleManagementApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class RuleManagementController implements RuleManagementApi {

    @Override
    public ResponseEntity<Void> pushRuleBundles(String types, String tenantId, String version, @Valid MultipartFile ruleZip) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> rulesGet(String type, String ruleSetName, String tableName, String tenantId, String version) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
