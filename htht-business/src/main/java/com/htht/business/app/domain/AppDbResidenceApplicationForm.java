package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 入驻申请表
 * @TableName app_db_residence_application_form
 */
@TableName(value ="app_db_residence_application_form")
@Data
public class AppDbResidenceApplicationForm implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 企业类型(1：茶叶种植 2：茶叶加工 3：茶叶销售 4：茶叶相关)
     */
    private String enterpriseType;

    /**
     * 负责人
     */
    private String chargePerson;

    /**
     * 联系方式
     */
    private String contactInfomation;

    /**
     * 0：未申请 1：通过申请 2：申请中 3：未通过申请
     */
    private Integer status;

    /**
     * 负责人id
     */
    private Long chargePersonId;

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
        AppDbResidenceApplicationForm other = (AppDbResidenceApplicationForm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getEnterpriseType() == null ? other.getEnterpriseType() == null : this.getEnterpriseType().equals(other.getEnterpriseType()))
            && (this.getChargePerson() == null ? other.getChargePerson() == null : this.getChargePerson().equals(other.getChargePerson()))
            && (this.getContactInfomation() == null ? other.getContactInfomation() == null : this.getContactInfomation().equals(other.getContactInfomation()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getEnterpriseType() == null) ? 0 : getEnterpriseType().hashCode());
        result = prime * result + ((getChargePerson() == null) ? 0 : getChargePerson().hashCode());
        result = prime * result + ((getContactInfomation() == null) ? 0 : getContactInfomation().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", enterpriseType=").append(enterpriseType);
        sb.append(", chargePerson=").append(chargePerson);
        sb.append(", contactInfomation=").append(contactInfomation);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
