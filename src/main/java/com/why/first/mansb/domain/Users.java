package com.why.first.mansb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity // 实体类, 必须
// @Table: 对应数据库中的表, 必须, name=表名, Indexes是声明表里的索引, columnList是索引的列, 同时声明此索引列是否唯一, 默认false
@Table(
        name = "user_info",
        indexes = {
                @Index(name="index_user_uuid", columnList = "user_uuid", unique = true)
        }
)
public class Users {
    @Id // 指明ID列
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue： 主键标识，表明是否自动生成, 必须, strategy也是必写, 指明主键生成策略, 默认是Oracle
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_uuid", nullable = false, length = 64)
    private String userUUID;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "certificate", nullable = false, length = 40)
    private String certificate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
