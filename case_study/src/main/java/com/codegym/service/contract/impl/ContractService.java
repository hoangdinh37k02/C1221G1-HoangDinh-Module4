package com.codegym.service.contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {

        return this.iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return this.iContractRepository.findAll();
    }

    @Override
    public void delete(int id) {
        this.iContractRepository.deleteById(id);
    }

    @Override
    public Contract findById(int id) {
        return this.iContractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllByStatus(int i, Pageable pageable) {
        return this.iContractRepository.findAllByStatus(0,pageable);
    }
}
