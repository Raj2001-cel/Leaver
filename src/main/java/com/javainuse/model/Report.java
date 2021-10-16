package com.javainuse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
    public Report(){}

    public Report(Long reportId, String senderName, String receiverName, Long totalLeaves, Long date, Long noOfUnhealthyLeaves, Long noOfHealthyLeaves) {
        this.reportId = reportId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.totalLeaves = totalLeaves;
        this.date = date;
        this.noOfUnhealthyLeaves = noOfUnhealthyLeaves;
        this.noOfHealthyLeaves = noOfHealthyLeaves;
    }

    @Id
    @Column(name="reportId")
    private Long reportId;

    @Column(name="senderName")
    private String senderName;

    @Column(name = "receiverName")
    private String receiverName;

    @Column(name="totalLeaves")
    private Long totalLeaves;

    @Column(name = "date")
    private Long date;

    @Column(name="noOfUnhealthyLeaves")
    private Long noOfUnhealthyLeaves;

    @Column(name = "noOfHealthyLeaves")
    private Long noOfHealthyLeaves;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Long getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(Long totalLeaves) {
        this.totalLeaves = totalLeaves;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getNoOfUnhealthyLeaves() {
        return noOfUnhealthyLeaves;
    }

    public void setNoOfUnhealthyLeaves(Long noOfUnhealthyLeaves) {
        this.noOfUnhealthyLeaves = noOfUnhealthyLeaves;
    }

    public Long getNoOfHealthyLeaves() {
        return noOfHealthyLeaves;
    }

    public void setNoOfHealthyLeaves(Long noOfHealthyLeaves) {
        this.noOfHealthyLeaves = noOfHealthyLeaves;
    }
}
