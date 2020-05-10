package web.controllers.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "Demo", description = "the Demo API")
public interface DemoApi {

    @ApiOperation(value = "hello", nickname = "hello", notes = "hello.", tags={ "Demo", })
    @ApiResponses(value = {  })
    @GetMapping(value="/hello",produces = { "application/json" })
    String hello();
}
