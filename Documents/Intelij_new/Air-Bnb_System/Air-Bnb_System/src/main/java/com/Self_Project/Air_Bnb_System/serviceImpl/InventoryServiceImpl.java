package com.Self_Project.Air_Bnb_System.serviceImpl;

import com.Self_Project.Air_Bnb_System.dto.HotelDto;
import com.Self_Project.Air_Bnb_System.dto.HotelPriceDto;
import com.Self_Project.Air_Bnb_System.dto.HotelSearchRequest;
import com.Self_Project.Air_Bnb_System.entity.Hotel;
import com.Self_Project.Air_Bnb_System.entity.HotelMinPrice;
import com.Self_Project.Air_Bnb_System.entity.Inventory;
import com.Self_Project.Air_Bnb_System.entity.Room;
import com.Self_Project.Air_Bnb_System.repository.HotelMinPriceRepository;
import com.Self_Project.Air_Bnb_System.repository.InventoryRepository;
import com.Self_Project.Air_Bnb_System.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    private final HotelMinPriceRepository hotelMinPriceRepository;

    @Override
    public void initializeRoomForAYear(Room room) {

        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);
        for(; !today.isAfter(endDate); today=today.plusDays(1)){
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .reservedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBasePrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }

    }

    @Override
    public void deleteAllInventories(Room room) {
       // LocalDate today = LocalDate.now();
        log.info("Deleting the inventories of room with id: {}",room.getId());
        inventoryRepository.deleteByRoom(room);
    }


    //previous search method
//    @Override
//    public Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest) {
//        log.info("Searching hotels for {} city, from {} to {}",hotelSearchRequest.getCity(),hotelSearchRequest.getStartDate(),hotelSearchRequest.getEndDate());
//        Pageable pageable = PageRequest.of(hotelSearchRequest.getPage(), hotelSearchRequest.getSize());
//        //if startDate and endDate is 1/2/2025, and end date is 1/2/2025 then its returns 0 for same day for that we add + 1
//        long dateCount =
//                ChronoUnit.DAYS.between(hotelSearchRequest.getStartDate(), hotelSearchRequest.getEndDate()) + 1;
//        Page<Hotel> hotelPage = inventoryRepository.findHotelWithAvailableInventory(hotelSearchRequest.getCity(),
//                hotelSearchRequest.getStartDate(), hotelSearchRequest.getEndDate(),
//                hotelSearchRequest.getRoomsCount(), dateCount, pageable);
//        return hotelPage.map((element) -> modelMapper.map(element, HotelDto.class));
//    }

    //new search hotels by using min price
    @Override
    public Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest) {
        log.info("Searching hotels for {} city, from {} to {}",hotelSearchRequest.getCity(),hotelSearchRequest.getStartDate(),hotelSearchRequest.getEndDate());
        Pageable pageable = PageRequest.of(hotelSearchRequest.getPage(), hotelSearchRequest.getSize());
        //if startDate and endDate is 1/2/2025, and end date is 1/2/2025 then its returns 0 for same day for that we add + 1
        long dateCount =
                ChronoUnit.DAYS.between(hotelSearchRequest.getStartDate(), hotelSearchRequest.getEndDate()) + 1;

        //business logic for 90 days
        Page<HotelPriceDto> hotelPage = hotelMinPriceRepository.findHotelWithAvailableInventory(hotelSearchRequest.getCity(),
                hotelSearchRequest.getStartDate(), hotelSearchRequest.getEndDate(),
                hotelSearchRequest.getRoomsCount(), dateCount, pageable);
        //return hotelPage.map((element) -> modelMapper.map(element, HotelPriceDto.class));
        System.out.println(hotelPage);
        return hotelPage;

    }


}
