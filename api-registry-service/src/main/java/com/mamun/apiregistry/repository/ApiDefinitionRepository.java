package com.mamun.apiregistry.repository;


import com.mamun.apiregistry.model.ApiDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiDefinitionRepository extends JpaRepository<ApiDefinition, Long> {
}
