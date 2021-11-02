package com.leaver.service;

import com.leaver.dao.ReportDao;
import com.leaver.model.Report;
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

//    public Report getReportByReportId(Long reportId){
//        return reportDao.findById(reportId).get();
//    }
//
//    public List<Report> getAllReportsByDate(Long date){
//        return reportDao.findAllReportsByDate(date);
//    }
}
