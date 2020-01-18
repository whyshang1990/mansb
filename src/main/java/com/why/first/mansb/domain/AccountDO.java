package com.why.first.mansb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name="account",
        indexes = {
                @Index(name="index_account_category", columnList = "category_uuid")
        }
)
public class AccountDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name="cost")
    private Double cost;
    @ManyToOne
    @JoinColumn(name="category_uuid")
    private CategoryDO categoryDO;
    @Column(name="remarks", length = 255)
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public CategoryDO getCategoryDO() {
        return categoryDO;
    }

    public void setCategoryDO(CategoryDO categoryDO) {
        this.categoryDO = categoryDO;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
