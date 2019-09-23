package az.pashabank.ls.belsclasswork.controller;

import az.pashabank.ls.belsclasswork.model.dto.CustomerDTO;
import az.pashabank.ls.belsclasswork.model.request.CustomerRequest;
import az.pashabank.ls.belsclasswork.service.CustomerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.logging.Logger;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Logger logger = Logger.getLogger(CustomerController.class.getName());
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        logger.info("get Customer" + id);
        return customerService.getCustomer(id);
    }

    @PostMapping
    public HashMap<Long, CustomerDTO> createCustomer(@RequestBody CustomerRequest customerRequest) {
        logger.info("created Customer with name:" + customerRequest.getName());
        return customerService.createCustomer(customerRequest);

    }

    @PutMapping("{id}")
    public HashMap<Long, CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        logger.info("updated Customer with id: " + id + " with name:" + customerRequest.getName());
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("{id}")
    public HashMap<Long, CustomerDTO> deleteCustomer(@PathVariable Long id) {
        logger.info("deleted Customer with id: " + id);
        return customerService.deleteCustomer(id);
    }
}
