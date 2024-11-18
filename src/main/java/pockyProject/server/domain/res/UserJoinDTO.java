package pockyProject.server.domain.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pockyProject.server.entity.UserEntity;
import pockyProject.server.entity.UserMenuEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDTO {


    private  String userUid;

    private String nickname;


    private String userImage;

    private  int age;


    public  UserJoinDTO FromJoinEntity(UserEntity user) {
        return  new UserJoinDTO(
                user.getUserUid(),
                user.getNickname(),
                user.getUserImage(),
                user.getAge());
    }
}
