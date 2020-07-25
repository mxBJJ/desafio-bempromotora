package com.maxmendes.DesafioBemPromotora.repository;

import com.maxmendes.DesafioBemPromotora.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answer,Integer> {
}
