package web.services.rule;

import org.springframework.stereotype.Service;
import web.dto.rule.TableRule;
import web.repositories.rule.TableRuleRepository;

import java.util.List;

@Service
public class RuleManagementService {

    TableRuleRepository tableRuleRepository;

    public RuleManagementService(TableRuleRepository tableRuleRepository) {
        this.tableRuleRepository = tableRuleRepository;
    }

    public List<TableRule> getTableRuleList(){

        return tableRuleRepository.findAll();
    }
}
