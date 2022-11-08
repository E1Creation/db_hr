package com.iwan.dbhr.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
// @Table(name="tb_employee")
public class Employee extends BaseEntity {
    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;
    private Integer salary;
    @Column(name = "comission_pct", columnDefinition = "FLOAT(8.2) default null")
    private Float comissionPct;

    // id to department manager
    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Department departmentManager;
    // self join
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Employee manager;
    // id ke history
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<History> histories;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    // job to id
    @ManyToOne
    @JoinColumn(name = "job")
    private Job job;

}
