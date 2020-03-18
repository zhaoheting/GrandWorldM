package com.example.GrandWorldM.controllers;


import com.example.GrandWorldM.service.RuleService;
import com.example.GrandWorldMSpec.generated.controller.interfaces.RuleManagementApi;
import com.example.GrandWorldMSpec.generated.model.TableRule;
import com.example.GrandWorldMSpec.generated.model.TableRuleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
public class RuleManagementController implements RuleManagementApi {

    @Autowired
    private RuleService ruleService;

    @Override
    public ResponseEntity<TableRuleResponse> getTableRule(@NotNull @Valid String bundleName, @NotNull @Valid String ruleName, @Valid String tenantKey, @Valid String version) {
        TableRule tableRule = ruleService.getTableRule(bundleName, ruleName, tenantKey, version);
        TableRuleResponse tableRuleResponse = new TableRuleResponse();
        tableRuleResponse.setTableRule(tableRule);
        return ResponseEntity.status(HttpStatus.OK).body(tableRuleResponse);
    }

    @PostMapping("/saveTableRule")
    public ResponseEntity<Integer> saveTableRule(){
        Integer num =  ruleService.saveTableRules();
        return ResponseEntity.status(HttpStatus.CREATED).body(num);
    }
}
