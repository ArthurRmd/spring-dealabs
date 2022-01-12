package com.example.dealabs.database.dao;
import com.example.dealabs.database.repository.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserDO,Integer> {
    UserDO findByFirstName(String author);
}
