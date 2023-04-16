package com.demo_bank_v1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo_bank_v1.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public ModelAndView getIndex() {

		ModelAndView getIndexPage = new ModelAndView("index");
		getIndexPage.addObject("title", "home");
		System.out.println("this is Home page");
		return getIndexPage;
	}


	
	@GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        getErrorPage.addObject("PageTitle", "Errors");
        System.out.println("In Error Page Controller");
        return getErrorPage;
    }
	
	@GetMapping("/verify")
	public ModelAndView getVerify(@RequestParam("token") String token, @RequestParam("code") String code) {

		ModelAndView getVerifyPage; 
		
		String dbToken= userRepository.checkToken(token);
		
		if(dbToken==null) {
			getVerifyPage= new ModelAndView("error");
			getVerifyPage.addObject("error", "this session hass Expired");
			
			return getVerifyPage;
		}
		
		userRepository.verifyAccount(token, code);
		
		getVerifyPage= new ModelAndView("login");
		getVerifyPage.addObject("success", "Account Verified Successfully, Please proceed to Log In!");

	        System.out.println("In Verify Account Controller");
	        return getVerifyPage;
	}

}
