package com.maxmendes.DesafioBemPromotora.service;

import com.maxmendes.DesafioBemPromotora.domain.Research;
import com.maxmendes.DesafioBemPromotora.repository.ResearchesRepository;
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
public class ResearchesService {

    @Autowired
    private ResearchesRepository researchesRepository;

    public Research findResearchesById(Integer id){
        Optional<Research> research = researchesRepository.findById(id);

        return research.orElseThrow(() -> new ObjectNotFoundException("Research not found."));
    }

    public List<Research> getAllResearches(){
        List<Research> research = researchesRepository.findAll();

        return research;
    }

    public Research insertNewResearch(Research research){
        research.setId(null);
        return researchesRepository.save(research);
    }

    public void deleteResearch(Integer id){
        findResearchesById(id);

        try{
            researchesRepository.deleteById(id);
        }catch(DataIntegrityViolationException exception){
            throw new DataIntegrityViolationException("Can't delete this researches.");
        }
    }

    public Page<Research> findPage(
            Integer page, Integer linesPerPage,
            String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage,
                Sort.Direction.valueOf(direction),orderBy);

        return researchesRepository.findAll(pageRequest);
    }

    public Research updateResearch(Research research){
        return researchesRepository.save(research);
    }
}
