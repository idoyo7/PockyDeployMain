package pockyProject.server.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import pockyProject.server.controller.converter.StringListConvert;

import java.util.List;

@Entity
@Table(name = "recommend")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    @Column(name = "menuname")
    private String menuName;


    @Column(name = "menuimage")
    private int menuImage;

    @Column(name = "bread")
    @Nullable
    private String bread;


    @Column(name = "topping")
    @Convert(converter = StringListConvert.class)
    private List<String> topping;


    @Column(name = "sauce")
    @Convert(converter = StringListConvert.class)
    private List<String> sauce;



}
