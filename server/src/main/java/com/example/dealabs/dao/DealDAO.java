package com.example.dealabs.dao;

import com.example.dealabs.DealDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
 public interface DealDAO extends JpaRepository<DealDO,Integer> {


}




