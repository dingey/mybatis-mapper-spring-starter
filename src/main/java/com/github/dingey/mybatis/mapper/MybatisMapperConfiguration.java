package com.github.dingey.mybatis.mapper;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author d
 */
@Configuration
public class MybatisMapperConfiguration {

    @Bean
    @ConditionalOnMissingBean(InsertInterceptor.class)
    public InsertInterceptor insertInterceptor() {
        return new InsertInterceptor();
    }
}
