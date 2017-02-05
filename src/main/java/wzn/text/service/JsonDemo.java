package wzn.text.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wzn.text.bean.EUser;


@RestController
@RequestMapping("/json")
public class JsonDemo {
	
	@RequestMapping("/getUser")
	public EUser getUser(){
		EUser user = new EUser();
		user.setAge(20);
		user.setName("wzn");
		
		return user;
		
	}
}
