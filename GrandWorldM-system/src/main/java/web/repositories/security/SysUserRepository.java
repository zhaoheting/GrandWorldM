package web.repositories.security;

import org.springframework.stereotype.Repository;
import web.dto.security.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);

    SysUser save(SysUser sysUser);
}
