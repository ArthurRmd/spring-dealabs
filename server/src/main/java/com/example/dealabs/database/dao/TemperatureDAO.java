package com.example.dealabs.database.dao;

import com.example.dealabs.database.repository.TemperatureDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureDAO extends JpaRepository<TemperatureDO,Integer> {


}
