package com.example.hello;

import com.example.hello.book.repository.BooksRepository;
import com.example.hello.book.service.BooksService;
import com.example.hello.config.DataSourceConfig;
import org.springframework.context.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan
public class RootConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
        multipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024); // 파일당 업로드 크기 제한 (5MB)
        return multipartResolver;
    }



//    @Bean
//    public DataSourceConfig dataSourceConfig(){
//        return new DataSourceConfig();
//    }
}