package com.unauthorizeddeliveries.repositories;

import com.unauthorizeddeliveries.dtos.PostingDTO;
import com.unauthorizeddeliveries.entities.PostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<PostingEntity, Long> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    List<PostingEntity> findAllByPstngDate(Date date);
}
