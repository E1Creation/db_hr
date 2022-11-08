package com.iwan.dbhr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country extends BaseEntity {

    @Column(nullable = false, length = 3)
    private String code;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Location> locations;
}
