package com.example.cms.dao;

import com.example.cms.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDAO extends JpaRepository<Goods, Integer > {
}
