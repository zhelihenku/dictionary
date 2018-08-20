package com.zhelihenku.dictionary.modular.dictionary.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 歇后语表
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-20
 */
@TableName("tb_xinhua_xiehouyu")
public class Xiehouyu extends Model<Xiehouyu> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 答案
     */
    private String answer;
    /**
     * 谜语
     */
    private String riddle;
    /**
     * 描述
     */
    private String desc;
    /**
     * 状态（0：下架，1：上架）
     */
    private Integer status;
    /**
     * 删除标识（0：未删除，1：已删除）
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Xiehouyu{" +
        "id=" + id +
        ", answer=" + answer +
        ", riddle=" + riddle +
        ", desc=" + desc +
        ", status=" + status +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
