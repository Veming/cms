package com.example.cms.dao;

import com.example.cms.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordDAO extends JpaRepository<Record,Integer> {
}
