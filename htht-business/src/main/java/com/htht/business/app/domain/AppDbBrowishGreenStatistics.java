package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收青统计
 * @TableName app_db_browish_green_statistics
 */
@TableName(value ="app_db_browish_green_statistics")
@Data
public class AppDbBrowishGreenStatistics implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 收青时间
     */
    private Date time;

    /**
     * 一级茶青
     */
    private Double firstLevel;

    /**
     * 二级茶青
     */
    private Double secondLevel;

    /**
     * 茶园id
     */
    private Long teaGardenId;

    /**
     * 一级茶青(总)
     */
    private Double firstLevelAll;

    /**
     * 二级茶青(总)
     */
    private Double secondLevelAll;

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
        AppDbBrowishGreenStatistics other = (AppDbBrowishGreenStatistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getFirstLevel() == null ? other.getFirstLevel() == null : this.getFirstLevel().equals(other.getFirstLevel()))
            && (this.getSecondLevel() == null ? other.getSecondLevel() == null : this.getSecondLevel().equals(other.getSecondLevel()))
            && (this.getTeaGardenId() == null ? other.getTeaGardenId() == null : this.getTeaGardenId().equals(other.getTeaGardenId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getFirstLevel() == null) ? 0 : getFirstLevel().hashCode());
        result = prime * result + ((getSecondLevel() == null) ? 0 : getSecondLevel().hashCode());
        result = prime * result + ((getTeaGardenId() == null) ? 0 : getTeaGardenId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", firstLevel=").append(firstLevel);
        sb.append(", secondLevel=").append(secondLevel);
        sb.append(", teaGardenId=").append(teaGardenId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
