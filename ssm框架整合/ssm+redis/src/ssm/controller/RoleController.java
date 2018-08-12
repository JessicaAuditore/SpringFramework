package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Role;
import ssm.service.RoleService;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "login")
    @ResponseBody
    public Role login(@RequestBody Role role){
        System.out.println("******************");
        Role a=roleService.getRole((long)1);
        System.out.println("******************");
        Role b=roleService.getRole((long)1);
        System.out.println("******************");
        roleService.insertRole(role);
        role.setRoleName("role_name_1");
        role.setNote("role_note_1");
        //插入角色
        roleService.insertRole(role);
        //获取角色
        Role getRole = roleService.getRole(role.getId());
        getRole.setNote("rote_note_1_update");
        //更新角色
        roleService.updateRole(getRole);
        return a;
    }
}
