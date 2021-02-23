package com.converter.service.impl;

import com.converter.service.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterImpl implements Converter {
    @Override
    public double convert(double usd, double rate) {
        return usd *rate;
    }
}
