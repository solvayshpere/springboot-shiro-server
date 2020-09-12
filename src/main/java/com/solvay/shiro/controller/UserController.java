package com.solvay.shiro.controller;

import com.solvay.shiro.dao.RoleMapper;
import com.solvay.shiro.entity.User;
import com.solvay.shiro.realms.ShiroRealm;
import com.solvay.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: solvay
 * @date: 2018/5/12
 * @description:
 */
@RestController
@RequestMapping("userInfo")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    @Qualifier("shiroRedisTemplate")
    private RedisTemplate shiroRedisTemplate;

    /**
     * 创建固定写死的用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String login(Model model) {

        User user = new User();
        user.setName("Hpuswl");
        user.setId_card_num("177777777777777777");
        user.setUsername("solvay");

        userService.insert(user);

        return "创建用户成功";

    }

    /**
     * 删除固定写死的用户
     * @param model
     * @return
     */
    @RequiresPermissions("userInfo:del")
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    @ResponseBody
    public String del(Model model) {

        userService.del("solvay");

        return "删除用户名为solvay用户成功";

    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    @ResponseBody
    public String view(Model model) {

        return "这是用户列表页";

    }

    /**
     * 给admin用户添加 userInfo:del 权限
     * @param model
     * @return
     */
    @RequestMapping(value = "/addPermission",method = RequestMethod.GET)
    @ResponseBody
    public String addPermission(Model model) {

        //在sys_role_permission 表中  将 删除的权限 关联到admin用户所在的角色
        roleMapper.addPermission(1,3);

        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return "给admin用户添加 userInfo:del 权限成功";

    }

    /**
     * 删除admin用户 userInfo:del 权限
     * @param model
     * @return
     */
    @RequestMapping(value = "/delPermission",method = RequestMethod.GET)
    @ResponseBody
    public String delPermission(Model model) {

        //在sys_role_permission 表中  将 删除的权限 关联到admin用户所在的角色
        roleMapper.delPermission(1,3);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();

        return "删除admin用户userInfo:del 权限成功";

    }

    /**
     * 将该权限赋给 admin用户 使用admin用户清理其他用户的 权限缓存
     * @param username
     * @return
     */
    @RequiresPermissions("userInfo:clearCache")
    @RequestMapping(value = "/clearCache",method = RequestMethod.GET)
    @ResponseBody
    public String clearCache(String username) {

        String[] keys = new String[3];
        keys[0] = "shiro:cache:authenticationCache:" + username;
        keys[1] = "shiro:cache:authorizationCache:" + username;
        keys[2] = "shiro:cache:retrylimit:" + username;

        //原子性 命令 删除多个key
        shiroRedisTemplate.delete(CollectionUtils.arrayToList(keys));

        return "删除" + username + "权限成功";

    }

}