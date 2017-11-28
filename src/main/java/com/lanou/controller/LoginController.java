package com.lanou.controller;

import com.lanou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller
public class LoginController {

    /**
     * 登录
     **/
    @RequestMapping("/login")
    public String login(
            @Validated
                    User user,
            BindingResult result,
            HttpSession session,
            Model model) {
        // 判断user对象输入验证的对象是否为空
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            // 获取某个属性的错误信息
            FieldError usernameError = result.getFieldError("username");
            FieldError passwordError = result.getFieldError("password");
            /*输入验证信息错误回显*/
            model.addAttribute("uError",usernameError);
            model.addAttribute("pError",passwordError);
            // 将输入验证的错误信息回显到登录页面
            model.addAttribute("errors",errors);
        }

        if (user != null && ("a").equals(user.getUsername()) && ("123").equals(user.getPassword())) {
            // 保存用户名密码
            session.setAttribute("username", user.getUsername());
            return "forward:home"; // 转发进入home主页
        }
        model.addAttribute("loginError", "登录失败,用户名或密码不存在");

        return "login"; // 登录失败不跳转,保留在当前页面
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        /*清除session中存储的用户名*/
        session.invalidate();
        return "login";
    }


}
