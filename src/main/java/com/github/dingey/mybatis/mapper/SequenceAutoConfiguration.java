package com.github.dingey.mybatis.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Configuration
@ConditionalOnBean({SqlSessionFactory.class})
@ConditionalOnProperty(value = "mybatis.mapper.strategy", havingValue = "sequence")
@AutoConfigureAfter({MybatisAutoConfiguration.class})
public class SequenceAutoConfiguration {

    @Resource
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void init() {
        SequenceInterceptor sequenceInterceptor = new SequenceInterceptor();
        for (SqlSessionFactory sqlSessionFactory : this.sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(sequenceInterceptor);
        }
    }
}