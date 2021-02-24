package com.dictionary.service.impl;

import com.dictionary.repository.DictRepository;
import com.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictRepository repository;

    @Override
    public String search(String key) {
        Map<String, String> dict = repository.getDictionary();
        String result = dict.get(key);
        if (result == null) return "Không tìm thấy từ cần tìm";
        return result;
    }
}
