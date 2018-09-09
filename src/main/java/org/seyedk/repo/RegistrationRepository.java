package org.seyedk.repo;


import org.seyedk.domain.RegistrationRecord;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RegistrationRepository extends JpaRepository<RegistrationRecord,Long> {

}
