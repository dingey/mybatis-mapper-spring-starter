package com.github.dingey.mybatis.mapper;

import com.github.dingey.mybatis.mapper.utils.Const;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import javax.persistence.GenerationType;

/**
 * @author d
 */
@ConfigurationProperties(prefix = "mybatis.mapper")
public class MybatisMapperProperties implements MapperProperties {
    /**
     * set table and column name camel case
     */
    private boolean camelCase = true;
    /**
     * set column name uppercase
     */
    private boolean columnUpper = false;
    /**
     * set Map key column1,value column2  annotation enable
     */
    private boolean mapKey = false;
    /**
     * set the table prefix
     */
    private String tablePrefix = "";
    /**
     * set table name uppercase
     */
    private boolean tableUpper = false;
    /**
     * set primary key generate strategy support AUTO/IDENTITY/SEQUENCE
     */
    private GenerationType strategy;

    @PostConstruct
    public void init() {
        Const.camelCase = this.camelCase;
        Const.columnUpper = this.columnUpper;
        Const.tablePrefix = this.tablePrefix;
        Const.tableUpper = this.tableUpper;
    }

    @Override
    public boolean isCamelCase() {
        return camelCase;
    }

    public void setCamelCase(boolean camelCase) {
        this.camelCase = camelCase;
    }

    @Override
    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    @Override
    public boolean isTableUpper() {
        return tableUpper;
    }

    public void setTableUpper(boolean tableUpper) {
        this.tableUpper = tableUpper;
    }

    @Override
    public boolean isColumnUpper() {
        return columnUpper;
    }

    public void setColumnUpper(boolean columnUpper) {
        this.columnUpper = columnUpper;
    }

    public boolean isMapKey() {
        return mapKey;
    }

    public void setMapKey(boolean mapKey) {
        this.mapKey = mapKey;
    }

    public GenerationType getStrategy() {
        return strategy;
    }

    public void setStrategy(GenerationType strategy) {
        this.strategy = strategy;
    }
}
