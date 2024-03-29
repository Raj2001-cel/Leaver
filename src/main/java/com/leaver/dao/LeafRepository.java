package com.leaver.dao;


import com.leaver.model.Leaf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LeafRepository extends JpaRepository<Leaf, Long> {
    ArrayList<Leaf> findAllLeafByReportId(Long reportId);
}
