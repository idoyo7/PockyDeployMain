package pockyProject.server.dao;

import pockyProject.server.entity.LikeMenuEntity;
import pockyProject.server.entity.RecommendEntity;
import pockyProject.server.entity.UserEntity;
import pockyProject.server.entity.UserMenuEntity;

import java.util.List;

public interface UserDAO {

    UserMenuEntity insertUser(UserMenuEntity userEntity);


    List<RecommendEntity> selectRecommendList();


    LikeMenuEntity insertLikeMenu(LikeMenuEntity likeMenuEntity);

    UserEntity joinUser(UserEntity userEntity);

   void deleteUser(String userId);

}
