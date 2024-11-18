package pockyProject.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pockyProject.server.domain.req.RequestMenuDTO;
import pockyProject.server.domain.res.ResponseLikedMenuDTO;
import pockyProject.server.domain.res.ResponseUserDTO;
import pockyProject.server.domain.res.UserJoinDTO;
import pockyProject.server.entity.RecommendEntity;
import pockyProject.server.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    @GetMapping("/favor/getfavor")
    public List<RequestMenuDTO> getRecommendMenu(){
        List<RecommendEntity> user=userService.getRecommendList();
        List<RequestMenuDTO> result= user.stream()
                .map(o->new RequestMenuDTO(o))
                .collect(Collectors.toList());
        return result;
        
    }

    @PostMapping("/user/join")
    public void userJoin(@RequestBody UserJoinDTO userDTO){
             userService.joinUser(userDTO);
    }


    @PostMapping("/users/userpost")
    public ResponseEntity<ResponseUserDTO> saveUser(@RequestBody ResponseUserDTO userDto){

        ResponseUserDTO user=userService.saveUser(userDto);
        return  ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @PostMapping("/users/liked")
    public ResponseEntity<ResponseLikedMenuDTO> saveLikedMenu(@RequestBody ResponseLikedMenuDTO LikedMenuDto){

        ResponseLikedMenuDTO LikedUser=userService.saveLikedMenu(LikedMenuDto);
        return  ResponseEntity.status(HttpStatus.OK).body(LikedUser);
    }


    @DeleteMapping("/users/delete/{useruid}")
    public void deleteUser(@PathVariable("useruid") String userUid){

        userService.deleteUserInfo(userUid);
    }


}
