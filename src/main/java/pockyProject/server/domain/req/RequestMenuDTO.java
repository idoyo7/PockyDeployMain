package pockyProject.server.domain.req;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pockyProject.server.entity.RecommendEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor

public class RequestMenuDTO {


    private  String  userId;

    private  int menuImage;


    private  int age;

    private  String nickname;

    private  String bread;

    private List<String> sauce=new ArrayList<>();

    private List<String> topping=new ArrayList<>();




    public RequestMenuDTO(RecommendEntity user) {

        menuImage=user.getMenuImage();
        age=user.getAge();
        bread=user.getBread();
        topping=user.getTopping();
        sauce=user.getSauce();
    }

}
