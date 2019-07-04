/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.servlet.admin;

import com.cibt.kaampay.entity.EmailTemplate;
import com.cibt.kaampay.entity.User;
import com.cibt.kaampay.service.EmailTemplateService;
import com.cibt.kaampay.service.impl.EmailTemplateServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Derslived
 */
@WebServlet(name = "emailTemplates", urlPatterns = ("/admin/emailtemplates/*"))
public class EmailTemplatesServlet extends HttpServlet {

    public EmailTemplateService tempService = new EmailTemplateServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = "index";
        Boolean isRedirect = false;
        try {
            if (req.getRequestURI().contains("/add")) {
                page = "add";
            } else if (req.getRequestURI().contains("/edit")) {
                String[] tokens = req.getRequestURI().split("/");
                try{
                int id = Integer.parseInt(tokens[tokens.length - 1]);
                req.setAttribute("template", tempService.findById(id));
                page = "edit";
                }
                catch(NumberFormatException ne){
                    isRedirect= true;
                    resp.sendRedirect(req.getContextPath() + "/admin/emailtemplates");
                }
            } else {
                req.setAttribute("templates", tempService.findAll());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if(!isRedirect){
        req.getRequestDispatcher("/WEB-INF/views/admin/emailtemplates/" + page + ".jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmailTemplate eTemplate = new EmailTemplate();
        if(req.getParameter("id")!=null){
        eTemplate.setId(Integer.parseInt(req.getParameter("id")));
    }

        eTemplate.setTitle(req.getParameter("title"));
        eTemplate.setSlug(req.getParameter("slug"));
        eTemplate.setSubject(req.getParameter("subject"));
        eTemplate.setBody(req.getParameter("body"));
        User user =(User)req.getSession().getAttribute("loggedin");
        eTemplate.setCreatedBy(user.getId());

        try {
            tempService.save(eTemplate);
            resp.sendRedirect(req.getContextPath() + "/admin/emailtemplates");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
