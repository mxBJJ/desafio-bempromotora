package com.maxmendes.DesafioBemPromotora.service;

import com.maxmendes.DesafioBemPromotora.domain.Question;
import com.maxmendes.DesafioBemPromotora.repository.QuestionsRepository;
import com.maxmendes.DesafioBemPromotora.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;


    public Question findQuestionsById(Integer id){
        Optional<Question> question = questionsRepository.findById(id);

        return question.orElseThrow(() -> new ObjectNotFoundException("Question not found."));
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = questionsRepository.findAll();

        return questionList;
    }

    public Question insertNewQuestion(Question question){
        question.setId(null);
        return questionsRepository.save(question);
    }

    public void deleteQuestion(Integer id){
        findQuestionsById(id);

        try{
            questionsRepository.deleteById(id);
        }catch(DataIntegrityViolationException exception){
            throw new DataIntegrityViolationException("Can't delete this questions.");
        }
    }

    public Page<Question> findPage(
            Integer page, Integer linesPerPage,
            String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage,
                Sort.Direction.valueOf(direction),orderBy);

        return questionsRepository.findAll(pageRequest);
    }

    public Question updateQuestion(Question question){
        return questionsRepository.save(question);
    }
}
