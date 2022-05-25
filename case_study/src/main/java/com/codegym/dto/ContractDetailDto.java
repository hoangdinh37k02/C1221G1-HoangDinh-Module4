package com.codegym.dto;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;

public class ContractDetailDto {
    private int contractDetailId;
    private int quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
