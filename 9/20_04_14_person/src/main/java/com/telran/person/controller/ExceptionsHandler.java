package com.telran.person.controller;

import com.telran.person.validation.FieldViolationDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldViolationDto> handleMethodExceptions(MethodArgumentNotValidException e) {

        List<FieldViolationDto> res = new ArrayList<>();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            FieldViolationDto violation;
            if (error instanceof FieldError)
                violation = new FieldViolationDto(((FieldError) error).getField(), error.getDefaultMessage());
            else
                violation = new FieldViolationDto(error.getObjectName(), error.getDefaultMessage());
            res.add(violation);
        }

        return res;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldViolationDto> handleParameterExceptions(ConstraintViolationException e) {

        //TODO write real handling
        List<FieldViolationDto> res = Arrays.asList(new FieldViolationDto("tel", "ran"));

        return res;
    }

}
