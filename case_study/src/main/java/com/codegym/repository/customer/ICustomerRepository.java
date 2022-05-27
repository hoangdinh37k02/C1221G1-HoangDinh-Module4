package com.codegym.repository.customer;

import com.codegym.dto.IOther;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Pattern;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByCustomerNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int type, Pageable pageable);

    Page<Customer> findAllByStatusAndCustomerNameContainingAndEmailContaining(int i,String name, String email, Pageable pageable);
    Page<Customer> findAllByStatusAndCustomerNameContainingAndEmailContainingAndCustomerType_Id(int i,String name, String email,int type, Pageable pageable);

    @Query(value = "select customer.customer_name customerName, c.contract_id contractId, s.service_name serviceName, c.start_day startDay,c.end_day endDay,\n" +
            "       group_concat(as.attach_service_name) attachService,\n" +
            "sum(coalesce(cd.quantity*as.attach_service_cost,0))+s.service_cost total\n" +
            "from customer join contract c on customer.customer_id = c.customer_id\n" +
            "join service s on s.service_id = c.service_id\n" +
            "left join contract_detail cd on c.contract_id = cd.contract_id\n" +
            "left join attach_service `as` on `as`.attach_service_id = cd.attach_service_id\n" +
            "group by c.contract_id",
            countQuery="select customer.customer_name customerName, c.contract_id contractId, s.service_name serviceName, c.start_day startDay,c.end_day endDay,\n" +
                    "       group_concat(as.attach_service_name) attachService,\n" +
                    "sum(coalesce(cd.quantity*as.attach_service_cost,0))+s.service_cost total\n" +
                    "from customer join contract c on customer.customer_id = c.customer_id\n" +
                    "join service s on s.service_id = c.service_id\n" +
                    "left join contract_detail cd on c.contract_id = cd.contract_id\n" +
                    "left join attach_service `as` on `as`.attach_service_id = cd.attach_service_id\n" +
                    "group by c.contract_id", nativeQuery = true
    )

    Page<IOther> getPage(Pageable pageable);

}
