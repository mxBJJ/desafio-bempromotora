package com.maxmendes.DesafioBemPromotora.repository;

import com.maxmendes.DesafioBemPromotora.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}
