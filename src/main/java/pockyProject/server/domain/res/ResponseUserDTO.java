package pockyProject.server.domain.res;

import lombok.*;
import pockyProject.server.entity.UserMenuEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class ResponseUserDTO {


    private  String  userId;

    private int age;

    private String menuName;

    private  String nickname;


    private int menuImage;

    private String bread;

    private List<String> sauce=new ArrayList<>();

    private List<String> topping=new ArrayList<>();

    private String side;

    private  Boolean liquid;


    public ResponseUserDTO FromEntity(UserMenuEntity user) {
     return  new ResponseUserDTO(
             user.getUserId(),
             user.getAge(),
             user.getMenuName(),
             user.getNickname(),
             user.getMenuImage(),
             user.getBread(),
             user.getSauce(),
             user.getTopping(),
             user.getSide(),
             user.getLiquid());
    }

}
