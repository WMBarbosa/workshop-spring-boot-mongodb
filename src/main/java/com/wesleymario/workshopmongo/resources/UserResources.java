package com.wesleymario.workshopmongo.resources;

import com.wesleymario.workshopmongo.domain.User;
import com.wesleymario.workshopmongo.dto.UserDTO;
import com.wesleymario.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> insert (@RequestBody UserDTO dto){
        User user = service.fromDTO(dto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO dto){
        User user = service.fromDTO(dto);
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }
}
