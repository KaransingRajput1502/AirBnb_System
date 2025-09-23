package com.Self_Project.Air_Bnb_System.dto;

import com.Self_Project.Air_Bnb_System.entity.*;
import com.Self_Project.Air_Bnb_System.entity.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {
    private long id;
    private Integer roomsCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    //if user refreshes the page then the timer will be updated in frontEnd for thise we kept this fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<Guest> guests;
}
