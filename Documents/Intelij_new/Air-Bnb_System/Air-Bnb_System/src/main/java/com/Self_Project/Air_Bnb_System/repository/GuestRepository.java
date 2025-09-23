package com.Self_Project.Air_Bnb_System.repository;

import com.Self_Project.Air_Bnb_System.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}