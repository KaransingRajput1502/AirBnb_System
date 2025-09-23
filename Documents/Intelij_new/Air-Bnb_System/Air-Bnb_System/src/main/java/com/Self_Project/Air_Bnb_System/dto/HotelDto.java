package com.Self_Project.Air_Bnb_System.dto;

import com.Self_Project.Air_Bnb_System.entity.HotelContactInfo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class HotelDto {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2–50 characters")
    private String name;

    @NotBlank(message = "City is mandatory")
    private String city ;

    @NotEmpty(message = "photos is mandatory")
    private String[] photos;

    @NotEmpty(message = "amenities is mandatory")
    private String[] amenities;

    @NotNull
    @Valid
    private HotelContactInfo contactInfo;
    private Boolean active;
}
