package com.spring.boot.controller;
import com.spring.boot.dto.ChefDto;
import com.spring.boot.service.ChefService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/chefs")
public class ChefController {

    private ChefService chefService;

    @Autowired
    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ChefDto>> getAllChefs() {
        List<ChefDto> allChefs = chefService.getAllChefs();
        return ResponseEntity.ok(allChefs);
    }

    @PostMapping("/save")
    public ResponseEntity<ChefDto> saveChef(@RequestBody @Valid ChefDto chefDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("chefs/save/")).body(chefService.saveChef(chefDto));
    }
}
