package com.why.first.mansb.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "category"
)
public class CategoryDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "categoryUuid")
    @GenericGenerator(name="categoryUuid", strategy = "uuid")
    @Column(name = "uuid", length = 32)
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "parent_uuid")
    private String parentUuid;

    @Column(name = "level", columnDefinition="int default 0", nullable=false)
    private Integer level;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
