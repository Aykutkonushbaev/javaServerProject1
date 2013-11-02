package hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.10.13
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */

@Component
@Controller
public class CustomerController {

    @RequestMapping(value = "/users")
    public @ResponseBody
    Iterable<Customer> listUsers() {

        return  getRepository().findAll();
    }

    @RequestMapping(value = "/add/{name}/{surname}")
    public @ResponseBody Customer addUser(@PathVariable("name") String name, @PathVariable("surname") String surname) {

        Customer customer= new Customer(name,surname);
        getRepository().save(customer);

        return customer;
    }

    public CustomerRepository getRepository() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        return customerRepository;
    }
}
