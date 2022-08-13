package com.sofka.davs.socialMediaBack.userlike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlUserLikeRepository extends JpaRepository<UserLike, Integer> {
}
