package com.sofka.davs.socialMediaBack.post.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlPostRepository extends JpaRepository<Post, Integer> {
}
