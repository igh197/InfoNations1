package com.example.InfoNations.service;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.entity.User;
import com.example.InfoNations.network.Header;
import com.example.InfoNations.network.Pagination;
import com.example.InfoNations.repository.NationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NationService {
    private final NationRepository nationRepository;
    public Nation save(Nation nation) {
        return nationRepository.save(Nation.builder()
                .capital(nation.getCapital())
                .population(nation.getPopulation())
                        .contin(nation.getContin())
                        .name(nation.getName())
                        .currency(nation.getCurrency())
                        .contents(nation.getContents())

                .build());
    }

    public Header<List<Nation>> search(Pageable pageable){
        Page<Nation> nations=nationRepository.findAll(pageable);
        List<Nation> nationList = nations.stream().toList();
        Pagination pagination = Pagination.builder()
                .totalPages(nations.getTotalPages())
                .totalElements(nations.getTotalElements())
                .currentPage(nations.getNumber())
                .currentElements(nations.getNumberOfElements())
                .build();
        return Header.OK(nationList,pagination);
    }
    public Nation getNation(Long id){
        return nationRepository.findNationById(id);
    }
    public Nation putNation(Nation nation, Long id) {
        Nation newNation = nationRepository.findNationById(id);
        newNation.setCapital(nation.getCapital());
        newNation.setName(nation.getName());
        newNation.setPopulation(nation.getPopulation());
        newNation.setContin(nation.getContin());
        newNation.setCurrency(nation.getCurrency());
        newNation.setContents(nation.getContents());
        nationRepository.save(newNation);
        return newNation;
    }
    public void deleteNation(Long id){
        nationRepository.deleteById(id);
    }
}
