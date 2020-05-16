package web.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dto.SysUser;
import web.repositories.SysUserRepository;

@Service
public class SysUserService {

    SysUserRepository sysUserRepository;
    PasswordEncoder passwordEncoder;

    public SysUserService(SysUserRepository sysUserRepository,PasswordEncoder passwordEncoder) {
        this.sysUserRepository = sysUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SysUser save(SysUser sysUser){
        //Password must be encoded after spring security 5.0. And it's the encoded password that will be saved into db.
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserRepository.save(sysUser);
        return sysUser;
    }
}
