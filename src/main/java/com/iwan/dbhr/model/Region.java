package com.iwan.dbhr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.iwan.dbhr.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Region extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Region(Long id) {
        super(id);
    }

    public Region(Long id, String name, List<Country> countries) {
        super(id);
        this.name = name;
        this.countries = countries;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> countries;
}
