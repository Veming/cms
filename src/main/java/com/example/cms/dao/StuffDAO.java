package com.example.cms.dao;

import com.example.cms.domain.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StuffDAO extends JpaRepository<Stuff,Integer> {

    @Query(value = "select t from Stuff t where t.username = ?1 and t.password = ?2")
    Stuff stuffLogin(String username, String password);
}
