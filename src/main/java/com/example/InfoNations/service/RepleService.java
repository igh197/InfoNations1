package com.example.InfoNations.service;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.entity.Reple;
import com.example.InfoNations.network.Header;
import com.example.InfoNations.network.Pagination;
import com.example.InfoNations.repository.RepleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RepleService {
    private final RepleRepository repleRepository;



    public Reple createReple(Reple reple, Long id){
        return repleRepository.save(Reple.builder().content(reple.getContent())
                        .nation(reple.getNation())
                   .build());
    }
    public Header<List<Reple>> search(Pageable pageable){
        Page<Reple> reples=repleRepository.findAll(pageable);
        List<Reple> repleList = reples.stream().toList();
        Pagination pagination = Pagination.builder()
                .totalPages(reples.getTotalPages())
                .totalElements(reples.getTotalElements())
                .currentPage(reples.getNumber())
                .currentElements(reples.getNumberOfElements())
                .build();
        return Header.OK(repleList,pagination);
    }
}
