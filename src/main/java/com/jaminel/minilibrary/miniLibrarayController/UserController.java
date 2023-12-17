package com.jaminel.minilibrary.miniLibrarayController;

import com.jaminel.minilibrary.response.ResponseHandler;
import com.jaminel.minilibrary.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends UserService {
    @Autowired
    UserService userService;


    @PostMapping("/adduser")
    public ResponseEntity<Object> addsUser(@RequestBody User user) {
        return  ResponseHandler.responseBuilder("User added", HttpStatus.OK,userService.addUser(user));
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Object>deletesUser(@PathVariable long id) {
        return  ResponseHandler.responseBuilder("Deleted sucessfully",HttpStatus.OK,userService.deleteUser(id));
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<Object> updatesUser(@PathVariable long id, @RequestBody User user) {
        return ResponseHandler.responseBuilder("User was updated", HttpStatus.OK, userService.updateUser(id, user));

    }

     @GetMapping("/findUserById/{id}")
    public ResponseEntity<Object> findsUserById(@PathVariable long id) {
        return ResponseHandler.responseBuilder("This is your user id",HttpStatus.OK,userService.findUserById(id));
    }

    @GetMapping("/findUserByemail/{email}")
    public ResponseEntity<Object> findsUserByEmail(@PathVariable String email) {
        return ResponseHandler.responseBuilder("foundByEmail",HttpStatus.OK,userService.findUserByEmail(email));
    }

    @GetMapping("/findUserByfullName/{fullName}")
    public ResponseEntity<Object> getsUsersBYFullName(String fullName) {
        return ResponseHandler.responseBuilder("Found FullName",HttpStatus.OK,userService.getUsersBYFullName(fullName));
    }
    @GetMapping("lisOfAlUsers")
    public ResponseEntity<Object>listAllUser(){
        return ResponseHandler.responseBuilder("List of all users availabe in db",HttpStatus.OK,userService.listAllUsers());
    }
}
