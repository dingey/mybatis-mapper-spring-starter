package com.github.dingey.mybatis.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author d
 */
@Configuration
@ConditionalOnBean({SqlSessionFactory.class})
@EnableConfigurationProperties({MybatisMapperProperties.class})
public class MybatisMapperConfiguration {
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
