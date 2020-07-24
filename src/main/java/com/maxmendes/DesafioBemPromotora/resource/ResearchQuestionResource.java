package com.maxmendes.DesafioBemPromotora.resource;

import com.maxmendes.DesafioBemPromotora.repository.ResearchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


@RestController
@RequestMapping("api/pergunta-pesquisa")
public class ResearchQuestionResource {

    @Autowired
    public EntityManager em;

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> relation(@RequestParam Integer question_id, @RequestParam Integer research_id ){



        return ResponseEntity.noContent().build();
    }
}
