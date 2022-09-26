package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Customer;
import service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getAllCustomers(Map<String, List<Customer>> map) {
		List<Customer> customers = customerService.findAllCustomers();
		map.put("customers", customers);
		return "customerlist";
	}

	@GetMapping("/showform")
	public String showFormForSave(Model model) {
		Customer customer = new Customer();
		model.addAttribute(customer);
		return "customerform";
	}

	@GetMapping("/edit/{id}")
	public String showFormForSave(Model model, @PathVariable int id) {
		Customer customer = this.customerService.findCustomerById(id);
		model.addAttribute(customer);
		return "customerform";
	}

	@PostMapping("/save")
	public String saveOrUpdate(Customer customer) {
		Customer savedCustomer = null;
		System.out.println(customer);
		if (customer.getId() != 0) {
			savedCustomer = customerService.findCustomerById(customer.getId());
			savedCustomer.setFirst_Name(customer.getFirst_Name());
			savedCustomer.setLast_Name(customer.getLast_Name());
			savedCustomer.setEmail_Address(customer.getEmail_Address());
		} else {
			savedCustomer = new Customer(customer.getFirst_Name(), customer.getLast_Name(),
					customer.getEmail_Address());
		}
		this.customerService.saveorUpdate(savedCustomer);
		return "redirect:/customers/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		this.customerService.delete(id);
		return "redirect:/customers/list";
	}
}
