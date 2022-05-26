package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEducationRepository;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationService iEducationService;

    @GetMapping({"/list","/"})
    public String getCustomerList(Model model, @PageableDefault(value = 5) Pageable pageable,
                                  @RequestParam Optional<String> name, @RequestParam Optional<String> email,
                                  @RequestParam Optional<String> division) {
        String nameVal = name.orElse("");
        String emailVal = email.orElse("");
        String divisionVal = division.orElse("");
        Page<Employee> employeePage = null;
        if (divisionVal.equals("")){
            employeePage = this.iEmployeeService.findAll1(0,nameVal,emailVal,pageable);
        }else {
            employeePage = this.iEmployeeService.findAll2(0,nameVal,emailVal,divisionVal,pageable);
        }
//        model.addAttribute("employee", iEmployeeService.findAll(nameVal, pageable));
        model.addAttribute("employee", employeePage);
        model.addAttribute("division", this.iDivisionService.findAll());
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("emailVal", emailVal);
        model.addAttribute("divisionVal", divisionVal);
        return "employee/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("education", this.iEducationService.findAll());
        model.addAttribute("division", this.iDivisionService.findAll());
        return "employee/create";
    }
    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute @Validated EmployeeDto employeeDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("position", this.iPositionService.findAll());
            model.addAttribute("education", this.iEducationService.findAll());
            model.addAttribute("division", this.iDivisionService.findAll());
            return "employee/create";
        } else {
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            this.iEmployeeService.save(employee);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/update")
    public String goUpdateForm(@RequestParam("employeeId") int employeeId, Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(this.iEmployeeService.findById(employeeId),employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("education", this.iEducationService.findAll());
        model.addAttribute("division", this.iDivisionService.findAll());
        return "employee/update";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute @Validated EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model){
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("position", this.iPositionService.findAll());
            model.addAttribute("education", this.iEducationService.findAll());
            model.addAttribute("division", this.iDivisionService.findAll());
            return "employee/update";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            this.iEmployeeService.save(employee);
        }
        redirectAttributes.addFlashAttribute("message", "Updating successful");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("employeeId") int employeeId,
                                RedirectAttributes redirectAttributes){
//        this.iEmployeeService.deleteById(employeeId);
        Employee employee = this.iEmployeeService.findById(employeeId);
        employee.setStatus(1);
        this.iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Deleting successful");
        return "redirect:/employee/list";
    }
}
