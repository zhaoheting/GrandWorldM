package web.repositories.rule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.dto.rule.TableRule;

import java.util.List;

@Repository
public interface TableRuleRepository extends JpaRepository<TableRule,Long>{

    @Override
    List<TableRule> findAll();
}
