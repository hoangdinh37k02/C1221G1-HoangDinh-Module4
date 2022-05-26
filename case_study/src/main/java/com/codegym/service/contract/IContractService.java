package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();

    void delete(int id);

    Contract findById(int id);

    Page<Contract> findAllByStatus(int i, Pageable pageable);
}
