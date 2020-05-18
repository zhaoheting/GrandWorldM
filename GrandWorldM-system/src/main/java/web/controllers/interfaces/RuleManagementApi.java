package web.controllers.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "Rule Management", description = "Rule Management API")
@RequestMapping("/rule")
public interface RuleManagementApi {

    @ApiOperation(value = "getTableRule", nickname = "getTableRule", notes = "get table rule.", tags={ "Rule Management", })
    @ApiResponses(value = {  })
    @GetMapping(value="/table",produces = { "application/json" })
    ResponseEntity<List> getTableRule();
}
