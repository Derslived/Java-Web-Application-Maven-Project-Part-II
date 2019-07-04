/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.filter;

import com.cibt.kaampay.entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Derslived
 */
public class AuthFilter implements Filter {

 @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        
        if(session!=null && session.getAttribute("loggedin")!=null){
            
            User user = (User)session.getAttribute("loggedin");
            
            if(user!=null && user.isStatus()){
                chain.doFilter(req, res);
            } else{
                res.sendRedirect(req.getContextPath() + "/login?inactive");
            }
            
        }else{
            res.sendRedirect(req.getContextPath() + "/login?error");
        }
        
        
        
        
    }

    @Override
    public void destroy() {
        
    }

}
