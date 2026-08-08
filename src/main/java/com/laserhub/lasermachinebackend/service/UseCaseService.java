package com.laserhub.lasermachinebackend.service;

import com.laserhub.lasermachinebackend.model.UseCase;
import com.laserhub.lasermachinebackend.repository.UseCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseCaseService {

    private final UseCaseRepository useCaseRepository;

    public UseCaseService(UseCaseRepository useCaseRepository) {
        this.useCaseRepository = useCaseRepository;
    }

    public List<UseCase> getAllUseCases() {
        return useCaseRepository.findAll();
    }

    public List<UseCase> getUseCasesByIndustry(String industry) {
        return useCaseRepository.findByIndustry(industry);
    }

    public UseCase getUseCaseById(Long id) {
        return useCaseRepository.findById(id).orElse(null);
    }

    public UseCase createUseCase(UseCase useCase) {
        return useCaseRepository.save(useCase);
    }

    public UseCase updateUseCase(Long id, UseCase updatedUseCase) {
        UseCase existing = useCaseRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setTitle(updatedUseCase.getTitle());
        existing.setDescription(updatedUseCase.getDescription());
        existing.setIndustry(updatedUseCase.getIndustry());
        existing.setImageUrl(updatedUseCase.getImageUrl());
        return useCaseRepository.save(existing);
    }

    public boolean deleteUseCase(Long id) {
        if (useCaseRepository.existsById(id)) {
            useCaseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}