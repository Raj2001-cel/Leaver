package com.javainuse.service;


import com.javainuse.dao.ReportRepository;
import com.javainuse.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public Report saveReport(Report report){
        return reportRepository.save(report);
    }

}
