package com.wesleymario.workshopmongo.services;


import com.wesleymario.workshopmongo.domain.Post;
import com.wesleymario.workshopmongo.domain.User;
import com.wesleymario.workshopmongo.dto.UserDTO;
import com.wesleymario.workshopmongo.repository.PostRepository;
import com.wesleymario.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
