package com.example.company.Company.Controller;

import com.example.company.Company.Entiry.Company;
import com.example.company.Company.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService service;
    @GetMapping("/all")
    public List<Company> getAll(){
        return service.getAllcompanies();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable long id){
        return new ResponseEntity<>(service.getAllById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Company> AddCompany(@RequestBody Company company){
        service.AddCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> UpdateCompany(@RequestBody Company company,@PathVariable long id){
         service.updateCompany(company,id);
         return new ResponseEntity("Updated Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable long id){
                service.deleteCompany(id);
        return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
    }

}
