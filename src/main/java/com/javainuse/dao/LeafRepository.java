package com.javainuse.dao;

import com.javainuse.model.ImageModel;
import com.javainuse.model.Leaf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeafRepository extends JpaRepository<Leaf, Long> {
}