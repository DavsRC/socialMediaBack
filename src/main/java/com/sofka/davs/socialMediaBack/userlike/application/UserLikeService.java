package com.sofka.davs.socialMediaBack.userlike.application;

import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import com.sofka.davs.socialMediaBack.userlike.domain.UserLikeRepository;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.mysql.MySqlUserLikeRepository;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto.UserLikeDTO;
import com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.mapper.UserLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserLikeService implements UserLikeRepository {

    @Autowired
    MySqlUserLikeRepository mySqlUserLikeRepository;

    @Autowired
    UserLikeMapper userLikeMapper;

    @Override
    public UserLikeDTO saveUserLike(UserLikeDTO userLikeDTO) {
        UserLike userLike = userLikeMapper.convertDtoToUserLike(userLikeDTO);
        mySqlUserLikeRepository.save(userLike);
        return userLikeDTO;
    }

    @Override
    public UserLikeDTO findUserLikeById(Integer userLikeId) {
        Optional<UserLike> commentOptional = mySqlUserLikeRepository.findById(userLikeId);
        if(commentOptional.isEmpty()){
            throw new NoSuchElementException("It doesn't exist the userLikeId with id: " + userLikeId);
        }
        return userLikeMapper.convertUserLikeToDTo(commentOptional.get());
    }

    @Override
    public Iterable<UserLikeDTO> findAllUserLike() {
        List<UserLike> userLikeList = mySqlUserLikeRepository.findAll();
        return userLikeList.stream().map(userLike -> userLikeMapper.convertUserLikeToDTo(userLike)).toList();
    }

    @Override
    public UserLikeDTO updateUserLike(Integer userLikeId, UserLikeDTO userLikeDTO) {
        UserLikeDTO userLikeDTOFound = findUserLikeById(userLikeId);
        userLikeDTOFound.setDni(userLikeDTO.getDni());
        userLikeDTOFound.setName(userLikeDTO.getName());
        UserLike userLike = userLikeMapper.convertDtoToUserLike(userLikeDTOFound);
        mySqlUserLikeRepository.save(userLike);
        return userLikeDTOFound;
    }

    @Override
    public void deleteUserLike(Integer userLikeId) {
        UserLikeDTO userLikeDTODeleted =  findUserLikeById(userLikeId);
        UserLike userLike = userLikeMapper.convertDtoToUserLike(userLikeDTODeleted);
        mySqlUserLikeRepository.delete(userLike);
    }
}
