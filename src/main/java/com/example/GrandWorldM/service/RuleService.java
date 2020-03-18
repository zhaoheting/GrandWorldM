package com.example.GrandWorldM.service;

import com.example.GrandWorldM.dao.RuleDao;
import com.example.GrandWorldMSpec.generated.model.TableRule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author heting.zhao
 */
@Service
public class RuleService {

    private RuleDao ruleDao;

    public RuleService(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    public TableRule getTableRule(String bundleName, String ruleName, String tenantKey, String version) {
        //todo 从db中查到tablerule后解析xml数据按照分页信息返回model。
        return ruleDao.selectTableRule(bundleName, ruleName, tenantKey, version);
    }

    /**
     * Insert all the rules of one bundle in every transaction.
     *
     */
    @Transactional
    public int saveTableRules() {
        //todo 接收一个zip包，解压成多个xml文件流，每个流一条数据，存到DB
        //todo insert the record into trail table.
        //todo insert every table rule in a loop.
        TableRule tableRule = new TableRule();
        tableRule.setBundle("hotel");
        tableRule.setName("bookingchannels");
        tableRule.setData("whole xml.");
        tableRule.setStatus(TableRule.StatusEnum.ACTIVATED);
        tableRule.setTenantKey("HU");
        tableRule.setVersion("4");
        tableRule.setAuditId(12);
        return ruleDao.insertTableRule(tableRule);
    }
}
