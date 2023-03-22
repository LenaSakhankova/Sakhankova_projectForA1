package com.unauthorizeddeliveries.repositories;

import com.unauthorizeddeliveries.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
}
