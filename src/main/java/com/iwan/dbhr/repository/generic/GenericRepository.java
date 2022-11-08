package com.iwan.dbhr.repository.generic;

import com.iwan.dbhr.model.generic.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
