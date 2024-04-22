package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName app_db_all_green_tea_statistics
 */
@TableName(value ="app_db_all_green_tea_statistics")
@Data
public class AppDbAllGreenTeaStatistics implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 总茶青(一级)
     */
    private Double firstLevelGreenTea;

    /**
     * 总茶青(二级)
     */
    private Double secondLevelGreenTea;

    /**
     * 茶园id
     */
    private Long teaId;

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
        AppDbAllGreenTeaStatistics other = (AppDbAllGreenTeaStatistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirstLevelGreenTea() == null ? other.getFirstLevelGreenTea() == null : this.getFirstLevelGreenTea().equals(other.getFirstLevelGreenTea()))
            && (this.getSecondLevelGreenTea() == null ? other.getSecondLevelGreenTea() == null : this.getSecondLevelGreenTea().equals(other.getSecondLevelGreenTea()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirstLevelGreenTea() == null) ? 0 : getFirstLevelGreenTea().hashCode());
        result = prime * result + ((getSecondLevelGreenTea() == null) ? 0 : getSecondLevelGreenTea().hashCode());
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
        sb.append(", firstLevelGreenTea=").append(firstLevelGreenTea);
        sb.append(", secondLevelGreenTea=").append(secondLevelGreenTea);
        sb.append(", teaId=").append(teaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}