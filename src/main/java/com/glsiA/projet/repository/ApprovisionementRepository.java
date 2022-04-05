package com.glsiA.projet.repository;



import com.glsiA.projet.models.Approvisionement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ApprovisionementRepository  extends JpaRepository<Approvisionement, Integer> {


    @Modifying
    @Transactional
    @Query(value = "update Produit a set a.qteStok = a.qteStok + :quantite where a.id = :id")
    void updateProduit(@Param("id") Integer id, @Param("quantite") int quantite);


}
