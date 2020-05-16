package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dto.SysUser;
import web.services.SysUserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    SysUserService userService;

    @PostMapping("/register")
    public String registerSysUser(@RequestBody SysUser sysUser) {
        userService.save(sysUser);
        return "redirectTo: login";
    }
}
