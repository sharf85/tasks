package com.telran.person.controller;

import com.telran.person.validation.ViolationDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerAdviceController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ViolationDto> handleDtoValidationException(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        List<ViolationDto> violations = new ArrayList<>();

        for (ObjectError error : errors) {
            ViolationDto violation;
            if (error instanceof FieldError)
                violation = new ViolationDto(((FieldError) error).getField(), error.getDefaultMessage());
            else
                violation = new ViolationDto(error.getObjectName(), error.getDefaultMessage());
            violations.add(violation);
        }

        return violations;
//        return errors.stream()
//                .map(error -> new ViolationDto(((FieldError) error).getField(), error.getDefaultMessage()))
//                .collect(Collectors.toList());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ViolationDto> handleArgumentValidationException(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream()
                .map(cv -> new ViolationDto(cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());
    }
}
