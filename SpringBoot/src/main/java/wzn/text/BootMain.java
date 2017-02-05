package wzn.text;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ServletComponentScan//扫描自定义servlet和filter
public class BootMain extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(BootMain.class, args);
	}
}
