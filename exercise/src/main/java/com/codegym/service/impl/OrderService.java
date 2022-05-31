package com.codegym.service.impl;

import com.codegym.model.Order;
import com.codegym.repository.IOrderRepository;
import com.codegym.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return this.iOrderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> findAll(String startDayVal, String endDayVal, Pageable pageable) {
        return this.iOrderRepository.findAllByOrderDateBetween(startDayVal,endDayVal,pageable);
    }

    @Override
    public Page<Order> findAllByOrderDayBefore(String endDayVal, Pageable pageable) {
        return this.iOrderRepository.findAllByOrderDateBefore(endDayVal,pageable);
    }

    @Override
    public Page<Order> findAllByOrderDayAfter(String startDayVal, Pageable pageable) {
        return this.iOrderRepository.findAllByOrderDateAfter(startDayVal,pageable);
    }

    @Override
    public Page<Order> find(Pageable pageable) {
        return this.iOrderRepository.getTopList(pageable);
    }
}
