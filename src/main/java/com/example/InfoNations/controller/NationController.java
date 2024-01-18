package com.example.InfoNations.controller;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.network.NationDto;
import com.example.InfoNations.service.NationService;
import lombok.RequiredArgsConstructor;
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
    public List<Nation> searchNations(){
        return nationService.search();
    }
    @GetMapping("/nation/{name}")
    public Nation getNation(@PathVariable String name){
        return nationService.getNation(name);
    }
    @PutMapping("/nation/{name}")
    public NationDto putNation(@PathVariable String name, @RequestBody NationDto nationDto){
        return nationService.putNation(name,nationDto);
    }
    @DeleteMapping("/nation/{id}")
    public void deleteNation(@PathVariable Long id){
        nationService.deleteNation(id);
    }

}
