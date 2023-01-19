package com.sohwakmo.hr.service;

import com.sohwakmo.hr.domain.Employee;
import com.sohwakmo.hr.dto.OrgReadDto;
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

    public List<OrgReadDto> readOrgMember(String team) {
        log.info("readOrgMember(team={})", team);
        List<Employee> list = orgRepository.findByPartTeamOrderByIdDesc(team);

        return list.stream()
                .map(OrgReadDto::fromEntity)
                .toList();
    }
}
