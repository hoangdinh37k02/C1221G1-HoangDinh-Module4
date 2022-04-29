package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class DictionaryServiceImpl implements IDictionaryService {
    @Override
    public String translate(String search) {
        Map<String, String> dic = new HashMap<>();
            dic.put("hello", "Xin chào");
            dic.put("how", "Thế nào");
            dic.put("book", "Quyển vở");
            dic.put("computer", "Máy tính");

        String result = dic.get(search);
        if (result == null) {
            result = "Not Found";
        }
        return result;
    }
}
