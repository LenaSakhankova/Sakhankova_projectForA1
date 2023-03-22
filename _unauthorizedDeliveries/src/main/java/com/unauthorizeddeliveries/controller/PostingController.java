package com.unauthorizeddeliveries.controller;

import com.unauthorizeddeliveries.dtos.PostingDTO;
import com.unauthorizeddeliveries.entities.LoginEntity;
import com.unauthorizeddeliveries.entities.PostingEntity;
import com.unauthorizeddeliveries.mappers.PostingMapper;
import com.unauthorizeddeliveries.repositories.PostingRepository;
import com.unauthorizeddeliveries.services.PostingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("posting")
public class PostingController {

    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }


    @GetMapping("/putPostingDataToDB")
    public ResponseEntity<HttpStatus> putPostingDataToDataBase() {

        postingService.putPostingsToDB();

        return ResponseEntity.ok(HttpStatus.OK);
    }

    //day in format "yyyy-MM-dd"
    @GetMapping("/getPostingsByDay/{day}")
    public List<PostingDTO> putPostingDataDayToDataBase(@PathVariable("day") String day) throws ParseException {

        return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.findByDate(PostingRepository.dateFormat.parse(day)));
    }

    @GetMapping("/getPostingsByDay/{day}/haveAuthorized")
    public List<PostingDTO> putPostingDataDayToDataBaseAuthorized(@PathVariable("day") String day) throws ParseException {

        List<PostingDTO> postingDTOS = new ArrayList<>(){};
        List<PostingDTO> oldList = putPostingDataDayToDataBase(day);
        for (int i = 0; i < oldList.size(); i++) {

            if (oldList.get(i).getAuthorizedDelivery() == true) {
                postingDTOS.add(oldList.get(i));
            }
        }
        return postingDTOS;
    }

    //month in format "yyyy-MM"
    @GetMapping("/getPostingsByMonth/{month}")
    public List<PostingDTO> putPostingDataMonthToDataBase(@PathVariable("month") String month) throws ParseException {

        return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.detectTheDay(month));
    }

    @GetMapping("/getPostingsByMonth/{month}/haveAuthorized")
    public List<PostingDTO> putPostingDataMonthToDataBaseAuthorized(@PathVariable("month") String month)
            throws ParseException {

        List<PostingDTO> postingDTOList = new ArrayList<>() {
        };
        List<PostingDTO> oldList = putPostingDataMonthToDataBase(month);

        for (int i = 0; i < oldList.size(); i++) {

            if (oldList.get(i).getAuthorizedDelivery() == true) {
                postingDTOList.add(oldList.get(i));
            }
        }
        return postingDTOList;
    }

    //year in format "yyyy"
    @GetMapping("/getPostingsByYear/{year}")
    public List<PostingDTO> putPostingDateByYearToDataBase(@PathVariable("year") String year) throws ParseException {

        List<PostingDTO> postingDTOList = new ArrayList<>();
        for (int j = 1; j <= 12; j++) {
            postingDTOList.addAll(PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.detectTheDay(year + "-" + j)));
        }
        return postingDTOList;
    }

    @GetMapping("/getPostingsByYear/{year}/haveAuthorized")
    public List<PostingDTO> putPostingDateByYearToDataBaseAuthorized(@PathVariable("year") String year) throws ParseException {

        List<PostingDTO> postingDTOList = new ArrayList<>() {
        };
        List<PostingDTO> oldList = putPostingDateByYearToDataBase(year);

        for (int i = 0; i < oldList.size(); i++)
            if (oldList.get(i).getAuthorizedDelivery() == true) {
                postingDTOList.add(oldList.get(i));
            }

        return postingDTOList;
    }

    //quarter in format "/numberOfQuarter/yyyy"
    @GetMapping("/getPostingsByQuarter/{quarter}/{year}")
    public List<PostingDTO> putPostingDateByQuarterToDataBase(@PathVariable("quarter") int quarter,
                                                              @PathVariable("year") int year) throws ParseException {
        switch (quarter) {
            case 1:
                return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.formatToQuarter(year, 1));

            case 2:
                return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.formatToQuarter(year, 4));

            case 3:
                return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.formatToQuarter(year, 7));

            case 4:
                return PostingMapper.mapPostingEntitiesToPostingDTOs(postingService.formatToQuarter(year, 10));

            default:
                break;
        }
        return null;
    }

    @GetMapping("/getPostingsByQuarter/{quarter}/{year}/haveAuthorized")
    public List<PostingDTO> putPostingDateByQuarterToDataBaseAuthorized(@PathVariable("quarter") int quarter,
                                                                        @PathVariable("year") int year) throws ParseException
    {
        List<PostingDTO> postingDTOList = new ArrayList<>() {
        };
        List<PostingDTO> oldList = putPostingDateByQuarterToDataBase(quarter, year);

        for (int i = 0; i < oldList.size(); i++) {

            if (oldList.get(i).getAuthorizedDelivery() == true) {
                postingDTOList.add(oldList.get(i));
            }

        }
        return postingDTOList;
    }

}
