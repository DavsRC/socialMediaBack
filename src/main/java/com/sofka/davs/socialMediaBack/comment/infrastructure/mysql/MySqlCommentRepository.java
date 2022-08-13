package com.sofka.davs.socialMediaBack.comment.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlCommentRepository extends JpaRepository<Comment, Integer> {

}
