package com.laserhub.lasermachinebackend.controller;

import com.laserhub.lasermachinebackend.model.UseCase;
import com.laserhub.lasermachinebackend.service.UseCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usecases")
@CrossOrigin(origins = "*")
public class UseCaseController {

    private final UseCaseService useCaseService;

    public UseCaseController(UseCaseService useCaseService) {
        this.useCaseService = useCaseService;
    }

    @GetMapping
    public List<UseCase> getAllUseCases(@RequestParam(required = false) String industry) {
        if (industry != null && !industry.isEmpty()) {
            return useCaseService.getUseCasesByIndustry(industry);
        }
        return useCaseService.getAllUseCases();
    }

    @GetMapping("/{id}")
    public UseCase getUseCaseById(@PathVariable Long id) {
        return useCaseService.getUseCaseById(id);
    }

    @PostMapping
    public UseCase createUseCase(@RequestBody UseCase useCase) {
        return useCaseService.createUseCase(useCase);
    }

    @PutMapping("/{id}")
    public UseCase updateUseCase(@PathVariable Long id, @RequestBody UseCase useCase) {
        return useCaseService.updateUseCase(id, useCase);
    }

    @DeleteMapping("/{id}")
    public String deleteUseCase(@PathVariable Long id) {
        boolean deleted = useCaseService.deleteUseCase(id);
        return deleted ? "Deleted successfully" : "Use case not found";
    }
}