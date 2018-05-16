package com.example.cms.dao;

import com.example.cms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {


}
