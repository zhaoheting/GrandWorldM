package com.example.GrandWorldM.service;

import com.example.GrandWorldM.dao.RuleDao;
import com.example.GrandWorldMSpec.generated.model.TableRule;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    private RuleDao ruleDao;

    public RuleService(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    public TableRule getTableRule(String bundleName, String ruleName, String tenantKey, String version) {
        return ruleDao.selectTableRule(bundleName,ruleName,tenantKey,version);
    }
}
