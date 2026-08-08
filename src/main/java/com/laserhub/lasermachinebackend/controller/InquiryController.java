package com.laserhub.lasermachinebackend.controller;

import com.laserhub.lasermachinebackend.model.Inquiry;
import com.laserhub.lasermachinebackend.service.InquiryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "*")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping
    public List<Inquiry> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @PostMapping
    public Inquiry createInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.createInquiry(inquiry);
    }

    @DeleteMapping("/{id}")
    public String deleteInquiry(@PathVariable Long id) {
        boolean deleted = inquiryService.deleteInquiry(id);
        return deleted ? "Deleted successfully" : "Inquiry not found";
    }
}