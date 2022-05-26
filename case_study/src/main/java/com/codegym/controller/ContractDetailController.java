package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachServiceService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping({"/list","/"})
    public String showContractDetailList(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("contractDetailList", this.iContractDetailService.findAll(pageable));
        return "contract_detail/list";
    }


    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        model.addAttribute("contractList", this.iContractService.findAll());
        model.addAttribute("attachService", this.iAttachServiceService.findAll());
        return "contract_detail/create";
    }

    @PostMapping(value = "/create")
    public String createContractDetail(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contract", this.iContractService.findAll());
            model.addAttribute("attachService", this.iAttachServiceService.findAll());
            return "contract_detail/create";
        } else {
            ContractDetail contractDetail=new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            this.iContractDetailService.save(contractDetail);
        }
        redirectAttributes.addFlashAttribute("message", "Creation successful");
        return "redirect:/contractDetail/list";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam("id") int id,
                                RedirectAttributes redirectAttributes){
        this.iContractDetailService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleting successful");
        return "redirect:/contractDetail/list";
    }
}
