package com.SBJ.Project.data.vo.v1;

import com.github.dozermapper.core.Mapping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonVO extends RepresentationModel<PersonVO> {

    @Mapping("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
