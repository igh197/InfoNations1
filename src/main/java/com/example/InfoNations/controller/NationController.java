package com.example.InfoNations.controller;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.network.Header;
import com.example.InfoNations.service.NationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class NationController {

    private final NationService nationService;

    @PostMapping("nation/new")
    public Nation createNation(@RequestBody Nation nation){
        return nationService.save(nation);
    }
    @GetMapping("/nations")
    public Header<List<Nation>> searchNations(@PageableDefault Pageable pageable){
        return nationService.search(pageable);
    }
    @GetMapping("/nation/{id}")
    public Nation getNation(@PathVariable Long id){
        return nationService.getNation(id);
    }
    @PutMapping("/nation/{id}")
    public void putNation(@PathVariable Long id, @RequestBody Nation nation){
        nationService.putNation(nation,id);
    }
    @DeleteMapping("/nation/{id}")
    public void deleteNation(@PathVariable Long id){
        nationService.deleteNation(id);
    }

}
