import model.Language;
import model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc //Để kích hoạt cấu hình spring mvc bằng class
@ComponentScan("controller")
@Configuration //@Configuration là một Annotation đánh dấu trên một Class cho phép Spring Boot biết được đây là nơi định nghĩa ra các Bean.
public class WebConfig implements WebMvcConfigurer {

    //Phương thức này được inject vào trong class với Annonation @Bean,để các lớp khác có thể dependency
    @Bean //@Bean là một Annotation được đánh dấu trên các method(ám chỉ đối tượng được container quản lý)
    InternalResourceViewResolver resolver(){  //InternalResourceViewResolver là một implementation của ViewResoler để xử lý tầng view của Spring MVC
        System.out.println("--------->Call WebConfig");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/view"); //Config xuong view
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public Language language2() { //@Autowired de tiem cac Dependency
        Language language1 = new Language("JAVA");
        return language1;
    }

}
