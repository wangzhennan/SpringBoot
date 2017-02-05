package wzn.text.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Value;
/**
 * 自定义filter 通过配置文件控制编码  
 *
 * @author wzn
 * @date 2017年2月5日上午10:27:55
 */
@WebFilter(urlPatterns="/*")
public class Myfilter implements Filter {
	@Value("${response.mycharset}")
	private String charset;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init start");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter 过滤");
		System.out.println(charset);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}

}
