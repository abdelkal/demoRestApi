package be.unit.demo.controller;

import be.unit.demo.entity.Customer;
import be.unit.demo.exception.CustomerNotFoundException;
import be.unit.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty()) {
            throw  new CustomerNotFoundException("Customer with id "+id+" not found");
        }

        return customer.get();
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomerById(@PathVariable long id) {
        if(customerRepository.findById(id).isEmpty()) {
            throw  new CustomerNotFoundException("Customer with id "+id+" not found");
        }
        customerRepository.deleteById(id);
    }

}
