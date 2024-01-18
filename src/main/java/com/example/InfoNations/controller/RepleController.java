package com.example.InfoNations.controller;

import com.example.InfoNations.entity.Reple;
import com.example.InfoNations.service.NationService;
import com.example.InfoNations.service.RepleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class RepleController {
    private final NationService nationService;
    private final RepleService repleService;
    @PostMapping("/nation/reple/{name}")
    public Reple createReple(@RequestBody Reple reple, @PathVariable String name){
        return repleService.createReple(reple,name);
    }
    @GetMapping("/nation/reple/{name}")
    public List<Reple> search(@PathVariable String name){
        return repleService.search(name);
    }
}
