package com.github.dingey.mybatis.mapper;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author d
 */
@Configuration
@EnableConfigurationProperties(MybatisMapperProperties.class)
public class MybatisMapperConfiguration {
    @Resource
    private MybatisMapperProperties properties;

    @Bean
    @ConditionalOnMissingBean(InsertInterceptor.class)
    public InsertInterceptor insertInterceptor() {
        return new InsertInterceptor(properties);
    }
}
