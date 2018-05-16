package com.example.cms.dao;
/*
添加语句 参数 1 2
 */
import com.example.cms.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//JpaRepository类里有很多方法 添加查询
public interface AdministratorDAO extends JpaRepository<Administrator,Integer> {
    @Query(value = "select t from Administrator t where aUsername = ?1 and aPassword = ?2")
    Administrator administrator(String s, String s1);
}
