package com.iwan.dbhr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job extends BaseEntity {

    @Column(nullable = false, length = 35)
    private String title;
    @Column(name = "min_salary", nullable = false)
    private Integer minSalary;
    @Column(name = "max_salary", nullable = false)
    private Integer maxSalary;

    @OneToMany(mappedBy = "job")
    private List<History> histories;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;
}
