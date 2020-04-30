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
@ConditionalOnProperty(value = "mybatis.mapper.map-results", havingValue = "true")
@AutoConfigureAfter({MybatisAutoConfiguration.class})
public class MapResultsConfiguration {
    @Resource
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void init() {
        MapResultsInterceptor mapResultsInterceptor = new MapResultsInterceptor();
        for (SqlSessionFactory sqlSessionFactory : this.sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(mapResultsInterceptor);
        }
    }
}
