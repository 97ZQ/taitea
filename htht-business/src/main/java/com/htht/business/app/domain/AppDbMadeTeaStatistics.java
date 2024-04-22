package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 我的茶厂-成品茶统计
 * @TableName app_db_made_tea_statistics
 */
@TableName(value ="app_db_made_tea_statistics")
@Data
public class AppDbMadeTeaStatistics implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 一级绿茶
     */
    private Integer greenTeaFirstLevel;

    /**
     * 二级绿茶
     */
    private Integer greenTeaSecondLevel;

    /**
     * 一级红茶
     */
    private Integer redTeaFirstLevel;

    /**
     * 二级红茶
     */
    private Integer redTeaSecondLevel;

    /**
     * 成品茶统计日期
     */
    private Date finishedTeaStatisticsDate;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 一级绿毛茶用量
     */
    private Double firstLevelGreenRawTea;

    /**
     * 二级绿毛茶用量
     */
    private Double secondLevelGreenRawTea;

    /**
     * 一级红毛茶用量
     */
    private Double firstLevelRedRawTea;

    /**
     * 二级红毛茶用量
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
        AppDbMadeTeaStatistics other = (AppDbMadeTeaStatistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGreenTeaFirstLevel() == null ? other.getGreenTeaFirstLevel() == null : this.getGreenTeaFirstLevel().equals(other.getGreenTeaFirstLevel()))
            && (this.getGreenTeaSecondLevel() == null ? other.getGreenTeaSecondLevel() == null : this.getGreenTeaSecondLevel().equals(other.getGreenTeaSecondLevel()))
            && (this.getRedTeaFirstLevel() == null ? other.getRedTeaFirstLevel() == null : this.getRedTeaFirstLevel().equals(other.getRedTeaFirstLevel()))
            && (this.getRedTeaSecondLevel() == null ? other.getRedTeaSecondLevel() == null : this.getRedTeaSecondLevel().equals(other.getRedTeaSecondLevel()))
            && (this.getFinishedTeaStatisticsDate() == null ? other.getFinishedTeaStatisticsDate() == null : this.getFinishedTeaStatisticsDate().equals(other.getFinishedTeaStatisticsDate()))
            && (this.getTeaFactoryId() == null ? other.getTeaFactoryId() == null : this.getTeaFactoryId().equals(other.getTeaFactoryId()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGreenTeaFirstLevel() == null) ? 0 : getGreenTeaFirstLevel().hashCode());
        result = prime * result + ((getGreenTeaSecondLevel() == null) ? 0 : getGreenTeaSecondLevel().hashCode());
        result = prime * result + ((getRedTeaFirstLevel() == null) ? 0 : getRedTeaFirstLevel().hashCode());
        result = prime * result + ((getRedTeaSecondLevel() == null) ? 0 : getRedTeaSecondLevel().hashCode());
        result = prime * result + ((getFinishedTeaStatisticsDate() == null) ? 0 : getFinishedTeaStatisticsDate().hashCode());
        result = prime * result + ((getTeaFactoryId() == null) ? 0 : getTeaFactoryId().hashCode());
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
        sb.append(", greenTeaFirstLevel=").append(greenTeaFirstLevel);
        sb.append(", greenTeaSecondLevel=").append(greenTeaSecondLevel);
        sb.append(", redTeaFirstLevel=").append(redTeaFirstLevel);
        sb.append(", redTeaSecondLevel=").append(redTeaSecondLevel);
        sb.append(", finishedTeaStatisticsDate=").append(finishedTeaStatisticsDate);
        sb.append(", teaFactoryId=").append(teaFactoryId);
        sb.append(", teaId=").append(teaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
