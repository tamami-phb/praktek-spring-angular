package lab.phb.webappangulara.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  
    @Override
    public void addViewControllers(ViewControllerRegistry reg) {
        reg.addViewController("/")
        	.setViewName("daftar-mahasiswa");
        reg.addViewController("/daftar-mhs")
        	.setViewName("daftar-mahasiswa");
        reg.addViewController("/form")
        	.setViewName("form-entry");
        reg.addViewController("/form-edit")
        	.setViewName("form-edit");
    }
    
}
