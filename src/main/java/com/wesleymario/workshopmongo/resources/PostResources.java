package com.wesleymario.workshopmongo.resources;

import com.wesleymario.workshopmongo.domain.Post;
import com.wesleymario.workshopmongo.domain.User;
import com.wesleymario.workshopmongo.dto.UserDTO;
import com.wesleymario.workshopmongo.repository.PostRepository;
import com.wesleymario.workshopmongo.resources.util.URL;
import com.wesleymario.workshopmongo.services.PostService;
import com.wesleymario.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        List<Post> list = service.findByTitle(title);
        return ResponseEntity.ok().body(list);
    }
}
