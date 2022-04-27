package com.java.tp1.repository;


import com.java.tp1.modele.Approvisionement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionementRepository  extends JpaRepository<Approvisionement, Integer> {
}
