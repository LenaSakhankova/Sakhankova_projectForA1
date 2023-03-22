package com.unauthorizeddeliveries.mappers;


import com.unauthorizeddeliveries.dtos.PostingDTO;
import com.unauthorizeddeliveries.entities.PostingEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostingMapper {


    public static List<PostingEntity> mapPostingDTOsToPostingEntities(List<PostingDTO> postingDTOList){
        List<PostingEntity> postingEntityList = new ArrayList<>();



        postingDTOList.forEach(postingDTO -> {

            PostingEntity postingEntity = new PostingEntity();
            postingEntity.setMatDoc(Long.parseLong(postingDTO.getMatDoc()));
            postingEntity.setItem(Integer.parseInt(postingDTO.getItem()));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

            try {
                postingEntity.setDocDate(simpleDateFormat.parse(postingDTO.getDocDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            try {
                postingEntity.setPstngDate(simpleDateFormat.parse(postingDTO.getPstngDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            postingEntity.setMaterialDescription(postingDTO.getMaterialDescription());
            postingEntity.setQuantity(Integer.parseInt(postingDTO.getQuantity()));
            if(Integer.parseInt(postingDTO.getQuantity()) < 0 ){
                postingEntity.setQuantity(0);
            }else postingEntity.setQuantity(Integer.parseInt(postingDTO.getQuantity()));


            postingEntity.setBun(postingDTO.getBun());

            if(Double.parseDouble(postingDTO.getAmountLc()) < 0.0){
                postingEntity.setAmountLc(0.0);
            } else postingEntity.setAmountLc(Double.parseDouble(postingDTO.getAmountLc()));

            postingEntity.setCrcy(postingDTO.getCrcy());

            postingEntity.setUserName(postingDTO.getUserName());

            postingEntity.setAuthorizedDelivery(postingDTO.getAuthorizedDelivery());

            postingEntityList.add(postingEntity);


        });

        return postingEntityList;

    }


    public static List<PostingDTO> mapPostingEntitiesToPostingDTOs(List<PostingEntity> postingEntityListList){
        List<PostingDTO> postingDTOList = new ArrayList<>();



        postingEntityListList.forEach(postingEntity -> {

            PostingDTO postingDTO = new PostingDTO();
            postingDTO.setMatDoc(postingEntity.getMatDoc().toString());
            postingDTO.setItem(postingEntity.getItem().toString());
            postingDTO.setDocDate(postingEntity.getDocDate().toString());
            postingDTO.setPstngDate(postingEntity.getPstngDate().toString());
            postingDTO.setMaterialDescription(postingEntity.getMaterialDescription());
            postingDTO.setQuantity(postingEntity.getQuantity().toString());
            postingDTO.setBun(postingEntity.getBun());
            postingDTO.setAmountLc(postingEntity.getAmountLc().toString());
            postingDTO.setCrcy(postingEntity.getCrcy());
            postingDTO.setUserName(postingEntity.getUserName());
            postingDTO.setAuthorizedDelivery(postingEntity.getAuthorizedDelivery());

            postingDTOList.add(postingDTO);

        });

        return postingDTOList;

    }

}
