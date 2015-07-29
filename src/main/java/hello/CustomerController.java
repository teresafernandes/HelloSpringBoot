package hello;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("customer")
public class CustomerController {


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer greetings(@PathVariable("id") Long id) {
        Customer customer = new Customer();
        customer.setName("Eddu");
        customer.setLastname("Melendez");
        return customer;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Customer> list() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Customer customer) {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Customer customer) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateById(@PathVariable("id") Long id, @RequestBody Customer customer) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete() {

    }

    @SuppressWarnings("serial")
	class Customer implements Serializable {

        private String name;

        private String lastname;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getLastname() {
            return lastname;
        }
    }
}