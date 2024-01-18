package com.example.InfoNations.service;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.network.NationDto;
import com.example.InfoNations.repository.NationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Nation> search(){
        List<Nation> nations=nationRepository.findAll();


        return nations;
    }
    public Nation getNation(String name){
        return nationRepository.findNationByName(name);
    }
    public NationDto putNation(String name, NationDto nationDto) {
        Nation nation = nationRepository.findNationByName(name);

        nation.setName(nationDto.getName());
        nation.setCapital(nationDto.getCapital());
        nation.setPopulation(nationDto.getPopulation());
        nation.setContin(nationDto.getContin());
        nation.setCurrency(nationDto.getCurrency());
        nation.setContents(nationDto.getContents());
        nationRepository.save(nation);
        return nationDto;
    }
    public void deleteNation(Long id){
        nationRepository.deleteById(id);
    }
}
