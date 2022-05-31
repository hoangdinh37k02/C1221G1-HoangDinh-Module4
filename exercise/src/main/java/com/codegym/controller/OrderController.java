package com.codegym.controller;

import com.codegym.model.Order;
import com.codegym.service.IOderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import com.codegym.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private IOderService iOderService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping({"/list","/"})
    public String getListOrder(Model model, @PageableDefault(5) Pageable pageable,
                               @RequestParam Optional<String> startDay,
                               @RequestParam Optional<String> endDay){

        String startDayVal = startDay.orElse("");
        String endDayVal = endDay.orElse("");
        Page<Order> orderPage = null;
        if (startDayVal.equals("")&endDayVal.equals("")){
            orderPage = this.iOderService.findAll(pageable);
        } else if(startDayVal.equals("")){
            orderPage = this.iOderService.findAllByOrderDayBefore(endDayVal, pageable);
        } else  if(endDayVal.equals("")){
            orderPage = this.iOderService.findAllByOrderDayAfter(startDayVal, pageable);
        } else {
            orderPage= this.iOderService.findAll(startDayVal, endDayVal,pageable);
        }
        model.addAttribute("orderList", orderPage);
        model.addAttribute("startDayVal",startDayVal);
        model.addAttribute("endDayVal",endDayVal);
        return "/list";
    }

    @GetMapping(value = "/top")
    public String getListTop(Model model,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             @RequestParam(defaultValue = "1") Integer page){
        if(pageSize<1){
            pageSize=5;
        }
        Pageable pageable= PageRequest.of(page,pageSize);
        model.addAttribute("topList", this.iOderService.find(pageable));
        return "/top";
    }
}
