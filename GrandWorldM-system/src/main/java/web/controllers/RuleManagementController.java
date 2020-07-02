package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import web.controllers.interfaces.RuleManagementApi;
import web.dto.rule.TableRule;
import web.services.rule.RuleManagementService;

import java.util.List;

@RestController
public class RuleManagementController implements RuleManagementApi {

    RuleManagementService ruleManagementService;

    public RuleManagementController(RuleManagementService ruleManagementService) {
        this.ruleManagementService = ruleManagementService;
    }

    @Override
    public ResponseEntity<List> getTableRule() {
        List<TableRule> tableRuleList = ruleManagementService.getTableRuleList();
        return ResponseEntity.status(HttpStatus.OK).body(tableRuleList);
    }
}
