/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.kaampay.service.impl;

import com.cibt.kaampay.entity.EmailTemplate;
import com.cibt.kaampay.repository.EmailTemplateRepository;
import com.cibt.kaampay.repository.impl.EmailTemplateRepoImpl;
import com.cibt.kaampay.service.EmailTemplateService;
import java.util.List;

/**
 *
 * @author Derslived
 */
public class EmailTemplateServiceImpl implements EmailTemplateService{
    public EmailTemplateRepository emailRepo = new EmailTemplateRepoImpl();

    @Override
    public void save(EmailTemplate model) throws Exception {
       
        if(model.getId()==0){
            emailRepo.insert(model);
        }else{
            emailRepo.update(model);
        }
        
    }

    @Override
    public List<EmailTemplate> findAll() throws Exception {
     
        return emailRepo.findAll();
        
    }

    @Override
    public EmailTemplate findById(int id) throws Exception {
      return emailRepo.findById(id);
    }
    
}
