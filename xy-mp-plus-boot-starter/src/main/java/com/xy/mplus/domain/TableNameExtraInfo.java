package com.xy.mplus.domain;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 动态表名的前后缀信息
 * @author xiaoyuan
 * @date 2022-04-08
 */
public class TableNameExtraInfo {

    private String prefix;

    @TableField
    private String suffix;

    public TableNameExtraInfo(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public static TableNameExtraInfo empty(){
        return new TableNameExtraInfo("", "");
    }

    public static TableNameExtraInfo of(String prefix, String suffix){
        return new TableNameExtraInfo(prefix, suffix);
    }
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
