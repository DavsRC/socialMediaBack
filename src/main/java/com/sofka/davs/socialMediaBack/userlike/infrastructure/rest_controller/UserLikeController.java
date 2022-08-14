package com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller;

import com.sofka.davs.socialMediaBack.userlike.application.UserLikeService;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userlike")
public class UserLikeController {

    @Autowired
    UserLikeService userLikeService;

    @PostMapping("/save")
    public ResponseEntity<UserLikeDTO> addUserLike(@RequestBody UserLikeDTO userLikeDTO) {
        return new ResponseEntity<UserLikeDTO>(userLikeService.saveUserLike(userLikeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<UserLikeDTO> getAllUserLikes(){
        return userLikeService.findAllUserLike();
    }

    @GetMapping("/findById/{userLikeId}")
    public ResponseEntity<UserLikeDTO> getUserLikeById(@PathVariable Integer userLikeId) {
        return new ResponseEntity<UserLikeDTO>(userLikeService.findUserLikeById(userLikeId), HttpStatus.OK);
    }
    @PutMapping("/update/{userLikeId}")
    public ResponseEntity<UserLikeDTO> updateUserLike(@PathVariable Integer userLikeId, @RequestBody UserLikeDTO userLikeDTO) {
        return new ResponseEntity<UserLikeDTO>(userLikeService.updateUserLike(userLikeId, userLikeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userLikeId}")
    public ResponseEntity<Void> deleteUserLike(@PathVariable Integer userLikeId) {
        userLikeService.deleteUserLike(userLikeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
