package sg.iss.day21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.day21.repository.CustomerRepository;
import sg.iss.day21.model.Customer;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository custRepo;

    public List<Customer> getAllCustomers() {
        return custRepo.getAllCustomers();
    }

    public List<Customer> getallCustomersWithLimitAndOffset(int limit, int offset) {
        return custRepo.getAllCustomersWithLimitOff(limit, offset);
    }

    public Customer getCustomerById(int id) {
        return custRepo.getCustomerById(id);
    }
}
