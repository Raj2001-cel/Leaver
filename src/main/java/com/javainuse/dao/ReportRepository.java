package com.javainuse.dao;

import com.javainuse.model.Leaf;
import com.javainuse.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
