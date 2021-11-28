package com.example.dealabs.controllers;

import com.example.dealabs.dto.DealDTO;
import com.example.dealabs.dto.DetailDealDTO;
import com.example.dealabs.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DealController {

    private static final String baseUrl = "/deal";

    @Autowired
    private DealService dealService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(method = RequestMethod.GET, value = DealController.baseUrl)
    public List<DealDTO> getAll(){
        List<DealDTO>  dealsDTO = dealService.getDealDTO();
        return dealsDTO;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(method = RequestMethod.GET, value = DealController.baseUrl + "/{id}")
    public DetailDealDTO getById(@PathVariable int id){
        try {
            DetailDealDTO dealsDTO = dealService.getDetailDealDTO(id);
            return dealsDTO;
        } catch (IllegalStateException illegalStateException){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(method = RequestMethod.POST, value = DealController.baseUrl)
    public ResponseEntity<Object> store(@RequestBody DetailDealDTO detailDealDTO){

        try {
            dealService.addDeal(detailDealDTO);
        } catch (Exception exception){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(201).build();
    }



}
