package com.example.dealabs.services;

import com.example.dealabs.DealDO;
import com.example.dealabs.dao.DealDAO;
import com.example.dealabs.dto.DealDTO;
import com.example.dealabs.dto.DetailDealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealService {

    @Autowired
    private DealDAO dealDAO;

    public List<DealDTO> getDealDTO() {

        return dealDAO
                .findAll()
                .stream()
                .map(DealDTO::new)
                .collect(Collectors.toList());
    }


    public void addDeal(DealDO dealDO) {
        dealDAO.save(dealDO);
    }

    public DetailDealDTO getDetailDealDTO(int id) {
        return dealDAO.findById(id)
                .map(DetailDealDTO::new)
                .orElseThrow(() -> new IllegalStateException("id not found"));
    }
}
