package com.gxzx.testrabbitmq.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 帐号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String truename;

    private String nickname;

    /**
     * 手机号
     */
    private String moble;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 支付密码
     */
    private String paypassword;

    /**
     * 交易验证类型
     */
    private Integer checktype;

    /**
     * 证件类型(1:身份证2:护照)
     */
    private Integer idcardtype;

    /**
     * 用户配置
     */
    private String conf;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 登录次数
     */
    private Integer logins;

    /**
     * ip地址
     */
    private String addip;

    /**
     * 内网IP
     */
    private String addr;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 支付宝
     */
    private String alipay;

    /**
     * 身份证正面
     */
    private String idcardImg1;

    /**
     * 身份证反面
     */
    private String idcardImg2;

    /**
     * 手持身份证
     */
    private String idcardImg3;

    /**
     * 认证结果(0:未实名认证、1:已实名认证 2:正在审核 3:未实名认证(分步注册))
     */
    private Integer cardrz;

    /**
     * 用户头像
     */
    private String headUrl;

    /**
     * 用户类型(1:注册用户 2:机器人)
     */
    private Boolean type;

    /**
     * 状态(1启用、2禁用)
     */
    private Boolean status;

    /**
     * 1
     */
    private Boolean sellerIdent;

    /**
     * 分组A-Z
     */
    private String flag;

    /**
     * google验证器私钥
     */
    private String googleSecret;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 身份认证不通过原因
     */
    private String refuseCause;

    /**
     * 身份认证上传时间
     */
    private Date authTime;

    /**
     * 认证类型：0普通认证；1阿里认证
     */
    private Integer identType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public Integer getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(Integer idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getLogins() {
        return logins;
    }

    public void setLogins(Integer logins) {
        this.logins = logins;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getIdcardImg1() {
        return idcardImg1;
    }

    public void setIdcardImg1(String idcardImg1) {
        this.idcardImg1 = idcardImg1;
    }

    public String getIdcardImg2() {
        return idcardImg2;
    }

    public void setIdcardImg2(String idcardImg2) {
        this.idcardImg2 = idcardImg2;
    }

    public String getIdcardImg3() {
        return idcardImg3;
    }

    public void setIdcardImg3(String idcardImg3) {
        this.idcardImg3 = idcardImg3;
    }

    public Integer getCardrz() {
        return cardrz;
    }

    public void setCardrz(Integer cardrz) {
        this.cardrz = cardrz;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getSellerIdent() {
        return sellerIdent;
    }

    public void setSellerIdent(Boolean sellerIdent) {
        this.sellerIdent = sellerIdent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getGoogleSecret() {
        return googleSecret;
    }

    public void setGoogleSecret(String googleSecret) {
        this.googleSecret = googleSecret;
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

    public String getRefuseCause() {
        return refuseCause;
    }

    public void setRefuseCause(String refuseCause) {
        this.refuseCause = refuseCause;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public Integer getIdentType() {
        return identType;
    }

    public void setIdentType(Integer identType) {
        this.identType = identType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", truename=" + truename +
        ", nickname=" + nickname +
        ", moble=" + moble +
        ", password=" + password +
        ", paypassword=" + paypassword +
        ", checktype=" + checktype +
        ", idcardtype=" + idcardtype +
        ", conf=" + conf +
        ", idcard=" + idcard +
        ", logins=" + logins +
        ", addip=" + addip +
        ", addr=" + addr +
        ", email=" + email +
        ", alipay=" + alipay +
        ", idcardImg1=" + idcardImg1 +
        ", idcardImg2=" + idcardImg2 +
        ", idcardImg3=" + idcardImg3 +
        ", cardrz=" + cardrz +
        ", headUrl=" + headUrl +
        ", type=" + type +
        ", status=" + status +
        ", sellerIdent=" + sellerIdent +
        ", flag=" + flag +
        ", googleSecret=" + googleSecret +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", refuseCause=" + refuseCause +
        ", authTime=" + authTime +
        ", identType=" + identType +
        "}";
    }
}
