package com.example.demo.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.demo.commom.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zengyi
 * @since 2019-08-29
 */
@Data
@TableName("t_base_employee")
public class BaseEmployee {

    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime modifyTime;

    private String modifier;

    private Integer isDelete;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 姓名
     */
    private String employeeName;

    /**
     * 边界
     */
    private String location;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 性别 1-男2-女
     */
    private Integer gender;

    /**
     * 入职时间
     */
    private LocalDate entryTime;

    /**
     * 离职时间
     */
    private LocalDate resignationTime;

    /**
     * 状态 1-启用 2-停用 3-离职
     */
    private Integer employeeStatus;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 座机
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 管理边界
     */
    private String manageLocation;


    @Override
    public String toString() {
        return "BaseEmployee{" +
            "id=" + id +
            ", createTime=" + createTime +
            ", creator=" + creator +
            ", modifyTime=" + modifyTime +
            ", modifier=" + modifier +
            ", isDelete=" + isDelete +
            ", userName=" + userName +
            ", employeeName=" + employeeName +
            ", location=" + location +
            ", passwd=" + passwd +
            ", birthday=" + birthday +
            ", gender=" + gender +
            ", entryTime=" + entryTime +
            ", resignationTime=" + resignationTime +
            ", employeeStatus=" + employeeStatus +
            ", email=" + email +
            ", phone=" + phone +
            ", tel=" + tel +
            ", fax=" + fax +
            ", manageLocation=" + manageLocation +
        "}";
    }
}
