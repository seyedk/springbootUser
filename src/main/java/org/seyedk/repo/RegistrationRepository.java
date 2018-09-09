/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:15 PM. Last Modified 9/7/18 9:21 AM. Please use as is under your own discretion.
 */

package org.seyedk.repo;


import org.seyedk.domain.RegistrationRecord;
import org.springframework.data.jpa.repository.JpaRepository;



//The registration Jpa Repository to encapsulate the data access operations for a registration record.

public interface RegistrationRepository extends JpaRepository<RegistrationRecord,Long> {

}
