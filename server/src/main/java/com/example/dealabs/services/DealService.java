package com.example.dealabs.services;

import com.example.dealabs.database.dao.UserDAO;
import com.example.dealabs.database.repository.DealDO;
import com.example.dealabs.database.dao.DealDAO;
import com.example.dealabs.database.repository.UserDO;
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

    @Autowired
    private UserDAO userDAO;

    private DealDTO map(DealDO dealDO) {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setId(dealDO.getId());
        dealDTO.setTemperature(dealDO.getTemperature());
        dealDTO.setTitle(dealDO.getTitle());
        dealDTO.setAuthor(dealDO.getCreator());
        dealDTO.setShopName(dealDO.getShopName());
        dealDTO.setImageUrl(dealDO.getImgUrl());
        dealDTO.setCreatedAt(dealDO.getDate());
        dealDTO.setDescription(dealDO.getDescription());
        return dealDTO;
    }

    public List<DealDTO> getDealDTO() {

//        return dealDAO
//                .findAll()
//                .stream()
//                .map(DealDTO::new)
//                .collect(Collectors.toList());

        List<DealDO> dealsDO = dealDAO.findAll();
        List<DealDTO> result = new ArrayList<>();

        for(DealDO dealDO: dealsDO){
            DealDTO dealDTO = map(dealDO);
            result.add(dealDTO);
        }

        return result;
    }


    public void addDeal(DetailDealDTO detailDealDTO) throws Exception {


        DealDO dealDO = new DealDO();
        UserDO user = userDAO.findByFirstName(detailDealDTO.author);

        if (user == null){
            throw new Exception("user not found");
        }

        dealDO.setDate(detailDealDTO.createdAt);
        dealDO.setDescription(detailDealDTO.description);
        dealDO.setImgUrl(detailDealDTO.imageUrl);
        dealDO.setPriceNew(detailDealDTO.newPrice);
        dealDO.setPriceOld(detailDealDTO.oldPrice);
        dealDO.setPromoCode(detailDealDTO.promoCode);
        dealDO.setShopLink(detailDealDTO.shopLink);
        dealDO.setShopName(detailDealDTO.shopName);
        dealDO.setTitle(detailDealDTO.title);

        dealDO.setUser(user);
        dealDAO.save(dealDO);
    }

    public DetailDealDTO getDetailDealDTO(int id) {

        var a = dealDAO.findById(id);

        if (a.isPresent()){
            System.out.println("temperature id => " + a.get().getTemperatures().get(0).getId());
            System.out.println("creator id => " + a.get().getUser().getFullName());
        }


        return dealDAO.findById(id)
                .map(DetailDealDTO::new)
                .orElseThrow(() -> new IllegalStateException("id not found"));
    }
}
