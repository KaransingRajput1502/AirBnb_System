package com.Self_Project.Air_Bnb_System.service;

import com.Self_Project.Air_Bnb_System.dto.BookingDto;
import com.Self_Project.Air_Bnb_System.dto.BookingRequest;
import com.Self_Project.Air_Bnb_System.dto.GuestDto;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
