package sba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sba.Customer;
import sba.CustomerRepository;

@Controller    
@RequestMapping(path="/customer") // This means URL's start with /customer
public class MainController {
	@Autowired 
	private CustomerRepository customerRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewCustomer (@RequestParam String name
			, @RequestParam String city, @RequestParam String doj, @RequestParam String phonenumber) {		
		Customer c = new Customer();
		c.setName(name);
		c.setCity(city);
		c.setDoj(doj);
		c.setPhonenumber(phonenumber);
		customerRepository.save(c);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
