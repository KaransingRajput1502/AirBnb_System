package com.Self_Project.Air_Bnb_System.service;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.HotelPriceDto;
import com.Self_Project.Air_Bnb_System.dto.HotelSearchRequest;
import com.Self_Project.Air_Bnb_System.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    //previous hotel serch hotels
    //Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    //new search hotels by using min price
    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);


    //Page<HotelDto> serchHotels(HotelSearchRequest hotelSearchRequest);
}
