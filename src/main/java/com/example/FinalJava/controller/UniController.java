package com.example.FinalJava.controller;
import com.example.FinalJava.dto.req.UniPostRequest;
import com.example.FinalJava.dto.req.UniPutRequest;
import com.example.FinalJava.dto.res.UniAllResponse;
import com.example.FinalJava.dto.res.UniGetResponse;
import com.example.FinalJava.dto.res.UniPostResponse;
import com.example.FinalJava.dto.res.UniPutResponse;
import com.example.FinalJava.service.UniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UniController {
    @Autowired
    private UniService uniService;

    @GetMapping("/get")
    public List<UniAllResponse> getAlluni(){
        return uniService.getAlluni();
    }

    @GetMapping("/getmap/{id}")
    public UniGetResponse getuni(@PathVariable int id){
        return uniService.getuni(id);
    }

    @PostMapping("/post")
    public UniPostResponse adduni(@RequestBody UniPostRequest uniPostRequest){
        return uniService.adduni(uniPostRequest);
    }

    @PutMapping("/put/{id}")
    public UniPutResponse updateuni(@PathVariable(name="id") int id, @RequestBody UniPutRequest uniPutRequest){
        return uniService.updateuni(id,uniPutRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteuni(@PathVariable(name="id") int id){
        uniService.deleteuni(id);
    }
}
