package com.sofka.davs.socialMediaBack.repository;

import com.sofka.davs.socialMediaBack.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*This interface use Jpa and Hibernate in the background to make the connexions
to our DB, and it has the implementation of the methods what we normally use
like, findAll, findAllById, saveAll, delete, get, etc. That why we extend
from that interface in order to absorb all that behaviors
 */
@Repository
public interface UserLikeRepository extends JpaRepository <UserLike, Integer> {
}
