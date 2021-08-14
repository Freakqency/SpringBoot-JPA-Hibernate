package com.example.demo.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository ;
    private final ZoneRepository zoneRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, ZoneRepository zoneRepository){
        this.candidateRepository = candidateRepository;
        this.zoneRepository = zoneRepository;
    }


    public void addZone(String zoneName) {
        Zone zone = new Zone(zoneName);
        zoneRepository.save(zone);
    }

    public Zone getZoneId(String zoneName){
        return zoneRepository.findByName(zoneName);
    }

    public void addCandidate(String name, Zone zone) {
        Candidate candidate = new Candidate(name, zone);
        candidateRepository.save(candidate);
    }

    public void dataHelper(String data) {
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(data);
        ArrayList<String> arr = new ArrayList<String>();
        while (m.find()) {
            arr.add(m.group(1));
        }
        addZone(arr.get(0));
        addZone(arr.get(5));
        addZone(arr.get(9));
        addZone(arr.get(13));
        for (int i = 0; i < arr.size(); i++) {
            if (i < 6 && i != 0 && i != 5) {
                addCandidate(arr.get(i), getZoneId(arr.get(0)));
            }
            if (i > 5 && i < 10 && i != 5 && i != 9) {
                addCandidate(arr.get(i), getZoneId(arr.get(5)));
            }
            if (i > 9 && i < 14 && i != 9 && i != 13) {
                addCandidate(arr.get(i), getZoneId(arr.get(9)));
            }
            if (i > 13 ) {
                addCandidate(arr.get(i), getZoneId(arr.get(13)));
            }
        }
    }

    public List<Candidate> getCandidateByZone(Zone zone) {
        Zone reqZone = getZoneId(zone.getName());
        List<Candidate> candidates= candidateRepository.findByZone(reqZone);
        return candidates;
    }
}
