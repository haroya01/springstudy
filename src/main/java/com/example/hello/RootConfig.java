package com.example.hello;

import com.example.hello.book.repository.BooksRepository;
import com.example.hello.book.service.BooksService;
import com.example.hello.config.DataSourceConfig;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class RootConfig {

//    @Bean
//    public DataSourceConfig dataSourceConfig(){
//        return new DataSourceConfig();
//    }
}