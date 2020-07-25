package com.maxmendes.DesafioBemPromotora.service;

import com.maxmendes.DesafioBemPromotora.domain.Answer;
import com.maxmendes.DesafioBemPromotora.domain.Question;
import com.maxmendes.DesafioBemPromotora.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    public List<Answer> getAllAnswers(){
        List<Answer> answers = answersRepository.findAll();

        return answers;
    }

    public Answer insertNewAnswer(Answer answer){
        answer.setId(null);
        return answersRepository.save(answer);
    }
}
