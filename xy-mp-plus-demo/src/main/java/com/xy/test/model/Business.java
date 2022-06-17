package com.xy.test.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (t_business)实体类
 *
 * @author xiaoyuan
 * @since 2022-04-08 11:20:21
 * @description Auto created
 */
@TableName("t_business")
public class Business extends Model<Business> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Integer id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(update = "now()")
	private Date updateTime;
    /**
     * 业务名称
     */
    private String name;
    /**
     * 表Company字段seed自增加设置为值
     */
    private Integer bizId;
    /**
     * 头像
     */
    private String avatar;
    /**
     * dbName
     */
    private String dbName;
    /**
     * dbIp
     */
    private String dbIp;
    /**
     * dbPort
     */
    private Integer dbPort;
    /**
     * dbUser
     */
    private String dbUser;
    /**
     * dbPassword
     */
    private String dbPassword;
    /**
     * desc
     */
    @TableField("`desc`")
    private String desc;
    /**
     * 是否多租户 0 否 1 是
     */
    private Integer isTenant;
    /**
     * companyId
     */
    private Integer companyId;
    /**
     * 此业务数据及数据库版本，用于升级
     */
    private String dataVersion;
    /**
     * aiforce产品id
     */
    private Integer productId;
    /**
     * aiforce业务id
     */
    private Integer instanceId;
    /**
     * 公钥
     */
    private String pubbicKey;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 是否旧版本
     */
    private Integer isNodeVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(Integer isTenant) {
        this.isTenant = isTenant;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public String getPubbicKey() {
        return pubbicKey;
    }

    public void setPubbicKey(String pubbicKey) {
        this.pubbicKey = pubbicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Integer getIsNodeVersion() {
        return isNodeVersion;
    }

    public void setIsNodeVersion(Integer isNodeVersion) {
        this.isNodeVersion = isNodeVersion;
    }

}