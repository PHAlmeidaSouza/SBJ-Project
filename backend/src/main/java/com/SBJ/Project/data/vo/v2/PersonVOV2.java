package com.SBJ.Project.data.vo.v2;

import com.github.dozermapper.core.Mapping;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class PersonVOV2 extends RepresentationModel<PersonVOV2> {

    @Mapping("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDate;

}
