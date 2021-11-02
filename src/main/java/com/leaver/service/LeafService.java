package com.leaver.service;

import com.leaver.dao.LeafRepository;
import com.leaver.model.Leaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LeafService {

    @Autowired
    LeafRepository leafRepository;

    public Leaf saveLeaf(Leaf leaf){
      return  leafRepository.save(leaf);
    }

    public ArrayList<Leaf> getAllLeafByReportId(Long reportId){
        return leafRepository.findAllLeafByReportId(reportId);
    }
}
