package com.dictionary.repository.impl;

import com.dictionary.repository.DictRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryImpl implements DictRepository {
    @Override
    public Map<String, String> getDictionary() {
        Map<String,String> dict = new HashMap<>();
        dict.put("mèo","cat");
        dict.put("ghế", "chair");
        dict.put("chuột", "mousse");
        dict.put("trâu", "buffalo");
        dict.put("chó", "dog");
        dict.put("khỉ", "monkey");
        dict.put("người", "human");
        dict.put("heo", "pig");
        dict.put("ngựa", "horse");
        return dict;
    }
}
