package com.gxzx.testrabbitmq.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 资金流水表
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
public class AccountEntry extends Model<AccountEntry> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * otc用户ID（otc_user表ID）
     */
    private Long userId;

    /**
     * 账户ID
     */
    private Long otcAccountId;

    /**
     * 业务类型:1,资金划转订单: 2, 委托交易订单: 3, 撤销委托交易订单:
     */
    private Integer bizType;

    /**
     * 本次操作币数量
     */
    private BigDecimal amount;

    /**
     * 币种code
     */
    private String coinCode;

    /**
     * 账户类型：1，可用账户；2，冻结账户；3，押金账户
     */
    private Integer accountType;

    /**
     * 业务订单号：包含划转、广告、订单等单号
     */
    private String bizOrderNo;

    /**
     * 备注
     */
    private String remark;

    private Date gmtCreatedTime;

    private Date gmtModifiedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOtcAccountId() {
        return otcAccountId;
    }

    public void setOtcAccountId(Long otcAccountId) {
        this.otcAccountId = otcAccountId;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreatedTime() {
        return gmtCreatedTime;
    }

    public void setGmtCreatedTime(Date gmtCreatedTime) {
        this.gmtCreatedTime = gmtCreatedTime;
    }

    public Date getGmtModifiedTime() {
        return gmtModifiedTime;
    }

    public void setGmtModifiedTime(Date gmtModifiedTime) {
        this.gmtModifiedTime = gmtModifiedTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AccountEntry{" +
        "id=" + id +
        ", userId=" + userId +
        ", otcAccountId=" + otcAccountId +
        ", bizType=" + bizType +
        ", amount=" + amount +
        ", coinCode=" + coinCode +
        ", accountType=" + accountType +
        ", bizOrderNo=" + bizOrderNo +
        ", remark=" + remark +
        ", gmtCreatedTime=" + gmtCreatedTime +
        ", gmtModifiedTime=" + gmtModifiedTime +
        "}";
    }
}
