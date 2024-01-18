package com.example.InfoNations.service;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.entity.Reple;
import com.example.InfoNations.repository.NationRepository;
import com.example.InfoNations.repository.RepleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class RepleService {
    private final RepleRepository repleRepository;

    private final NationRepository nationRepository;

    public Reple createReple(Reple reple, String name){
        Nation nation = nationRepository.findNationByName(name);
        return repleRepository.save(Reple.builder().contents(reple.getContents())
                        .nationId(nation.getId())
                   .build());
    }
    public List<Reple> search(String name){
        List<Reple> reples=repleRepository.findReplesByNationId(nationRepository.findNationByName(name).getId());

        return reples;
    }
}
