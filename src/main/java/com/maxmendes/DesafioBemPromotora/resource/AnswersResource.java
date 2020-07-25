package com.maxmendes.DesafioBemPromotora.resource;

import com.maxmendes.DesafioBemPromotora.domain.Answer;
import com.maxmendes.DesafioBemPromotora.service.AnswersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api("Endpoint de respostas dos clientes.")
@RestController
@RequestMapping(value = "api/respostas")
public class AnswersResource {

    @Autowired
     private AnswersService answersService;

    @ApiOperation("Retorna todas as respostas.")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAllQuestions(){
        List<Answer> answerList = answersService.getAllAnswers();

        return ResponseEntity.ok().body(answerList);
    }


    @ApiOperation("Insere uma resposta no banco de dados.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertQuestion(@RequestBody Answer newAnswer){

        Answer answer = answersService.insertNewAnswer(newAnswer);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(answer.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
