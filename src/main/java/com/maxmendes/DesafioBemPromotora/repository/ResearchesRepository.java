package com.maxmendes.DesafioBemPromotora.repository;

import com.maxmendes.DesafioBemPromotora.domain.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchesRepository extends JpaRepository<Research, Integer> {
}
