package team.project.WhatToEatToday.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final EntityManager em;
    private final CustomerRepository customerRepository;


    @Transactional
    public String join(Customer customer) {
        validateDuplicateCustomer(customer);
        customerRepository.save(customer);
        return customer.getId();
    }

    private void validateDuplicateCustomer(Customer customer) {
        List<Customer> findCustomers = customerRepository.findById(customer.getId());
        if(!findCustomers.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    //회원 전체 조회
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    public Customer findOne(String customerId) {
        return customerRepository.findOne(customerId);
    }

}
