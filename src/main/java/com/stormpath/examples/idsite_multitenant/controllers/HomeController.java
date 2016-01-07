package com.stormpath.examples.idsite_multitenant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {

    @RequestMapping("/")
    public String home(HttpServletRequest req, Model model) {
        model.addAttribute("status", req.getParameter("status"));

        model.addAttribute("appName", application.getName());
        model.addAttribute("appDescription", application.getDescription());
        model.addAttribute("organization", getOrganizationNameKey(req).toUpperCase());

        return "home";
    }
}
