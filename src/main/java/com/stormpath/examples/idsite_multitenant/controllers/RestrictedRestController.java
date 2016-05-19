package com.stormpath.examples.idsite_multitenant.controllers;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestrictedRestController {

    @RequestMapping("/restricted_rest")
    public String restrictedRest(HttpServletRequest req) {
        Account account = AccountResolver.INSTANCE.getAccount(req);

        return "Hello " + account.getFullName();
    }
}
