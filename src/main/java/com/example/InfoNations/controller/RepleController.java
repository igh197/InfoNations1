package com.example.InfoNations.controller;

import com.example.InfoNations.entity.Reple;
import com.example.InfoNations.network.Header;
import com.example.InfoNations.service.NationService;
import com.example.InfoNations.service.RepleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class RepleController {
    private final NationService nationService;
    private final RepleService repleService;
    @PostMapping("/nation/reple/{id}")
    public Reple createReple(@RequestBody Reple reple, @PathVariable Long id){
        return repleService.createReple(reple,reple.getNation().getId());
    }
    @GetMapping("/nations/reple/{id}")
    public Header<List<Reple>> search(@PageableDefault Pageable pageable){
        return repleService.search(pageable);
    }
}
