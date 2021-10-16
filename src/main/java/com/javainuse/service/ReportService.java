package com.javainuse.service;

import com.javainuse.dao.ReportDao;
import com.javainuse.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportDao reportDao;

    public Report save(Report report) {
    return reportDao.save(report);

    }

    public List<Report> getAllReports(){
        return reportDao.findAll();
    }
}
