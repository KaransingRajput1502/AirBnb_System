package com.Self_Project.Air_Bnb_System.serviceImpl;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.RoomDto;
import com.Self_Project.Air_Bnb_System.entity.Hotel;
import com.Self_Project.Air_Bnb_System.entity.Room;
import com.Self_Project.Air_Bnb_System.execption.ResourceNotFoundException;
import com.Self_Project.Air_Bnb_System.repository.HotelRepository;
import com.Self_Project.Air_Bnb_System.repository.RoomRepository;
import com.Self_Project.Air_Bnb_System.service.InventoryService;
import com.Self_Project.Air_Bnb_System.service.RoomService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom( Long hotelId, RoomDto roomDto) {
        log.info("Creating a room in hotel with ID: {}",hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        //create inventory as soon as room is created and if hotel is active
        if(hotel.getActive())
        {
            inventoryService.initializeRoomForAYear(room);
        }

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting All room in hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId).
                orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        return hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList()) ;

    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("Getting the room with ID: {}", roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: "+roomId));
        return modelMapper.map(room, RoomDto.class);

        //return null;
    }

    @Override
    @Transactional
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);
//        boolean exists = roomRepository.existsById(roomId);
//        if(!exists){
//            throw new ResourceNotFoundException("Room not found with ID: "+roomId);
//        }
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: "+roomId));

        //delete all future inventory for this room
        inventoryService.deleteAllInventories(room);
        roomRepository.deleteById(roomId);

    }
}
