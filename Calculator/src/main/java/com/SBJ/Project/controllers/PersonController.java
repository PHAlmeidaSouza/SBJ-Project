package com.example.SBJ.Project.controllers;

import com.example.SBJ.Project.converters.NumberConverter;
import com.example.SBJ.Project.exceptions.UnsupportedMathOperationException;
import com.example.SBJ.Project.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

}
