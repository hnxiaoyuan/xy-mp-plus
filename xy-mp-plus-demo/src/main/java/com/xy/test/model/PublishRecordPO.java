package com.xy.test.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 发布记录表(t_publish_record)实体类
 *
 * @author xiaoyuan
 * @since 2022-03-03 11:23:01
 * @description Auto created
 */
@TableName("t_publish_record")
public class PublishRecordPO extends Model<PublishRecordPO> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
	private Long id;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 发布记录的id
     */
    private Long knowledgeId;
    /**
     * 发布状态(待审核、审核撤销、审核驳回、发布中、发布成功、发布失败、发布取消)
     * 其中 审核撤销、审核驳回、发布成功、发布取消 为终态
     * approving、approve_revoked、approve_refused、publishing、success、failed、cancelled
     */
    private String status;
    /**
     * 知识点类型
     */
    private Integer knowledgeType;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 发布类型
     */
    private Integer publishType;
    /**
     * createUserId
     */
    private Long createUserId;
    /**
     * createUser
     */
    private String createUser;
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
     * 乐观锁版本号
     */
    private Integer versionNo;

    /**
     * 错误码
     */
    private String errorCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getKnowledgeType() {
        return knowledgeType;
    }

    public void setKnowledgeType(Integer knowledgeType) {
        this.knowledgeType = knowledgeType;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPublishType() {
        return publishType;
    }

    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}