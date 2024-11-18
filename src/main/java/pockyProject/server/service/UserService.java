package pockyProject.server.service;

import pockyProject.server.domain.res.ResponseLikedMenuDTO;
import pockyProject.server.domain.res.ResponseUserDTO;
import pockyProject.server.domain.res.UserJoinDTO;
import pockyProject.server.entity.RecommendEntity;

import java.util.List;

public interface UserService {


    ResponseUserDTO saveUser(ResponseUserDTO userDto);


    List<RecommendEntity> getRecommendList();


    ResponseLikedMenuDTO saveLikedMenu(ResponseLikedMenuDTO userDto);


    void joinUser(UserJoinDTO userDto);

    void deleteUserInfo(String userId);

}
