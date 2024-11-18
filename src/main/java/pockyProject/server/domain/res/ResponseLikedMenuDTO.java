package pockyProject.server.domain.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pockyProject.server.entity.LikeMenuEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLikedMenuDTO {

    private  int age;

    private String userId;

    private String nickname;

    private String menuName;

    private int menuImage;

    private String bread;

    private List<String> sauce;

    private List<String> topping;


    public ResponseLikedMenuDTO FromLikeEntity(LikeMenuEntity user) {
        return  new ResponseLikedMenuDTO(
                user.getAge(),
                user.getUserId(),
                user.getMenuName(),
                user.getNickname(),
                user.getMenuImage(),
                user.getBread(),
                user.getSauce(),
                user.getTopping());
    }
}
