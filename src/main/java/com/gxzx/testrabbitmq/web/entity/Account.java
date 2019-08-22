package com.gxzx.testrabbitmq.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * OTC账户表
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * otc用户ID（otc_user表ID）
     */
    private Long userId;

    /**
     * 账户类型：1，币币交易可用余额账户；2，币币交易冻结账户；3，押金账户; 
     */
    private Integer accountType;

    /**
     * 币数量
     */
    private BigDecimal amount;

    /**
     * 币种code
     */
    private String coinCode;

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

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
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
        return "Account{" +
        "id=" + id +
        ", userId=" + userId +
        ", accountType=" + accountType +
        ", amount=" + amount +
        ", coinCode=" + coinCode +
        ", gmtCreatedTime=" + gmtCreatedTime +
        ", gmtModifiedTime=" + gmtModifiedTime +
        "}";
    }
}
