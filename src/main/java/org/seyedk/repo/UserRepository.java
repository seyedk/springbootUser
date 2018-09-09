package org.seyedk.repo;

import org.seyedk.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@EnableRdsInstance(dbInstanceIdentifier = "tedefault", password = "Race2Win")
public interface UserRepository extends JpaRepository<User,Long>{
    User findUserById(Long id);
}
