package com.example.demo.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){this.candidateService = candidateService;}

    @PostMapping
    public void addCandidate(@RequestBody String data) {
        candidateService.dataHelper(data);
    }

    @GetMapping
    public List<Candidate> getCandidateByZone(@RequestBody Zone zone) {
        return candidateService.getCandidateByZone(zone);
    }
}
