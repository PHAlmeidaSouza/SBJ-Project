package com.SBJ.Project.data.vo.v2;

import lombok.Data;

import java.util.Date;

@Data
public class PersonVOV2 {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDate;

}
