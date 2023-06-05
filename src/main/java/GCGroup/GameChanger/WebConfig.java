package GCGroup.GameChanger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import jakarta.servlet.ServletContext;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Autowire the ServletContext
    private final ServletContext servletContext;

    public WebConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    // Implement configuration methods here

    @Bean
    public ViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        // Add ServletContext attribute resolver
        viewResolver.setServletContext(servletContext);
        return viewResolver;
    }

}
