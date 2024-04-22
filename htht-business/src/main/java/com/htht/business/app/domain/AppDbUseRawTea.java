package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 毛茶使用量
 * @TableName app_db_use_raw_tea
 */
@TableName(value ="app_db_use_raw_tea")
@Data
public class AppDbUseRawTea implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 一级绿毛茶使用量
     */
    private Double useFirstLevelGreenRawTea;

    /**
     * 二级绿毛茶使用量
     */
    private Double useSecondLevelGreenRawTea;

    /**
     * 一级红毛茶使用量
     */
    private Double useFirstLevelRedRawTea;

    /**
     * 二级红毛茶使用量
     */
    private Double useSecondLevelRedRawTea;

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
        AppDbUseRawTea other = (AppDbUseRawTea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUseFirstLevelGreenRawTea() == null ? other.getUseFirstLevelGreenRawTea() == null : this.getUseFirstLevelGreenRawTea().equals(other.getUseFirstLevelGreenRawTea()))
            && (this.getUseSecondLevelGreenRawTea() == null ? other.getUseSecondLevelGreenRawTea() == null : this.getUseSecondLevelGreenRawTea().equals(other.getUseSecondLevelGreenRawTea()))
            && (this.getUseFirstLevelRedRawTea() == null ? other.getUseFirstLevelRedRawTea() == null : this.getUseFirstLevelRedRawTea().equals(other.getUseFirstLevelRedRawTea()))
            && (this.getUseSecondLevelRedRawTea() == null ? other.getUseSecondLevelRedRawTea() == null : this.getUseSecondLevelRedRawTea().equals(other.getUseSecondLevelRedRawTea()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()))
            && (this.getTeaFactoryId() == null ? other.getTeaFactoryId() == null : this.getTeaFactoryId().equals(other.getTeaFactoryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUseFirstLevelGreenRawTea() == null) ? 0 : getUseFirstLevelGreenRawTea().hashCode());
        result = prime * result + ((getUseSecondLevelGreenRawTea() == null) ? 0 : getUseSecondLevelGreenRawTea().hashCode());
        result = prime * result + ((getUseFirstLevelRedRawTea() == null) ? 0 : getUseFirstLevelRedRawTea().hashCode());
        result = prime * result + ((getUseSecondLevelRedRawTea() == null) ? 0 : getUseSecondLevelRedRawTea().hashCode());
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
        sb.append(", useFirstLevelGreenRawTea=").append(useFirstLevelGreenRawTea);
        sb.append(", useSecondLevelGreenRawTea=").append(useSecondLevelGreenRawTea);
        sb.append(", useFirstLevelRedRawTea=").append(useFirstLevelRedRawTea);
        sb.append(", useSecondLevelRedRawTea=").append(useSecondLevelRedRawTea);
        sb.append(", useTime=").append(useTime);
        sb.append(", teaId=").append(teaId);
        sb.append(", teaFactoryId=").append(teaFactoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}