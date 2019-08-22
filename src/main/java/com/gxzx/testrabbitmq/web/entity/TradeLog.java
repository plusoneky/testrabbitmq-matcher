package com.gxzx.testrabbitmq.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 交易日志表
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
public class TradeLog extends Model<TradeLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员id
     */
    private Integer userId;

    private Integer peerId;

    /**
     * 成交委托ID
     */
    private Integer userTradeId;

    /**
     * 被成交委托ID
     */
    private Integer peerTradeId;

    /**
     * 币种名称，与market表的name一致
     */
    private String market;

    /**
     * 市场ID
     */
    private Integer marketId;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal num;

    /**
     * 总额
     */
    private BigDecimal mum;

    /**
     * 买入手续费
     */
    private BigDecimal feeBuy;

    /**
     * 卖出手续费
     */
    private BigDecimal feeSell;

    /**
     * 类型，1：买入。2：卖出
     */
    private Integer type;

    private Integer sort;

    /**
     * 状态 ：0禁用、1启用
     */
    private Integer status;

    /**
     * 是否刷单(1:正常交易 2:机器人交易)
     */
    private Boolean isAutomatic;

    /**
     * 市场类型(1:普通交易市场 2:C2C交易市场)
     */
    private Boolean marketType;

    private Integer automaticId;

    /**
     * 是否显示：(1:显示 2:不显示)
     */
    private Boolean showTrade;

    /**
     * 买流水号
     */
    private String buyOrderNo;

    /**
     * 卖流水号
     */
    private String sellOrderNo;

    /**
     * 创建时间
     */
    private Date gmtCreatedTime;

    /**
     * 更新时间
     */
    private Date gmtUpdatedTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    public Integer getUserTradeId() {
        return userTradeId;
    }

    public void setUserTradeId(Integer userTradeId) {
        this.userTradeId = userTradeId;
    }

    public Integer getPeerTradeId() {
        return peerTradeId;
    }

    public void setPeerTradeId(Integer peerTradeId) {
        this.peerTradeId = peerTradeId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getMum() {
        return mum;
    }

    public void setMum(BigDecimal mum) {
        this.mum = mum;
    }

    public BigDecimal getFeeBuy() {
        return feeBuy;
    }

    public void setFeeBuy(BigDecimal feeBuy) {
        this.feeBuy = feeBuy;
    }

    public BigDecimal getFeeSell() {
        return feeSell;
    }

    public void setFeeSell(BigDecimal feeSell) {
        this.feeSell = feeSell;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(Boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public Boolean getMarketType() {
        return marketType;
    }

    public void setMarketType(Boolean marketType) {
        this.marketType = marketType;
    }

    public Integer getAutomaticId() {
        return automaticId;
    }

    public void setAutomaticId(Integer automaticId) {
        this.automaticId = automaticId;
    }

    public Boolean getShowTrade() {
        return showTrade;
    }

    public void setShowTrade(Boolean showTrade) {
        this.showTrade = showTrade;
    }

    public String getBuyOrderNo() {
        return buyOrderNo;
    }

    public void setBuyOrderNo(String buyOrderNo) {
        this.buyOrderNo = buyOrderNo;
    }

    public String getSellOrderNo() {
        return sellOrderNo;
    }

    public void setSellOrderNo(String sellOrderNo) {
        this.sellOrderNo = sellOrderNo;
    }

    public Date getGmtCreatedTime() {
        return gmtCreatedTime;
    }

    public void setGmtCreatedTime(Date gmtCreatedTime) {
        this.gmtCreatedTime = gmtCreatedTime;
    }

    public Date getGmtUpdatedTime() {
        return gmtUpdatedTime;
    }

    public void setGmtUpdatedTime(Date gmtUpdatedTime) {
        this.gmtUpdatedTime = gmtUpdatedTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TradeLog{" +
        "id=" + id +
        ", userId=" + userId +
        ", peerId=" + peerId +
        ", userTradeId=" + userTradeId +
        ", peerTradeId=" + peerTradeId +
        ", market=" + market +
        ", marketId=" + marketId +
        ", price=" + price +
        ", num=" + num +
        ", mum=" + mum +
        ", feeBuy=" + feeBuy +
        ", feeSell=" + feeSell +
        ", type=" + type +
        ", sort=" + sort +
        ", status=" + status +
        ", isAutomatic=" + isAutomatic +
        ", marketType=" + marketType +
        ", automaticId=" + automaticId +
        ", showTrade=" + showTrade +
        ", buyOrderNo=" + buyOrderNo +
        ", sellOrderNo=" + sellOrderNo +
        ", gmtCreatedTime=" + gmtCreatedTime +
        ", gmtUpdatedTime=" + gmtUpdatedTime +
        "}";
    }
}
