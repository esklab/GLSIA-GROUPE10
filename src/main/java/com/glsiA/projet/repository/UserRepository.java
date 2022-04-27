package com.glsiA.projet.repository;

import com.glsiA.projet.models.Produit;
import com.glsiA.projet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);

}
