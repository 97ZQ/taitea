package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收青人员
 * @TableName app_db_browish_green_person
 */
@TableName(value ="app_db_browish_green_person")
@Data
public class AppDbBrowishGreenPerson implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 收青id
     */
    private Long browishGreenStatisticsId;

    /**
     * 收青人员姓名
     */
    private String browishGreenStatisticsName;

    /**
     * 一级茶青(斤)
     */
    private Double browishGreenFirstLevel;

    /**
     * 二级茶青(斤)
     */
    private Double browishGreenSecondLevel;

    /**
     * 收青日期
     */
    private Date browishGreenStatisticsDate;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶农id
     */
    private Long teaFarmerId;

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
        AppDbBrowishGreenPerson other = (AppDbBrowishGreenPerson) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrowishGreenStatisticsId() == null ? other.getBrowishGreenStatisticsId() == null : this.getBrowishGreenStatisticsId().equals(other.getBrowishGreenStatisticsId()))
            && (this.getBrowishGreenStatisticsName() == null ? other.getBrowishGreenStatisticsName() == null : this.getBrowishGreenStatisticsName().equals(other.getBrowishGreenStatisticsName()))
            && (this.getBrowishGreenFirstLevel() == null ? other.getBrowishGreenFirstLevel() == null : this.getBrowishGreenFirstLevel().equals(other.getBrowishGreenFirstLevel()))
            && (this.getBrowishGreenSecondLevel() == null ? other.getBrowishGreenSecondLevel() == null : this.getBrowishGreenSecondLevel().equals(other.getBrowishGreenSecondLevel()))
            && (this.getBrowishGreenStatisticsDate() == null ? other.getBrowishGreenStatisticsDate() == null : this.getBrowishGreenStatisticsDate().equals(other.getBrowishGreenStatisticsDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBrowishGreenStatisticsId() == null) ? 0 : getBrowishGreenStatisticsId().hashCode());
        result = prime * result + ((getBrowishGreenStatisticsName() == null) ? 0 : getBrowishGreenStatisticsName().hashCode());
        result = prime * result + ((getBrowishGreenFirstLevel() == null) ? 0 : getBrowishGreenFirstLevel().hashCode());
        result = prime * result + ((getBrowishGreenSecondLevel() == null) ? 0 : getBrowishGreenSecondLevel().hashCode());
        result = prime * result + ((getBrowishGreenStatisticsDate() == null) ? 0 : getBrowishGreenStatisticsDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", browishGreenStatisticsId=").append(browishGreenStatisticsId);
        sb.append(", browishGreenStatisticsName=").append(browishGreenStatisticsName);
        sb.append(", browishGreenFirstLevel=").append(browishGreenFirstLevel);
        sb.append(", browishGreenSecondLevel=").append(browishGreenSecondLevel);
        sb.append(", browishGreenStatisticsDate=").append(browishGreenStatisticsDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
