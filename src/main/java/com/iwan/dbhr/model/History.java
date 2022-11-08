package com.iwan.dbhr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History extends BaseEntity {
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;
    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "job")
    private Job job;

}
