package com.group.genshinProg.repositories;

import com.group.genshinProg.model.entity.PrayResult;
import com.group.genshinProg.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
