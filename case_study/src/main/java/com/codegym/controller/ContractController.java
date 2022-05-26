package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.service.IServiceService;
import com.codegym.service.service.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IContractService iContractService;

    @GetMapping({"/list","/"})
    public String showContractList(Model model, @PageableDefault(value = 5) Pageable pageable){
//        model.addAttribute("contractList", this.iContractService.findAll(pageable));
        model.addAttribute("contractList", this.iContractService.findAllByStatus(0, pageable));
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("customerList", this.iCustomerService.findAll());
        model.addAttribute("employeeList", this.iEmployeeService.findAll());
        model.addAttribute("serviceList", this.iServiceService.findAll());
        return "contract/create";
    }

    @PostMapping(value = "/create")
    public String createContract(@ModelAttribute @Validated ContractDto contractDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer", this.iCustomerService.findAll());
            model.addAttribute("employee", this.iEmployeeService.findAll());
            model.addAttribute("service", this.iServiceService.findAll());
            return "contract/create";
        } else {
            Contract contract=new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.iContractService.save(contract);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/contract/list";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") int id,
                                RedirectAttributes redirectAttributes){
//        this.iContractService.delete(id);
        Contract contract = this.iContractService.findById(id);
        contract.setStatus(1);
        this.iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Deleting successful");
        return "redirect:/contract/list";
    }

    @ExceptionHandler(MyException.class)
    public String showErrorPage(){
        return "error";
    }
}
