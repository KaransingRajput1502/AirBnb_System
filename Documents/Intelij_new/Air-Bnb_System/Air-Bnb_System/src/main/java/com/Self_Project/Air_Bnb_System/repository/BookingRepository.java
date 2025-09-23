package com.Self_Project.Air_Bnb_System.repository;

import com.Self_Project.Air_Bnb_System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
