package com.controller;

import com.domain.Admin;
import com.domain.Catagory;
import com.exception.BadRequestAlertException;
import com.service.CatagoryService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/taxpayer")
public class UserController {
    private CatagoryService catagoryService;
    public UserController(CatagoryService catagoryService){
        this.catagoryService = catagoryService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/taxpayer")
    public ResponseEntity<Catagory> register(@Valid @RequestBody Catagory catagory) throws URISyntaxException {
        Catagory newCatagory = catagoryService.insert(catagory);
        return ResponseEntity.created(new URI("/taxpayer"))
                .body(null);
    }
    @PutMapping("/taxpayer")
    public ResponseEntity<Catagory> updateAdmin(@Valid @RequestBody Catagory catagory) throws Exception {
        if (catagory.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        catagoryService.update(catagory);
        return ResponseEntity.created(new URI("/taxpayer/"))
                .body(catagory);
    }

}
