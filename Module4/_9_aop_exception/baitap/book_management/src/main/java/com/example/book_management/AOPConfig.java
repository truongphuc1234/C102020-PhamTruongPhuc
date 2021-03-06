package com.example.book_management;

import com.example.book_management.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig{
    @Bean
    public Logger getLogger(){
        return new Logger();
    }

}
