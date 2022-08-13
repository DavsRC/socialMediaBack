package com.sofka.davs.socialMediaBack.userlike;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import com.sofka.davs.socialMediaBack.post.domain.Post;
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
    public ResponseEntity<UserLike> addUserLike(@RequestBody UserLike userLike) {
        return new ResponseEntity<UserLike>(userLikeService.saveUserLike(userLike), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public Iterable<UserLike> getAllUserLikes(){
        return userLikeService.findAllUserLike();
    }

    @GetMapping("/findById/{userLikeId}")
    public ResponseEntity<UserLike> getUserLikeById(@PathVariable Integer userLikeId) {
        return new ResponseEntity<UserLike>(userLikeService.findUserLikeById(userLikeId), HttpStatus.OK);
    }
    @PutMapping("/update/{userLikeId}")
    public ResponseEntity<UserLike> updateUserLike(@PathVariable Integer userLikeId, @RequestBody UserLike userLike) {
        return new ResponseEntity<UserLike>(userLikeService.updateUserLike(userLikeId, userLike), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userLikeId}")
    public ResponseEntity<Void> deleteUserLike(@PathVariable Integer userLikeId) {
        userLikeService.deleteUserLike(userLikeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
