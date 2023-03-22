package com.unauthorizeddeliveries.services;

import com.unauthorizeddeliveries.controller.PostingController;
import com.unauthorizeddeliveries.dtos.PostingDTO;
import com.unauthorizeddeliveries.entities.PostingEntity;
import com.unauthorizeddeliveries.repositories.PostingRepository;
import com.unauthorizeddeliveries.mappers.PostingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostingService {

  private final PostingRepository postingRepository;



    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;

    }


    @Transactional
    public void putPostingsToDB(){

        postingRepository.saveAll(PostingMapper.mapPostingDTOsToPostingEntities(ExelUploadService.postingDTOList));

    }


    public List<PostingEntity> findByDate(Date date){

       return postingRepository.findAllByPstngDate(date);

    }

    public List<PostingEntity> detectTheDay(String month) throws ParseException {
        List<PostingEntity> postingEntities = new ArrayList<>();
        StringBuilder stringForConcatMonthDateWithDay = new StringBuilder();
        for(int i = 0; i < 31; i++)
        {
            stringForConcatMonthDateWithDay.append(month + "-" + i);

            postingEntities.addAll(findByDate(PostingRepository.dateFormat.parse(stringForConcatMonthDateWithDay.toString())));

            stringForConcatMonthDateWithDay.setLength(0);
        }
        return postingEntities;
    }

    public List<PostingEntity> formatToQuarter(int year, int startMonth) throws ParseException {

        int temp = 1;

        List<PostingEntity> postingEntities = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        do{
            for(int i = 0; i <= 31; i++) {
                stringBuilder.append(year + "-" + startMonth + "-" + i);
                postingEntities.addAll(findByDate(postingRepository.dateFormat.parse(stringBuilder.toString())));

                stringBuilder.setLength(0);
            }

            startMonth++;
            temp++;

        }while (temp != 3);

        return postingEntities;
    }
}
