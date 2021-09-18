package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.LagouSecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {


    @LagouAutowired
    private IDemoService demoService;


    /**
     * URL: /demo/query?name=lisi
     * @param request
     * @param response
     * @param name
     * @return
     */
    @LagouRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response,String name) {
        return demoService.get(name);
    }

    /**
     * URL: /demo/query1?username=lisi
     * @param request
     * @param response
     * @param username
     * @return
     */
    @LagouRequestMapping("/query1")
    @LagouSecurity(value = "lisi,zhangshan")
    public void queryBySecurity(HttpServletRequest request, HttpServletResponse response,String username) throws Exception {
        String name =  demoService.get(username);
        response.getWriter().write(name);
    }
}
