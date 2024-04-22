package com.htht.business.app.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 茶企服务-活动信息
 * @TableName app_db_notice_event
 */
@Data
public class AppDbNoticeEvent implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 活动公告
     */
    private String noticeContent;

    /**
     * 活动标题
     */
    private String noticeTitle;

    /**
     * 活动日期
     */
    private Date noticeDate;

    /**
     * 活动类型
     */
    private String type;

    /**
     * 发布单位
     */
    private String noticeUnit;

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 活动公告
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 活动公告
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * 活动标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 活动标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 活动日期
     */
    public Date getNoticeDate() {
        return noticeDate;
    }

    /**
     * 活动日期
     */
    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    /**
     * 活动类型
     */
    public String getType() {
        return type;
    }

    /**
     * 活动类型
     */
    public void setType(String type) {
        this.type = type;
    }

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
        AppDbNoticeEvent other = (AppDbNoticeEvent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNoticeContent() == null ? other.getNoticeContent() == null : this.getNoticeContent().equals(other.getNoticeContent()))
            && (this.getNoticeTitle() == null ? other.getNoticeTitle() == null : this.getNoticeTitle().equals(other.getNoticeTitle()))
            && (this.getNoticeDate() == null ? other.getNoticeDate() == null : this.getNoticeDate().equals(other.getNoticeDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNoticeContent() == null) ? 0 : getNoticeContent().hashCode());
        result = prime * result + ((getNoticeTitle() == null) ? 0 : getNoticeTitle().hashCode());
        result = prime * result + ((getNoticeDate() == null) ? 0 : getNoticeDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeDate=").append(noticeDate);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
