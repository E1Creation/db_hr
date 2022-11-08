package com.iwan.dbhr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @OneToOne
    private Employee manager;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<History> histories;
}
