package com.sofka.davs.socialMediaBack.userlike.infrastructure.mysql;

import com.sofka.davs.socialMediaBack.userlike.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlUserLikeRepository extends JpaRepository<UserLike, Integer> {
}
