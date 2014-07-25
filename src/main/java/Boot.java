import com.aayush.trackerandrecorder.configuration.AppConfig;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;
        import org.springframework.web.WebApplicationInitializer;
        import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
        import org.springframework.web.servlet.DispatcherServlet;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRegistration;

public class Boot{



    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // keep alive
        while(true){

        }
    }

//    public void onStartup(ServletContext container) throws ServletException {
//        final AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
//        webContext.register(AppConfig.class);
//        final ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(webContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }

}
