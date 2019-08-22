package com.gxzx.testrabbitmq.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 币种配置表
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
public class Coin extends Model<Coin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 英文简称
     */
    private String name;

    /**
     * 币种类型(1:人民币, 2:兑换币, 3:比特币, 4:比特币代币, 5:以太坊, 6:以太坊代币)
     */
    private Integer type;

    /**
     * 中文名称
     */
    private String title;

    /**
     * 图标
     */
    private String img;

    private Integer sort;

    /**
     * 挂单比例,%只能挂单当前账户的多少
     */
    private String feeBili;

    /**
     * 
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 状态，1：可用，0：禁止
     */
    private Integer status;

    /**
     * 钱包服务器ip 
     */
    private String walletServerIp;

    /**
     * 钱包服务器端口
     */
    private String walletServerPort;

    /**
     * 钱包服务器用户
     */
    private String walletServerUser;

    /**
     * 钱包服务器密码
     */
    private String walletServerPwd;

    /**
     * 钱包主账号地址(USDT、以太坊、以太坊代币必填)
     */
    private String walletMainAddress;

    /**
     * 钱包主账号密码或加密密码(以太坊、以太坊代币必填，如果比特币、泰达币等钱包进行了加密也必填)
     */
    private String walletMainPassword;

    /**
     * 转入赠送(单位：%)
     */
    private BigDecimal rollInGive;

    /**
     * 转入状态，1：正常转入，2：禁止转入
     */
    private Boolean rollInType;

    /**
     * 确认次数,转入确认次数必须填写,且大于0
     */
    private Integer rollInNum;

    private String rollInSm;

    /**
     * 最小转入数量
     */
    private BigDecimal rollInMin;

    /**
     * 最大转入数量
     */
    private BigDecimal rollInMax;

    private String rollOutSm;

    /**
     * 转出手续费 ,单位%
     */
    private BigDecimal rollOutFee;

    private String rollOutUser;

    /**
     * 最小转出数量
     */
    private BigDecimal rollOutMin;

    /**
     * 最大转出数量
     */
    private BigDecimal rollOutMax;

    private String rollOutJz;

    /**
     * 每天允许自动转出累计数量(为0则不限制,如果超过这个值, 则会转入后台进行审核)
     */
    private BigDecimal rollOutZdNum;

    /**
     * 每天允许自动转出累计数量(为0则不限制)
     */
    private BigDecimal rollOutDayNum;

    /**
     * 转出确认次数
     */
    private Integer rollOutNum;

    /**
     * 转出自动
     */
    private String rollOutZd;

    /**
     * 转出状态，1：正常转出，2：禁止转出
     */
    private Boolean rollOutType;

    /**
     * 英文简称
     */
    private String jsEn;

    /**
     * 详细介绍
     */
    private String jsContent;

    /**
     * 钱包下载
     */
    private String jsWalletDownload;

    /**
     * 源码下载
     */
    private String jsCodeDownload;

    /**
     * 官方链接
     */
    private String jsLink;

    private String jsLt;

    /**
     * 官方挖矿
     */
    private String jsMining;

    /**
     * 研发者
     */
    private String csDevelop;

    /**
     * 核心算法
     */
    private String csAlgorithm;

    /**
     * 发布日期
     */
    private String csReleaseTime;

    /**
     * 区块速度
     */
    private String csBlockSpeed;

    /**
     * 发行总量
     */
    private String csCount;

    /**
     * 存量
     */
    private String csStock;

    /**
     * 证明方式
     */
    private String csProve;

    /**
     * 难度调整
     */
    private String csDifficulty;

    /**
     * 区块奖励
     */
    private String csReward;

    /**
     * 主要特色
     */
    private String csCharacter;

    /**
     * 不足之处
     */
    private String csShort;

    private String tpZs;

    private String tpJs;

    private String tpYy;

    private String tpQj;

    /**
     * 监听节点数
     */
    private Integer blockNumber;

    /**
     * 0、未删除1、已删除
     */
    private Integer isDel;

    /**
     * 实时价格
     */
    private BigDecimal realTimePrice;

    /**
     * 代币token(以太坊代币类型不能为空)
     */
    private String token;

    /**
     * 代币小数位(以太坊代币类型不能为空, 默认18)
     */
    private Integer tokenDecimal;

    /**
     * 平台余额上限报警值
     */
    private Integer balanceUpperLimitAlarm;

    /**
     * 平台余额下限报警值
     */
    private Integer balanceLowerLimitAlarm;

    private String txid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFeeBili() {
        return feeBili;
    }

    public void setFeeBili(String feeBili) {
        this.feeBili = feeBili;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWalletServerIp() {
        return walletServerIp;
    }

    public void setWalletServerIp(String walletServerIp) {
        this.walletServerIp = walletServerIp;
    }

    public String getWalletServerPort() {
        return walletServerPort;
    }

    public void setWalletServerPort(String walletServerPort) {
        this.walletServerPort = walletServerPort;
    }

    public String getWalletServerUser() {
        return walletServerUser;
    }

    public void setWalletServerUser(String walletServerUser) {
        this.walletServerUser = walletServerUser;
    }

    public String getWalletServerPwd() {
        return walletServerPwd;
    }

    public void setWalletServerPwd(String walletServerPwd) {
        this.walletServerPwd = walletServerPwd;
    }

    public String getWalletMainAddress() {
        return walletMainAddress;
    }

    public void setWalletMainAddress(String walletMainAddress) {
        this.walletMainAddress = walletMainAddress;
    }

    public String getWalletMainPassword() {
        return walletMainPassword;
    }

    public void setWalletMainPassword(String walletMainPassword) {
        this.walletMainPassword = walletMainPassword;
    }

    public BigDecimal getRollInGive() {
        return rollInGive;
    }

    public void setRollInGive(BigDecimal rollInGive) {
        this.rollInGive = rollInGive;
    }

    public Boolean getRollInType() {
        return rollInType;
    }

    public void setRollInType(Boolean rollInType) {
        this.rollInType = rollInType;
    }

    public Integer getRollInNum() {
        return rollInNum;
    }

    public void setRollInNum(Integer rollInNum) {
        this.rollInNum = rollInNum;
    }

    public String getRollInSm() {
        return rollInSm;
    }

    public void setRollInSm(String rollInSm) {
        this.rollInSm = rollInSm;
    }

    public BigDecimal getRollInMin() {
        return rollInMin;
    }

    public void setRollInMin(BigDecimal rollInMin) {
        this.rollInMin = rollInMin;
    }

    public BigDecimal getRollInMax() {
        return rollInMax;
    }

    public void setRollInMax(BigDecimal rollInMax) {
        this.rollInMax = rollInMax;
    }

    public String getRollOutSm() {
        return rollOutSm;
    }

    public void setRollOutSm(String rollOutSm) {
        this.rollOutSm = rollOutSm;
    }

    public BigDecimal getRollOutFee() {
        return rollOutFee;
    }

    public void setRollOutFee(BigDecimal rollOutFee) {
        this.rollOutFee = rollOutFee;
    }

    public String getRollOutUser() {
        return rollOutUser;
    }

    public void setRollOutUser(String rollOutUser) {
        this.rollOutUser = rollOutUser;
    }

    public BigDecimal getRollOutMin() {
        return rollOutMin;
    }

    public void setRollOutMin(BigDecimal rollOutMin) {
        this.rollOutMin = rollOutMin;
    }

    public BigDecimal getRollOutMax() {
        return rollOutMax;
    }

    public void setRollOutMax(BigDecimal rollOutMax) {
        this.rollOutMax = rollOutMax;
    }

    public String getRollOutJz() {
        return rollOutJz;
    }

    public void setRollOutJz(String rollOutJz) {
        this.rollOutJz = rollOutJz;
    }

    public BigDecimal getRollOutZdNum() {
        return rollOutZdNum;
    }

    public void setRollOutZdNum(BigDecimal rollOutZdNum) {
        this.rollOutZdNum = rollOutZdNum;
    }

    public BigDecimal getRollOutDayNum() {
        return rollOutDayNum;
    }

    public void setRollOutDayNum(BigDecimal rollOutDayNum) {
        this.rollOutDayNum = rollOutDayNum;
    }

    public Integer getRollOutNum() {
        return rollOutNum;
    }

    public void setRollOutNum(Integer rollOutNum) {
        this.rollOutNum = rollOutNum;
    }

    public String getRollOutZd() {
        return rollOutZd;
    }

    public void setRollOutZd(String rollOutZd) {
        this.rollOutZd = rollOutZd;
    }

    public Boolean getRollOutType() {
        return rollOutType;
    }

    public void setRollOutType(Boolean rollOutType) {
        this.rollOutType = rollOutType;
    }

    public String getJsEn() {
        return jsEn;
    }

    public void setJsEn(String jsEn) {
        this.jsEn = jsEn;
    }

    public String getJsContent() {
        return jsContent;
    }

    public void setJsContent(String jsContent) {
        this.jsContent = jsContent;
    }

    public String getJsWalletDownload() {
        return jsWalletDownload;
    }

    public void setJsWalletDownload(String jsWalletDownload) {
        this.jsWalletDownload = jsWalletDownload;
    }

    public String getJsCodeDownload() {
        return jsCodeDownload;
    }

    public void setJsCodeDownload(String jsCodeDownload) {
        this.jsCodeDownload = jsCodeDownload;
    }

    public String getJsLink() {
        return jsLink;
    }

    public void setJsLink(String jsLink) {
        this.jsLink = jsLink;
    }

    public String getJsLt() {
        return jsLt;
    }

    public void setJsLt(String jsLt) {
        this.jsLt = jsLt;
    }

    public String getJsMining() {
        return jsMining;
    }

    public void setJsMining(String jsMining) {
        this.jsMining = jsMining;
    }

    public String getCsDevelop() {
        return csDevelop;
    }

    public void setCsDevelop(String csDevelop) {
        this.csDevelop = csDevelop;
    }

    public String getCsAlgorithm() {
        return csAlgorithm;
    }

    public void setCsAlgorithm(String csAlgorithm) {
        this.csAlgorithm = csAlgorithm;
    }

    public String getCsReleaseTime() {
        return csReleaseTime;
    }

    public void setCsReleaseTime(String csReleaseTime) {
        this.csReleaseTime = csReleaseTime;
    }

    public String getCsBlockSpeed() {
        return csBlockSpeed;
    }

    public void setCsBlockSpeed(String csBlockSpeed) {
        this.csBlockSpeed = csBlockSpeed;
    }

    public String getCsCount() {
        return csCount;
    }

    public void setCsCount(String csCount) {
        this.csCount = csCount;
    }

    public String getCsStock() {
        return csStock;
    }

    public void setCsStock(String csStock) {
        this.csStock = csStock;
    }

    public String getCsProve() {
        return csProve;
    }

    public void setCsProve(String csProve) {
        this.csProve = csProve;
    }

    public String getCsDifficulty() {
        return csDifficulty;
    }

    public void setCsDifficulty(String csDifficulty) {
        this.csDifficulty = csDifficulty;
    }

    public String getCsReward() {
        return csReward;
    }

    public void setCsReward(String csReward) {
        this.csReward = csReward;
    }

    public String getCsCharacter() {
        return csCharacter;
    }

    public void setCsCharacter(String csCharacter) {
        this.csCharacter = csCharacter;
    }

    public String getCsShort() {
        return csShort;
    }

    public void setCsShort(String csShort) {
        this.csShort = csShort;
    }

    public String getTpZs() {
        return tpZs;
    }

    public void setTpZs(String tpZs) {
        this.tpZs = tpZs;
    }

    public String getTpJs() {
        return tpJs;
    }

    public void setTpJs(String tpJs) {
        this.tpJs = tpJs;
    }

    public String getTpYy() {
        return tpYy;
    }

    public void setTpYy(String tpYy) {
        this.tpYy = tpYy;
    }

    public String getTpQj() {
        return tpQj;
    }

    public void setTpQj(String tpQj) {
        this.tpQj = tpQj;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public BigDecimal getRealTimePrice() {
        return realTimePrice;
    }

    public void setRealTimePrice(BigDecimal realTimePrice) {
        this.realTimePrice = realTimePrice;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTokenDecimal() {
        return tokenDecimal;
    }

    public void setTokenDecimal(Integer tokenDecimal) {
        this.tokenDecimal = tokenDecimal;
    }

    public Integer getBalanceUpperLimitAlarm() {
        return balanceUpperLimitAlarm;
    }

    public void setBalanceUpperLimitAlarm(Integer balanceUpperLimitAlarm) {
        this.balanceUpperLimitAlarm = balanceUpperLimitAlarm;
    }

    public Integer getBalanceLowerLimitAlarm() {
        return balanceLowerLimitAlarm;
    }

    public void setBalanceLowerLimitAlarm(Integer balanceLowerLimitAlarm) {
        this.balanceLowerLimitAlarm = balanceLowerLimitAlarm;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Coin{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", title=" + title +
        ", img=" + img +
        ", sort=" + sort +
        ", feeBili=" + feeBili +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", status=" + status +
        ", walletServerIp=" + walletServerIp +
        ", walletServerPort=" + walletServerPort +
        ", walletServerUser=" + walletServerUser +
        ", walletServerPwd=" + walletServerPwd +
        ", walletMainAddress=" + walletMainAddress +
        ", walletMainPassword=" + walletMainPassword +
        ", rollInGive=" + rollInGive +
        ", rollInType=" + rollInType +
        ", rollInNum=" + rollInNum +
        ", rollInSm=" + rollInSm +
        ", rollInMin=" + rollInMin +
        ", rollInMax=" + rollInMax +
        ", rollOutSm=" + rollOutSm +
        ", rollOutFee=" + rollOutFee +
        ", rollOutUser=" + rollOutUser +
        ", rollOutMin=" + rollOutMin +
        ", rollOutMax=" + rollOutMax +
        ", rollOutJz=" + rollOutJz +
        ", rollOutZdNum=" + rollOutZdNum +
        ", rollOutDayNum=" + rollOutDayNum +
        ", rollOutNum=" + rollOutNum +
        ", rollOutZd=" + rollOutZd +
        ", rollOutType=" + rollOutType +
        ", jsEn=" + jsEn +
        ", jsContent=" + jsContent +
        ", jsWalletDownload=" + jsWalletDownload +
        ", jsCodeDownload=" + jsCodeDownload +
        ", jsLink=" + jsLink +
        ", jsLt=" + jsLt +
        ", jsMining=" + jsMining +
        ", csDevelop=" + csDevelop +
        ", csAlgorithm=" + csAlgorithm +
        ", csReleaseTime=" + csReleaseTime +
        ", csBlockSpeed=" + csBlockSpeed +
        ", csCount=" + csCount +
        ", csStock=" + csStock +
        ", csProve=" + csProve +
        ", csDifficulty=" + csDifficulty +
        ", csReward=" + csReward +
        ", csCharacter=" + csCharacter +
        ", csShort=" + csShort +
        ", tpZs=" + tpZs +
        ", tpJs=" + tpJs +
        ", tpYy=" + tpYy +
        ", tpQj=" + tpQj +
        ", blockNumber=" + blockNumber +
        ", isDel=" + isDel +
        ", realTimePrice=" + realTimePrice +
        ", token=" + token +
        ", tokenDecimal=" + tokenDecimal +
        ", balanceUpperLimitAlarm=" + balanceUpperLimitAlarm +
        ", balanceLowerLimitAlarm=" + balanceLowerLimitAlarm +
        ", txid=" + txid +
        "}";
    }
}
