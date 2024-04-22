package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 使用茶青记录表
 * @TableName app_db_use_green_tea
 */
@TableName(value ="app_db_use_green_tea")
@Data
public class AppDbUseGreenTea implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 使用一级茶青
     */
    private Double useFirstLevelGreenTea;

    /**
     * 使用二级茶青
     */
    private Double useSecondLevelGreenTea;

    /**
     * 使用日期
     */
    private Date useTime;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

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
        AppDbUseGreenTea other = (AppDbUseGreenTea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUseFirstLevelGreenTea() == null ? other.getUseFirstLevelGreenTea() == null : this.getUseFirstLevelGreenTea().equals(other.getUseFirstLevelGreenTea()))
            && (this.getUseSecondLevelGreenTea() == null ? other.getUseSecondLevelGreenTea() == null : this.getUseSecondLevelGreenTea().equals(other.getUseSecondLevelGreenTea()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()))
            && (this.getTeaFactoryId() == null ? other.getTeaFactoryId() == null : this.getTeaFactoryId().equals(other.getTeaFactoryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUseFirstLevelGreenTea() == null) ? 0 : getUseFirstLevelGreenTea().hashCode());
        result = prime * result + ((getUseSecondLevelGreenTea() == null) ? 0 : getUseSecondLevelGreenTea().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getTeaId() == null) ? 0 : getTeaId().hashCode());
        result = prime * result + ((getTeaFactoryId() == null) ? 0 : getTeaFactoryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", useFirstLevelGreenTea=").append(useFirstLevelGreenTea);
        sb.append(", useSecondLevelGreenTea=").append(useSecondLevelGreenTea);
        sb.append(", useTime=").append(useTime);
        sb.append(", teaId=").append(teaId);
        sb.append(", teaFactoryId=").append(teaFactoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}