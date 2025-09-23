package com.Self_Project.Air_Bnb_System.repository;

import com.Self_Project.Air_Bnb_System.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
