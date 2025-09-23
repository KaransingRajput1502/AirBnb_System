package com.Self_Project.Air_Bnb_System.service;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.HotelInfoDto;
import com.Self_Project.Air_Bnb_System.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

   // HotelDto getHotel(Hotel hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    Boolean deleteHotelById(Long id);

    void activeHotel(Long id);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
