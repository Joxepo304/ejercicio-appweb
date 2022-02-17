package com.formacionspring.app.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.app.apirest.entity.Departamento;

@Repository
public interface DepartamentoDao extends JpaRepository<Departamento, Long>{

}
