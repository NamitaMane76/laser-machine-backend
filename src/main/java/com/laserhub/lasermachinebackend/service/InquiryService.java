package com.laserhub.lasermachinebackend.service;

import com.laserhub.lasermachinebackend.model.Inquiry;
import com.laserhub.lasermachinebackend.repository.InquiryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public Inquiry createInquiry(Inquiry inquiry) {
        inquiry.setSubmittedAt(LocalDateTime.now());
        return inquiryRepository.save(inquiry);
    }

    public boolean deleteInquiry(Long id) {
        if (inquiryRepository.existsById(id)) {
            inquiryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}