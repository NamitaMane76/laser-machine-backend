package com.laserhub.lasermachinebackend;

import com.laserhub.lasermachinebackend.model.Admin;
import com.laserhub.lasermachinebackend.model.UseCase;
import com.laserhub.lasermachinebackend.repository.AdminRepository;
import com.laserhub.lasermachinebackend.repository.UseCaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UseCaseRepository useCaseRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UseCaseRepository useCaseRepository,
                      AdminRepository adminRepository,
                      PasswordEncoder passwordEncoder) {
        this.useCaseRepository = useCaseRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (useCaseRepository.count() == 0) {
            useCaseRepository.save(new UseCase(null,
                    "Jewelry Engraving",
                    "Precision laser engraving on gold, silver, and gemstones for custom jewelry designs.",
                    "Jewelry",
                    "https://placehold.co/400x300?text=Jewelry+Engraving"));

            useCaseRepository.save(new UseCase(null,
                    "Acrylic Sign Cutting",
                    "Clean, sharp cuts for storefront signage and architectural displays.",
                    "Retail",
                    "https://placehold.co/400x300?text=Acrylic+Signs"));

            useCaseRepository.save(new UseCase(null,
                    "Medical Device Marking",
                    "Permanent, biocompatible marking on surgical instruments for traceability.",
                    "Medical",
                    "https://placehold.co/400x300?text=Medical+Marking"));

            useCaseRepository.save(new UseCase(null,
                    "Industrial Metal Cutting",
                    "High-precision cutting of steel and aluminum sheets for manufacturing.",
                    "Industrial",
                    "https://placehold.co/400x300?text=Metal+Cutting"));

            useCaseRepository.save(new UseCase(null,
                    "Leather Art Engraving",
                    "Intricate decorative patterns engraved into leather goods and accessories.",
                    "Art",
                    "https://placehold.co/400x300?text=Leather+Art"));

            System.out.println("Sample use cases seeded successfully!");
        }

        if (adminRepository.count() == 0) {
            Admin admin = new Admin(null, "admin", passwordEncoder.encode("admin123"));
            adminRepository.save(admin);
            System.out.println("Admin account seeded: username='admin' password='admin123'");
        }
    }
}