package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

//  @Override
//  public void configureViewResolvers(ViewResolverRegistry registry) {
//    registry.jsp().prefix("/WEB-INF/view").suffix(".jsp");
//  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver result = new InternalResourceViewResolver();
    result.setPrefix("/WEB-INF/view/");
    result.setSuffix(".jsp");
    return result;
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("message.label");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
