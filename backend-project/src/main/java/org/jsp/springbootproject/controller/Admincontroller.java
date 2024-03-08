package org.jsp.springbootproject.controller;

import java.util.List;

import org.jsp.springbootproject.dto.Admin;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class Admincontroller {

    @Autowired
    private Adminservice service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsestructure<Admin> saveAdmin(@RequestBody Admin admin) {
        return service.saveAdmin(admin);
    }

    @PutMapping
    public ResponseEntity<Responsestructure<Admin>> updateAdmin(@RequestBody Admin admin) {
        return service.updateAdmin(admin);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Responsestructure<List<Admin>> fetchAll() {
        return service.Fetchall();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsestructure<Admin>> fetchById(@PathVariable int id) {
        return service.Fetchbyid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Responsestructure<String>> deleteAdmin(@PathVariable int id) {
        return service.deleteAdmin(id);
    }

    @GetMapping("/verifybyphone")
    public Admin verifyByPhone(@RequestParam long phone, @RequestParam String password) {
        return service.verifybyphone(phone, password);
    }

    @GetMapping("/verifybyemail")
    public Admin verifyByEmail(@RequestParam String email, @RequestParam String password) {
        return service.verifybyemail(email, password);
    }

    @GetMapping("/findbyname/{name}")
    public List<Admin> findByName(@PathVariable String name) {
        return service.findbyname(name);
    }
}
