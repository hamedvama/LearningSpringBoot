package com.omp.transport.printertools.repository;

import com.omp.transport.printertools.model.Cours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursCrudRepository extends CrudRepository <Cours, Long> {

}
