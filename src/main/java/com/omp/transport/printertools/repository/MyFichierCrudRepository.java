package com.omp.transport.printertools.repository;

import com.omp.transport.printertools.model.MyFichier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyFichierCrudRepository extends CrudRepository<MyFichier, Long> {

    //@Query("select c from Customer c where c.email = :email")
    /*@Query("UPDATE FICHIER SET FICHIER_CONTENU = :contenu WHERE ID_FICHIER = :id_fichier")
    void stockerFicher(String email);*/

}
