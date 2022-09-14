package com.vegmarket.vegmarketbackend.dao;

import com.vegmarket.vegmarketbackend.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface PackRepository extends JpaRepository<Pack,Long> {
}
