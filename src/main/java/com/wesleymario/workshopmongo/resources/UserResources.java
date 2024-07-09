package com.wesleymario.workshopmongo.resources;

import com.wesleymario.workshopmongo.domain.User;
import com.wesleymario.workshopmongo.dto.UserDTO;
import com.wesleymario.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> user = service.findAll();
        List<UserDTO> listDTO = user.stream()
                .map(UserDTO::new)
                .toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity <UserDTO> findbyId(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
