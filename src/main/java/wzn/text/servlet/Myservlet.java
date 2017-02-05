package wzn.text.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * springboot 编写servlet
 *
 * @author wzn
 * @date 2017年1月20日下午2:35:22
 * 1.编写servlet类 和spirng 是一样的 最简单的就是extends httpServlet 然后重写doPost/doGet
 * 2.使用注解开发 在类上配置webservlet注解
 * 3.在app类上加扫描servlet包注解 ServletComponentScan
 * 
 * 
 */

@WebServlet(urlPatterns="/myServlet",name="/wzn",loadOnStartup=1)
public class Myservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("serlvet-----");
		resp.getWriter().write("hello");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
