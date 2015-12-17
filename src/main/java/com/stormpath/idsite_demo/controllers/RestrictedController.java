package com.stormpath.idsite_demo.controllers;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.directory.CustomData;
import com.stormpath.sdk.servlet.http.Resolver;
import com.stormpath.sdk.servlet.idsite.IdSiteOrganizationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestrictedController {
    @Autowired
    Application application;

    @Autowired
    Resolver<IdSiteOrganizationContext> stormpathIdSiteOrganizationResolver;

    @RequestMapping("/restricted")
    public String secret(HttpServletRequest req, Model model) {
        String organizationNameKey = stormpathIdSiteOrganizationResolver.get(req, null).getOrganizationNameKey();

        CustomData customData = application.getCustomData();
        String orgImageHref = (String)customData.get(organizationNameKey + "_image_href");

        model.addAttribute("orgImageHref", orgImageHref);

        return "restricted";
    }
}
