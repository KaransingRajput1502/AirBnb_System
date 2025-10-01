package com.Self_Project.Air_Bnb_System.controller;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@Valid @RequestBody HotelDto hotelDto) {
        log.info("Attempting to create a new hotel with name :" +hotelDto.getName());
        HotelDto hotelDto1 = hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotelDto1, HttpStatus.CREATED);
       // return null;
        //karan
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId){
        //log.info("Attempting to get Single hotel with ID",hotelId);
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long hotelId, @RequestBody HotelDto hotelDto){
       // log.info("Attempting to update the hotel with ID", hotelId);
        HotelDto hotelDto1  = hotelService.updateHotelById(hotelId,hotelDto);
        return  new ResponseEntity<>(hotelDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<HotelDto> deleteHotelById(@PathVariable Long hotelId){
        //log.info("Attempting to delete the hotel with ID", hotelId);
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{hotelId}/activate")
    public ResponseEntity<HotelDto> activeHotel(@PathVariable Long hotelId){
       // log.info("Attempting to Enble Status as active the hotel with ID", hotelId);
        hotelService.activeHotel(hotelId);
        return ResponseEntity.noContent().build();
    }



}
