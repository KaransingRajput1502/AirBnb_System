package com.Self_Project.Air_Bnb_System.serviceImpl;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.HotelInfoDto;
import com.Self_Project.Air_Bnb_System.dto.RoomDto;
import com.Self_Project.Air_Bnb_System.entity.Hotel;
import com.Self_Project.Air_Bnb_System.entity.Room;
import com.Self_Project.Air_Bnb_System.execption.ResourceNotFoundException;
import com.Self_Project.Air_Bnb_System.repository.HotelRepository;
import com.Self_Project.Air_Bnb_System.repository.RoomRepository;
import com.Self_Project.Air_Bnb_System.service.HotelService;
import com.Self_Project.Air_Bnb_System.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServicesImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new Hotel with name: {}", hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        Hotel newHotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDto.getId());
        return modelMapper.map(newHotel, HotelDto.class);
    }

//    @Override
//    public HotelDto getHotel(Hotel hotelDto) {
//        return null;
//    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+id));

        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+id));
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        Hotel hotel1 = hotelRepository.save(hotel);
       // HotelDto hotelDto1 = modelMapper.map(hotel1, HotelDto.class);
        return modelMapper.map(hotel1, HotelDto.class);
    }

    @Override
    @Transactional
    public Boolean deleteHotelById(Long id) {
//        Boolean existsById = hotelRepository.existsById(id);
//        if (!existsById) throw new ResourceNotFoundException("Hotel id not found"+id);
        Hotel hotel = hotelRepository
                .findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+id));
        //hotelRepository.deleteById(id);

        //Delete the future invetories for this hotel
        for(Room room: hotel.getRooms())
        {
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }
      hotelRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public void activeHotel(Long id) {
        log.info("Activate the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+id));
        hotel.setActive(true);

        //create inventory for all rooms for this hotel
        //assuming do it ones
        for(Room room: hotel.getRooms())
        {
            inventoryService.initializeRoomForAYear(room);
        }
    }

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element)-> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }
}
