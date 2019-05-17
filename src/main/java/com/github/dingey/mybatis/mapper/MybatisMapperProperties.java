package com.github.dingey.mybatis.mapper;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d
 */
@ConfigurationProperties(prefix = "mybatis.mapper")
public class MybatisMapperProperties implements MapperProperties {
    private boolean camelCase = true;
    private boolean columnUpper = false;
    private String tablePrefix = "";
    private boolean tableUpper = false;

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
}
