package com.javainuse.dao;

import com.javainuse.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao extends JpaRepository<Report,Long> {
    List<Report> findAllReportsByDate(Long date);
}
