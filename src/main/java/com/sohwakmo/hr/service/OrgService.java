package com.sohwakmo.hr.service;

import com.sohwakmo.hr.domain.Employee;
import com.sohwakmo.hr.dto.OrgReadDto;
import com.sohwakmo.hr.repository.MeetingRoomRepository;
import com.sohwakmo.hr.repository.OrgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrgService {

    private final OrgRepository orgRepository;
    private final MeetingRoomRepository meetingRoomRepository;


    public List<OrgReadDto> readAllOrgList() {
        log.info("readAllOrgList()");
        List<Employee> list = orgRepository.findByOrderByPartDepartmentAscPartTeamAscEmployeePositionDesc();

        return list.stream()
                .map(OrgReadDto::fromEntity)
                .toList();
    }
}