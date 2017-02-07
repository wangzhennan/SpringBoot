package wzn.text.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 编写AOP案例 注解开发
 *
 * @author wzn
 * @date 2017年2月7日下午2:50:44
 */
@RestController
public class TestSpringAop {
	@RequestMapping("/helloAop")
	public String helloAop(String name,String sex){
		return "name:"+ name+"&&sex:"+sex;
	}
}
