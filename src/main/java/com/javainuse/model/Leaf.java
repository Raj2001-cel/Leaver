package com.javainuse.model;


import javax.persistence.*;

@Entity
@Table(name = "Leaves")
public class Leaf {
    public Leaf(){

    }
    @Id
    @Column(name = "leafId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long leafId;


    @Column(name = "unhealthy")
    private boolean unhealthy;

    @Column(name = "name")
    private String name;

    @Column(name = "reportId")
    private Long reportId;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "imageBytes")
    private byte[] imageBytes;

    public Leaf(long leafId, boolean unhealthy, String name, Long reportId, String imageName, byte[] imageBytes) {
        this.leafId = leafId;
        this.unhealthy = unhealthy;
        this.name = name;
        this.reportId = reportId;
        this.imageName = imageName;
        this.imageBytes = imageBytes;
    }




    public boolean isUnhealthy() {
        return unhealthy;
    }

    public void setUnhealthy(boolean unhealthy) {
        this.unhealthy = unhealthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName() {
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.imageName = ""+number+"-"+this.getName();
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
