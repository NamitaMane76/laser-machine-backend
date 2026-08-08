package com.laserhub.lasermachinebackend.repository;

import com.laserhub.lasermachinebackend.model.UseCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseCaseRepository extends JpaRepository<UseCase, Long> {

    List<UseCase> findByIndustry(String industry);
}