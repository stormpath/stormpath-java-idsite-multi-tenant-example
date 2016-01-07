package com.stormpath.examples.idsite_multitenant.controllers;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.servlet.http.Resolver;
import com.stormpath.sdk.servlet.idsite.IdSiteOrganizationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
    @Autowired
    Client client;

    @Autowired
    Application application;

    @Autowired
    Resolver<IdSiteOrganizationContext> stormpathIdSiteOrganizationResolver;

    String getOrganizationNameKey(HttpServletRequest req) {
        return stormpathIdSiteOrganizationResolver.get(req, null).getOrganizationNameKey();
    }

}
