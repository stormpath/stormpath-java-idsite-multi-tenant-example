package com.stormpath.examples.idsite_multitenant.controllers;

import com.stormpath.sdk.directory.CustomData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestrictedController extends BaseController {

    @RequestMapping("/restricted")
    public String secret(HttpServletRequest req, Model model) {
        String organization = getOrganizationNameKey(req);
        model.addAttribute("organization", organization.toUpperCase());

        CustomData customData = application.getCustomData();
        String orgImageHref = (String)customData.get(organization + "_image_href");
        if (orgImageHref != null) {
            model.addAttribute("orgImageHref", orgImageHref);
        }

        return "restricted";
    }
}
