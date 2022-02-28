import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.study")
//扫描包的类 进行托管管理
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
