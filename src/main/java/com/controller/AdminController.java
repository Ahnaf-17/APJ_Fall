package com.controller;

import com.domain.Admin;
import com.domain.User;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.AdminService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class AdminController {
    private AdminService adminService ;
    private UserService userService;
    public AdminController(AdminService adminService , UserService userService) {
        this.adminService = adminService;
        this.userService = userService;

    }
//
//    public AdminController(UserService userService) {
//        this.userService = userService;
//
//    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws Exception {
        if (admin.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        adminService.insert(admin);
        return ResponseEntity.created(new URI("/admins /"))
                .body(admin);
    }

    @PutMapping("/admins")
    public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin) throws Exception {
        if (admin.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        adminService.update(admin);
        return ResponseEntity.created(new URI("/admins/"))
                .body(admin);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAllAuthorities() {
        List<Admin> admins = adminService.getAll();
        return ResponseEntity.ok().body(admins);
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Optional<Admin> admin = Optional.ofNullable(adminService.get(id));
        if (admin.isPresent()) {
            return ResponseEntity.ok().body(admin.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    private UserService userService ;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//
//
//    }
//create
    @PostMapping ("/user")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new BadRequestAlertException("Invalid user");
        }
        userService.update(user);
        return ResponseEntity.created(new URI("/register"))
                .body(user);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(users);
    }

    //delete
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
