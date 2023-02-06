package com.sohwakmo.hr.controller;

import com.sohwakmo.hr.domain.BusinessTrip;
import com.sohwakmo.hr.domain.Vacation;
import com.sohwakmo.hr.dto.VacationCreateDto;
import com.sohwakmo.hr.service.VacationService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/vacation")
public class VacationController {

    private final VacationService vacationService;

    // 휴가(vacation) create list
    @GetMapping("/create")
    public String create(){
        return "/vacation/create";
    }

    // 휴가(vacation) create
    @PostMapping("/create")
    public String create(VacationCreateDto dto){

        String no = "1";

        Vacation vacation = Vacation.builder()
                .employeeNo(no).approverNo(no).title(dto.getTitle()).reason(dto.getReason())
                .category(dto.getCategory()).effectiveDate(dto.getEffectiveDate()).expirationDate(dto.getExpirationDate())
                .build();

        Vacation vacations = vacationService.create(vacation);

        return "/vacation/create";
    }

}