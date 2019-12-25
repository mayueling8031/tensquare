package com.tensquare.dao;

import com.tensquare.pojo.City;
import com.tensquare.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityDao extends JpaRepository<City,String> , JpaSpecificationExecutor<City> {
}
