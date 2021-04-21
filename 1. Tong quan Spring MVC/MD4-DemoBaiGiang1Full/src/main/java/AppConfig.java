import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    public void HelloCodeGym(){
        System.out.println("Hello CodeGym");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("============> Call AppConfig");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
