package com.example.FinalJava.controller;
import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;
import com.example.FinalJava.service.UniService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/universites")
public class UniController {
    @Autowired
    private final  UniService uniService;

    public UniController(UniService uniService) {
        this.uniService = uniService;
    }


    @GetMapping("/universites")
    public List<UniAllResponse> getAlluni(){
        return uniService.getAlluni();
    }

    @GetMapping("/universites/{id}")
    public UniGetResponse getuni(@PathVariable int id){
        return uniService.getuni(id);
    }

    @PostMapping("/universites")
    public UniPostResponse adduni(@Valid @RequestBody UniPostRequest uniPostRequest){
        return uniService.adduni(uniPostRequest);
    }

    @PutMapping("/universites/{id}")
    public UniPutResponse updateuni( @PathVariable(name="id") int id,@Valid @RequestBody UniPutRequest uniPutRequest){
        return uniService.updateuni(id,uniPutRequest);
    }


    @DeleteMapping("/universites/{id}")
    public void deleteuni(@PathVariable(name="id") int id){
        uniService.deleteuni(id);
    }
}
