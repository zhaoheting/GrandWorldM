package com.example.GrandWorldM.dao;

import com.example.GrandWorldM.entity.DeploymentAudit;
import com.example.GrandWorldMSpec.generated.model.TableRule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;


@Mapper
public interface RuleDao {

    @Select("SELECT id,bundle,name,version,data,tenant_key,last_updated,status,audit_id FROM table_rule " +
            "WHERE bundle = #{bundleName} and name = #{ruleName} and tenant_key = #{tenantKey} and version = #{version}")
    TableRule selectTableRule(@Param("bundleName") String bundleName, @Param("ruleName") String ruleName, @Param("tenantKey") String tenantKey, @Param("version") String version);

    @Insert("insert into rule_deployment_audit_trail (id,bundle,name,version,data,tenant_key,last_updated,status,audit_id) " +
            "values (rule_dep_audit_trail.nextval)")
    int insertDeploymentAudit(@Param("deploymentAudit") DeploymentAudit deploymentAudit);

    @Insert("insert into table_rule (id,bundle,name,version,data,tenant_key,last_updated,status,audit_id) " +
            "values (table_rule_sequence.nextval,#{tableRule.bundle},#{tableRule.name},#{tableRule.version}," +
            "#{tableRule.data},#{tableRule.tenantKey},sysdate,#{tableRule.status},#{tableRule.auditId})")
    int insertTableRule(@Param("tableRule") TableRule tableRule);
}
