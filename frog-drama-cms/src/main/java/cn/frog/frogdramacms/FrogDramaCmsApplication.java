package cn.frog.frogdramacms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import tk.mybatis.spring.annotation.MapperScan;

import java.net.InetAddress;


@Slf4j
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = {"cn.frog"})
@MapperScan(basePackages = {"cn.frog.frogdramacms.mybatis.mapper"})
public class FrogDramaCmsApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication app = new SpringApplication(FrogDramaCmsApplication.class);

        ApplicationContext appContext = app.run(args);

        Environment env = appContext.getEnvironment();

        log.info("\n----------------------------------------------------------\n\t" +
                        "Frog Application '{}' is running! Access Urls:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
