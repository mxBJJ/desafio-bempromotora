package com.maxmendes.DesafioBemPromotora.resource;

import com.maxmendes.DesafioBemPromotora.domain.Research;
import com.maxmendes.DesafioBemPromotora.service.ResearchesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api("Endpoint de pesquisas criadas.")
@RestController
@RequestMapping(value = "api/pesquisas")
public class ResearchesResource {

    @Autowired
    private ResearchesService researchesService;

    @ApiOperation("Retorna todas as pesquisas.")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Research>> getAllResearches(){
        List<Research> researchList = researchesService.getAllResearches();

        return ResponseEntity.ok().body(researchList);
    }


    @ApiOperation("Retorna todas as pesquisas utilizando paginacao atraves da passagem do parametro page.")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Research>> getResearches(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Research> researchesPage = researchesService.findPage(page, linesPerPage, orderBy, direction);

        return ResponseEntity.ok().body(researchesPage);
    }

    @ApiOperation("Retorna uma pesquisa especifica por id.")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Research> getResearchById(@PathVariable Integer id){
        Research research = researchesService.findResearchesById(id);

        return ResponseEntity.ok().body(research);
    }


    @ApiOperation("Insere uma nova pesquisa no banco de dados.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertResearch(@RequestBody Research newResearch){

        Research research = researchesService.insertNewResearch(newResearch);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(research.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation("Deleta uma pesquisa do banco de dados.")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteResearch(@PathVariable Integer id){

        researchesService.deleteResearch(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Atualiza uma pesquisa no banco de dados.")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateResearch(
            @PathVariable Integer id,
            @RequestBody Research research){

        research.setId(id);
        researchesService.updateResearch(research);

        return ResponseEntity.noContent().build();
    }

}
