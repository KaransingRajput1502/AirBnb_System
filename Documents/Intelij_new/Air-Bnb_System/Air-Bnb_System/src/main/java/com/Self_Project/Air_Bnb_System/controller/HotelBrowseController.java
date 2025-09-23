package com.Self_Project.Air_Bnb_System.controller;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.HotelInfoDto;
import com.Self_Project.Air_Bnb_System.dto.HotelPriceDto;
import com.Self_Project.Air_Bnb_System.dto.HotelSearchRequest;
import com.Self_Project.Air_Bnb_System.service.HotelService;
import com.Self_Project.Air_Bnb_System.service.InventoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    //previous hotel search
   /* @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }*/

    //new search hotels by using min price
    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {
        var page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }


    //we need to get hotel info by id with hotel id and all rooms which are present in the hotels
    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId){
         return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }
}
