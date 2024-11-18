package pockyProject.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pockyProject.server.dao.UserDAO;
import pockyProject.server.domain.res.ResponseLikedMenuDTO;
import pockyProject.server.domain.res.ResponseUserDTO;
import pockyProject.server.domain.res.UserJoinDTO;
import pockyProject.server.entity.LikeMenuEntity;
import pockyProject.server.entity.RecommendEntity;
import pockyProject.server.entity.UserEntity;
import pockyProject.server.entity.UserMenuEntity;

import java.util.ArrayList;
import java.util.List;

import static pockyProject.server.entity.LikeMenuEntity.EntityFromLikeDTO;
import static pockyProject.server.entity.UserMenuEntity.FromToEntity;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{



    private final UserDAO userDAO;
    @Override
    public ResponseUserDTO saveUser(ResponseUserDTO userDto) {
        if (userDto.getSauce() == null) {
            userDto.setSauce(new ArrayList<>());
        }
        // UserDto -> UserEntity 변환 (Builder 패턴 사용)
        UserMenuEntity userEntity = new UserMenuEntity();
        userEntity = FromToEntity(userDto);
        // UserEntity 저장
        UserMenuEntity savedEntity = userDAO.insertUser(userEntity);

        return  userDto.FromEntity(savedEntity);

        
    }


    @Override
    public ResponseLikedMenuDTO saveLikedMenu(ResponseLikedMenuDTO userDto) {
        // LikedDto -> LikeMenuEntity 변환
        LikeMenuEntity likeMenuEntity = new LikeMenuEntity();
        likeMenuEntity = EntityFromLikeDTO(userDto);
        // LikeMenuEntity 저장
        LikeMenuEntity savedEntity = userDAO.insertLikeMenu(likeMenuEntity);

        return  userDto.FromLikeEntity(savedEntity);

    }



    @Override
    public void joinUser(UserJoinDTO userDto) {
        UserEntity userEntity =new UserEntity();
        userEntity=UserEntity.JoinToEntity(userDto);
        userDAO.joinUser(userEntity);
    }

    @Override
    public void deleteUserInfo(String userId) {

        userDAO.deleteUser(userId);
    }




    public List<RecommendEntity> getRecommendList(){


        return userDAO.selectRecommendList();
    }

}


//        return ResponseUserDto.builder()
//                .userId(savedEntity.getUserId())
//                .nickname(savedEntity.getNickname())
//                .topping(savedEntity.getTopping())
//                .bread(savedEntity.getBread())
//                .liquid(savedEntity.getLiquid())
//                .sauce(savedEntity.getSauce())
//                .side(savedEntity.getSide())
//                .price(savedEntity.getPrice())
//                .menuImage(savedEntity.getMenuImage())
//                .build();