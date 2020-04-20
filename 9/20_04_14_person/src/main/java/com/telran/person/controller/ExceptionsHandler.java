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
import java.util.List;
import java.util.stream.Collectors;

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
        return e.getConstraintViolations().stream()
                .map(violation -> new FieldViolationDto(
                        violation.getPropertyPath().toString(),
                        violation.getMessage()
                ))
                .collect(Collectors.toList());
    }

}
