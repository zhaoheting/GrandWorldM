package com.example.GrandWorldM.dao;

import com.example.GrandWorldMSpec.generated.model.TableRule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;


@Mapper
public interface RuleDao {

    @Select("SELECT id,bundle,name,version,data,tenant_key,last_updated,status,audit_id FROM table_rule " +
            "WHERE bundle = #{bundleName} and name = #{ruleName} and tenant_key = #{tenantKey} and version = #{version}")
    TableRule selectTableRule(@Param("bundleName") String bundleName, @Param("ruleName") String ruleName, @Param("tenantKey") String tenantKey, @Param("version") String version);
}
