package com.study.controller;

import com.study.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面操作;
 *
 * @author kata
 * @create 2017-11-26
 */
@Controller
public class HomeController {

    /**
     * GET方式访问首页;
     *
     * @return 返回login页面;
     */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * POST提交数据;
     *
     * @param request requst请求;
     * @param user    user对象数据;
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }

    /**
     * 用户管理页面;
     *
     * @return
     */
    @RequestMapping(value={"/usersPage",""})
    public String usersPage(){
        return "user/users";
    }

    /**
     * 角色管理页面,角色分配资源;
     *
     * @return
     */
    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    /**
     * 资权管理页面;
     *
     * @return
     */
    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "resources/resources";
    }

    /**
     * 未授权页面;
     *
     * @return
     */
    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }
}
