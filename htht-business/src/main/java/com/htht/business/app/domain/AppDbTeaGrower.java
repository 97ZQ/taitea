package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 农事管理-我的茶园-茶农列表
 * @TableName app_db_tea_grower
 */
@TableName(value ="app_db_tea_grower")
@Data
public class AppDbTeaGrower implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶农姓名
     */
    private String teaGrowerName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系方式
     */
    private String phoneNum;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶农编号
     */
    private Long teaFarmerNumber;

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
        AppDbTeaGrower other = (AppDbTeaGrower) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaGrowerName() == null ? other.getTeaGrowerName() == null : this.getTeaGrowerName().equals(other.getTeaGrowerName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaGrowerName() == null) ? 0 : getTeaGrowerName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getTeaId() == null) ? 0 : getTeaId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaGrowerName=").append(teaGrowerName);
        sb.append(", idCard=").append(idCard);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", teaId=").append(teaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
