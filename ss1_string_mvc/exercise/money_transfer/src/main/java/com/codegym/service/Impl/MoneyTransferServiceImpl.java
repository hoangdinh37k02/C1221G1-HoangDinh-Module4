package com.codegym.service.Impl;

import com.codegym.service.IMoneyTransfer;
import org.springframework.stereotype.Service;

@Service

public class MoneyTransferServiceImpl implements IMoneyTransfer {
    @Override
    public double transfer( double usd) {
        return 23000*usd;
    }
}
