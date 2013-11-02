package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

// of course, an ApplicationContext is just a BeanFactory
//        BeanFactory factory = (BeanFactory) appContext;
//        repository = (CustomerRepository) factory.getBean("customerRepository");


        RestTemplate restTemplate = new RestTemplate();
        Customer customer[] =  restTemplate.getForObject("http://192.168.1.69:8080/users", Customer[].class);
        SpringApplication.run(Application.class, args);
        for (Customer customer1:customer){
            System.out.println("id:         "+customer1.getId());
            System.out.println("name:       "+customer1.getFirstName());
            System.out.println("surname:    "+customer1.getLastName());
        }
    }
}
