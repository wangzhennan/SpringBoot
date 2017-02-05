package wzn.text.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wzn.text.bean.AdminUser;
import wzn.text.service.UserService;

@RestController
public class AdminController {
	@Autowired
	private UserService UserService;
	
	@RequestMapping("/adminuser")
	public List<AdminUser> findUser(){
		return UserService.findAdmin(); 
	}
}
