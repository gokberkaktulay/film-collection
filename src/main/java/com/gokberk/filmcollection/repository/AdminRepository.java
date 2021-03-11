package com.gokberk.filmcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gokberk.filmcollection.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
