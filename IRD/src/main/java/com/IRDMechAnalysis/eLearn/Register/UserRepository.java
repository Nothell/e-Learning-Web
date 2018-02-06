package com.IRDMechAnalysis.eLearn.Register;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Long> {

 List<UserInfo> findByName(String name);

}
