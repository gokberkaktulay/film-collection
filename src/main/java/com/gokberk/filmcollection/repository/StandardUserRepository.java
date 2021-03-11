package com.gokberk.filmcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gokberk.filmcollection.model.StandardUser;

public interface StandardUserRepository extends JpaRepository<StandardUser, String> {

}
