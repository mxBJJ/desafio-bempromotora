package com.maxmendes.DesafioBemPromotora.resource;

import com.maxmendes.DesafioBemPromotora.domain.Question;
import com.maxmendes.DesafioBemPromotora.service.QuestionsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/perguntas")
public class QuestionsResource {

    @Autowired
    private QuestionsService questionsService;

    @ApiOperation("Retorna todas as questoes cadastradas.")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questionList = questionsService.getAllQuestions();

        return ResponseEntity.ok().body(questionList);
    }


    @ApiOperation("Retorna todas as questoes de forma paginada, atraves do parametro page.")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Question>> getQuestions(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Question> questionPage = questionsService.findPage(page, linesPerPage, orderBy, direction);

        return ResponseEntity.ok().body(questionPage);
    }

    @ApiOperation("Retorna uma questao por id.")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id){
        Question question = questionsService.findQuestionsById(id);

        return ResponseEntity.ok().body(question);
    }

    @ApiOperation("Insere uma questao no banco de dados.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertQuestion(@RequestBody Question newQuestion){

        Question question = questionsService.insertNewQuestion(newQuestion);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(question.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation("Deleta uma questao do banco de dados atraves do seu id.")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id){

        questionsService.deleteQuestion(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Atualiza uma questao no banco de dados atraves do seu id.")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateQuestion(
            @PathVariable Integer id,
            @RequestBody Question question){

        question.setId(id);
        questionsService.updateQuestion(question);

        return ResponseEntity.noContent().build();
    }
}
