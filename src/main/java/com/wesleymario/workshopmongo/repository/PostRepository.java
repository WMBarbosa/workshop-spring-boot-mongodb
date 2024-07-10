package com.wesleymario.workshopmongo.repository;

import com.wesleymario.workshopmongo.domain.Post;
import com.wesleymario.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
