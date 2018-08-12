package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ssm.config.RedisConfig;
import ssm.config.RootConfig;
import ssm.pojo.Role;
import ssm.service.RoleService;

public class test1 {

    @Test
    public void test() {
        //使用注解Spring IoC 容器
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class, RedisConfig.class);
        //获取角色服务类
        RoleService roleService = context.getBean(RoleService.class);
        System.out.println("******************");
        Role a=roleService.getRole((long)1);
        System.out.println("******************");
        Role b=roleService.getRole((long)1);
        System.out.println("******************");
        Role role = new Role();
        role.setRoleName("role_name_1");
        role.setNote("role_note_1");
        //插入角色
        roleService.insertRole(role);
        //获取角色
        Role getRole = roleService.getRole(role.getId());
        getRole.setNote("rote_note_1_update");
        //更新角色
        roleService.updateRole(getRole);
    }
}
