package com.iwan.dbhr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location extends BaseEntity {

    @Column(name = "street_address", length = 50)
    private String streetAddress;
    @Column(name = "postal_code", length = 12, nullable = true)
    private String postalCode;
    @Column(nullable = false, length = 30)
    private String city;
    @Column(nullable = false, length = 30, name = "state_province")
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Department> departments;

}
