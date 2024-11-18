package pockyProject.server.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pockyProject.server.entity.LikeMenuEntity;
import pockyProject.server.entity.RecommendEntity;
import pockyProject.server.entity.UserEntity;
import pockyProject.server.entity.UserMenuEntity;
import pockyProject.server.repository.LikeMenuRepository;
import pockyProject.server.repository.RecommendRepository;
import pockyProject.server.repository.UserMenuRepository;
import pockyProject.server.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserDaoImpl implements  UserDAO{

    private  final UserMenuRepository userMenuRepository;

    private  final LikeMenuRepository likeMenuRepository;

    private  final RecommendRepository recommendRepository;

    private  final UserRepository userRepository;

    @Override
    public UserMenuEntity insertUser(UserMenuEntity userEntity) {


        return userMenuRepository.save(userEntity);
    }

    @Override
    public List<RecommendEntity> selectRecommendList() {

        return recommendRepository.findAll();
    }

    @Override
    public LikeMenuEntity insertLikeMenu(LikeMenuEntity likeMenuEntity) {
        return  likeMenuRepository.save(likeMenuEntity);
    }
    @Override
    public UserEntity joinUser(UserEntity userEntity) {
        return  userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


}
