package com.example.GrandWorldM.controllers;

import com.example.GrandWorldMSpec.generated.controller.interfaces.RuleManagementApi;
import com.example.GrandWorldMSpec.generated.model.TableRuleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleManagementController implements RuleManagementApi {

    @Override
    public ResponseEntity<TableRuleResponse> getTableRule(String bundleName, String ruleName, String tenantKey, String version) {
        return null;
    }
}
