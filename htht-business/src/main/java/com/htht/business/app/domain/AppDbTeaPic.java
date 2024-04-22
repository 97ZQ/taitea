package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 茶园图片
 * @TableName app_db_tea_pic
 */
@TableName(value ="app_db_tea_pic")
@Data
public class AppDbTeaPic implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 文件静态地址
     */
    private String fileStaticPath;

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
        AppDbTeaPic other = (AppDbTeaPic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaId() == null ? other.getTeaId() == null : this.getTeaId().equals(other.getTeaId()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))
            && (this.getFileStaticPath() == null ? other.getFileStaticPath() == null : this.getFileStaticPath().equals(other.getFileStaticPath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaId() == null) ? 0 : getTeaId().hashCode());
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        result = prime * result + ((getFileStaticPath() == null) ? 0 : getFileStaticPath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaId=").append(teaId);
        sb.append(", fileId=").append(fileId);
        sb.append(", fileStaticPath=").append(fileStaticPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}