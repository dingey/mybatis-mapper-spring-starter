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
@ConditionalOnProperty(value = "mybatis.mapper.map-key", havingValue = "true")
@AutoConfigureAfter({MybatisAutoConfiguration.class})
public class MapKeyConfiguration {
    @Resource
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void init() {
        MapKeyInterceptor mapKeyInterceptor = new MapKeyInterceptor();
        for (SqlSessionFactory sqlSessionFactory : this.sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(mapKeyInterceptor);
        }
    }
}
