package com.Self_Project.Air_Bnb_System.dto;

import com.Self_Project.Air_Bnb_System.entity.User;
import com.Self_Project.Air_Bnb_System.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name ;
    private Gender gender;
    private Integer age;
}
