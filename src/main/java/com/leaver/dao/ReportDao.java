package com.leaver.dao;

import com.leaver.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao extends JpaRepository<Report,Long> {
    List<Report> findAllReportsByDate(Long date);
}
