/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:15 PM. Last Modified 9/3/18 8:43 PM. Please use as is under your own discretion.
 */

package org.seyedk.repo;

import org.seyedk.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@EnableRdsInstance(dbInstanceIdentifier = "tedefault", password = "Race2Win")
public interface UserRepository extends JpaRepository<User,Long>{
    User findUserById(Long id);
}
