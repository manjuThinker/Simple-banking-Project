package com.demo_bank_v1.controler_advisor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo_bank_v1.models.User;

@ControllerAdvice
public class AdvisorController {
	 @ModelAttribute("registerUser")
	    public User getUserDefaults(){
	        return new User();
	    }
	
	

}
