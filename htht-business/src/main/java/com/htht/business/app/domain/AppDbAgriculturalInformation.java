package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 农资信息-农资供应商
 * @TableName app_db_agricultural_information
 */
@TableName(value ="app_db_agricultural_information")
@Data
public class AppDbAgriculturalInformation implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 主营
     */
    private String mainBusiness;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * (0 未申请 1 审批通过 2 申请中 3未通过审批)
     */
    private Long status;

    /**
     * 申请人id
     */
    private Long applicantId;

    /**
     * 地区
     */
    private String district;

    /**
     * 申请时间
     */
    private Date applicantTime;

    /**
     * 联系人名称
     */
    private String applicantName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppDbAgriculturalInformation other = (AppDbAgriculturalInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
            && (this.getMainBusiness() == null ? other.getMainBusiness() == null : this.getMainBusiness().equals(other.getMainBusiness()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getApplicantId() == null ? other.getApplicantId() == null : this.getApplicantId().equals(other.getApplicantId()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getMainBusiness() == null) ? 0 : getMainBusiness().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApplicantId() == null) ? 0 : getApplicantId().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", mainBusiness=").append(mainBusiness);
        sb.append(", address=").append(address);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", status=").append(status);
        sb.append(", applicantId=").append(applicantId);
        sb.append(", district=").append(district);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
