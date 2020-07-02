package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dto.security.SysUser;
import web.services.security.SysUserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    SysUserService userService;


    @PostMapping("/saveSysUser")
    public String saveSysUser(SysUser sysUser) {
        userService.save(sysUser);
        return "login";
    }
}
