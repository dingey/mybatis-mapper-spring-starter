package com.github.dingey.mybatis.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author d
 */
@Configuration
@ConditionalOnBean({SqlSessionFactory.class})
@ConditionalOnProperty(value = "mybatis.mapper.sequence", havingValue = "true")
@EnableConfigurationProperties({MybatisMapperProperties.class})
@AutoConfigureAfter({MybatisAutoConfiguration.class})
public class MybatisMapperAutoConfiguration {
    @Resource
    private MybatisMapperProperties properties;
    @Resource
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void addPageInterceptor() {
        InsertInterceptor insertInterceptor = new InsertInterceptor(properties);
        for (SqlSessionFactory sqlSessionFactory : this.sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(insertInterceptor);
        }
    }
}
