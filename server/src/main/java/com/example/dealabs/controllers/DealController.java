package com.example.dealabs.controllers;

import com.example.dealabs.DealDO;
import com.example.dealabs.dto.DealDTO;
import com.example.dealabs.dto.DetailDealDTO;
import com.example.dealabs.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DealController {

    private static final String baseUrl = "/deal";

    @Autowired
    private DealService dealService;

    @RequestMapping(method = RequestMethod.GET, value = DealController.baseUrl)
    public List<DealDTO> getAll(){
        List<DealDTO>  dealsDTO = dealService.getDealDTO();
        return dealsDTO;
    }

    @RequestMapping(method = RequestMethod.POST, value = DealController.baseUrl)
    public String store(@RequestBody DealDO dealDO){
        dealService.addDeal(dealDO);
        return "deal added";
    }

    @RequestMapping(method = RequestMethod.GET, value = DealController.baseUrl + "/{id}")
    public DetailDealDTO getById(@PathVariable int id){
        try {
            DetailDealDTO dealsDTO = dealService.getDetailDealDTO(id);
            return dealsDTO;
        } catch (IllegalStateException illegalStateException){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }



}
