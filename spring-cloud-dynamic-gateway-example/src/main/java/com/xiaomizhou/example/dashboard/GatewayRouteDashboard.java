package com.xiaomizhou.example.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * gateway 路由操作界面
 *
 * @author: zhangyaxi
 * @date: 2022-10-02 22:22
 */
@Controller
public class GatewayRouteDashboard {

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

}
