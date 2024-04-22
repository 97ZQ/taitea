package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 毛茶统计
 * @TableName app_db_raw_tea_statistics
 */
@TableName(value ="app_db_raw_tea_statistics")
@Data
public class AppDbRawTeaStatistics implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 一级绿毛茶(总)
     */
    private Double firstLevelGreenRawTea;

    /**
     * 一级红毛茶(总)
     */
    private Double firstLevelRedRawTea;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

    /**
     * 二级绿毛茶(总)
     */
    private Double secondLevelGreenRawTea;

    /**
     * 二级红毛茶(总)
     */
    private Double secondLevelRedRawTea;

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
        AppDbRawTeaStatistics other = (AppDbRawTeaStatistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirstLevelGreenRawTea() == null ? other.getFirstLevelGreenRawTea() == null : this.getFirstLevelGreenRawTea().equals(other.getFirstLevelGreenRawTea()))
            && (this.getFirstLevelRedRawTea() == null ? other.getFirstLevelRedRawTea() == null : this.getFirstLevelRedRawTea().equals(other.getFirstLevelRedRawTea()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()))
            && (this.getTeaFactoryId() == null ? other.getTeaFactoryId() == null : this.getTeaFactoryId().equals(other.getTeaFactoryId()))
            && (this.getSecondLevelGreenRawTea() == null ? other.getSecondLevelGreenRawTea() == null : this.getSecondLevelGreenRawTea().equals(other.getSecondLevelGreenRawTea()))
            && (this.getSecondLevelRedRawTea() == null ? other.getSecondLevelRedRawTea() == null : this.getSecondLevelRedRawTea().equals(other.getSecondLevelRedRawTea()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirstLevelGreenRawTea() == null) ? 0 : getFirstLevelGreenRawTea().hashCode());
        result = prime * result + ((getFirstLevelRedRawTea() == null) ? 0 : getFirstLevelRedRawTea().hashCode());
        result = prime * result + ((getTeaId() == null) ? 0 : getTeaId().hashCode());
        result = prime * result + ((getTeaFactoryId() == null) ? 0 : getTeaFactoryId().hashCode());
        result = prime * result + ((getSecondLevelGreenRawTea() == null) ? 0 : getSecondLevelGreenRawTea().hashCode());
        result = prime * result + ((getSecondLevelRedRawTea() == null) ? 0 : getSecondLevelRedRawTea().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", firstLevelGreenRawTea=").append(firstLevelGreenRawTea);
        sb.append(", firstLevelRedRawTea=").append(firstLevelRedRawTea);
        sb.append(", teaId=").append(teaId);
        sb.append(", teaFactoryId=").append(teaFactoryId);
        sb.append(", secondLevelGreenRawTea=").append(secondLevelGreenRawTea);
        sb.append(", secondLevelRedRawTea=").append(secondLevelRedRawTea);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
