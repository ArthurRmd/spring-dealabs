package com.example.dealabs.database.dao;

import com.example.dealabs.database.repository.DealDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface DealDAO extends JpaRepository<DealDO,Integer> {


}




