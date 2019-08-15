package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevLoginController {
    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/login")
    public String login(){
        return "jsp/devlogin";
    }

    @RequestMapping(value="/dologin",method=RequestMethod.POST)
    public String doLogin(@RequestParam("devCode") String devCode,
                          @RequestParam("devPassword") String devPassword,
                          HttpServletRequest request, HttpSession session,
                          Model model){
        //调用service方法，进行用户匹配
        DevUser user = null;
        try {
            user = devUserService.login(devCode,devPassword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(null != user){//登录成功
            //放入session
            session.setAttribute(Constants.DEV_USER_SESSION, user);
            //页面跳转（main.jsp）
            return "jsp/developer/main";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "jsp/devlogin";
        }
/*        //处理登录结果
        if (null != user){
            //登录成功
            session.setAttribute("userSession",user);
            //返回视图
            return "/jsp/developer/main";
        }else {
            model.addAttribute("error","登录失败");
            return "/jsp/devlogin";
        }*/
    }
}
