package com.javainuse.dao;

import com.javainuse.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDao extends JpaRepository<Report,Long> {
}
