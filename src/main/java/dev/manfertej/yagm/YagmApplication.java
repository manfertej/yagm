package dev.manfertej.yagm;

import dev.manfertej.yagm.common.properties.ApplicationMessages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
	//Uncomment when you don't want to connect to DB
	//(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class YagmApplication {

	public static void main(String[] args) {
		SpringApplication.run(YagmApplication.class, args);
	}

}
