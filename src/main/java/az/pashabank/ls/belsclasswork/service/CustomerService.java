package az.pashabank.ls.belsclasswork.service;

import az.pashabank.ls.belsclasswork.model.dto.CustomerDTO;
import az.pashabank.ls.belsclasswork.model.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private final Logger logger = Logger.getLogger(CustomerService.class.getName());

    HashMap<Long, CustomerDTO> customerDTOMap = new HashMap<>();

    public CustomerDTO getCustomer(Long id) {
        return customerDTOMap.get(id);
    }


    public HashMap<Long, CustomerDTO> createCustomer(CustomerRequest customerRequest) {

        CustomerDTO customerDTO = new CustomerDTO(customerRequest.getName());

        customerDTOMap.put(customerDTO.getCounter(), customerDTO);
        return customerDTOMap;
    }


    public HashMap<Long, CustomerDTO> deleteCustomer(Long id) {
        customerDTOMap.remove(id);
        return customerDTOMap;
    }

    public HashMap<Long, CustomerDTO> updateCustomer(Long id, CustomerRequest customerRequest) {
        CustomerDTO customerDTO = customerDTOMap.get(id);

        if (customerDTO == null) {
            logger.info("Customer with id: " + id + " not found");
        }

        customerDTOMap.get(id).setName(customerRequest.getName());
        return customerDTOMap;
    }
}
