package com.codegym.service;

import com.codegym.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOderService {
    Page<Order> findAll(Pageable pageable);

    Page<Order> findAll(String startDayVal, String endDayVal, Pageable pageable);

    Page<Order> findAllByOrderDayBefore(String endDayVal, Pageable pageable);

    Page<Order> findAllByOrderDayAfter(String startDayVal, Pageable pageable);

    Page<Order> find(Pageable pageable);
}
