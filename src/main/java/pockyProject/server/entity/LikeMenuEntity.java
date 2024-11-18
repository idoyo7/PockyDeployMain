package pockyProject.server.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import pockyProject.server.controller.converter.StringListConvert;
import pockyProject.server.domain.res.ResponseLikedMenuDTO;

import java.util.List;

@Entity
@Table(name ="likemenu")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeMenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  int age;

    @Column(name = "user_id")
    @Nullable
    private String userId;

    @Column(name = "menuname")
    private String menuName;

    @Column(name = "nickname")
    @Nullable
    private String nickname;

    @Column(name = "menuimage")
    private int menuImage;

    @Column(name = "topping")
    @Convert(converter = StringListConvert.class)
    private List<String> topping;

    @Column(name = "bread")
    private String bread;


    @Column(name = "sauce")
    @Convert(converter = StringListConvert.class)
    private List<String> sauce;


    public static LikeMenuEntity EntityFromLikeDTO(ResponseLikedMenuDTO userDto) {
        LikeMenuEntity LikeEntity = LikeMenuEntity.builder()
                .userId(userDto.getUserId())
                .nickname(userDto.getNickname())
                .topping(userDto.getTopping())
                .bread(userDto.getBread())
                .sauce(userDto.getSauce())
                .menuImage(userDto.getMenuImage())
                .build();
        return LikeEntity;
    }
}
