package com.codegym.repository;

import com.codegym.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findAllByOrderDateBetween(String startDay, String endDay, Pageable pageable);
    Page<Order> findAllByOrderDateBefore(String endDayVal, Pageable pageable);
    Page<Order> findAllByOrderDateAfter(String startDayVal, Pageable pageable);

    @Query(value = "select op.order_id, p.product_id, p.product_name, p.price,\n" +
            "       pt.name, op.order_date, op.quantity,\n" +
            "       sum(coalesce(op.quantity*p.price,0)) Total\n" +
            "from product p join order_product op on p.product_id = op.product_id\n" +
            "             join product_type pt on pt.id = p.product_type\n" +
            "group by op.order_id\n" +
            "order by Total DESC\n",
            countQuery = "select op.order_id, p.product_id, p.product_name, p.price,\n" +
                    "       pt.name, op.order_date, op.quantity,\n" +
                    "       sum(coalesce(op.quantity*p.price,0)) Total\n" +
                    "from product p join order_product op on p.product_id = op.product_id\n" +
                    "             join product_type pt on pt.id = p.product_type\n" +
                    "group by op.order_id\n" +
                    "order by Total DESC\n"
                    , nativeQuery=true)
    Page<Order> getTopList(Pageable pageable);

}
