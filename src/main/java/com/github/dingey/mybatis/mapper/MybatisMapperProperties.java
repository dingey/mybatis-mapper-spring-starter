package com.github.dingey.mybatis.mapper;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * @author d
 */
@ConfigurationProperties(prefix = "mybatis.mapper")
public class MybatisMapperProperties implements MapperProperties {
    private boolean camelCase = true;
    private boolean columnUpper = false;
    private boolean mapResults = false;
    private boolean sequence = false;
    private String tablePrefix = "";
    private boolean tableUpper = false;

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

    public boolean isMapResults() {
        return mapResults;
    }

    public void setMapResults(boolean mapResults) {
        this.mapResults = mapResults;
    }

    public boolean isSequence() {
        return sequence;
    }

    public void setSequence(boolean sequence) {
        this.sequence = sequence;
    }
}
