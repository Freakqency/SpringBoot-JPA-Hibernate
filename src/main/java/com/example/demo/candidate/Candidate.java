package com.example.demo.candidate;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @SequenceGenerator(name = "candidate_sequence", sequenceName = "candidate_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator ="candidate_sequence"
    )
    private int Cand_id;
    private String CandidateName;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "znId")
    private Zone zone;

    public Candidate(int cand_id, String candidateName, Zone zone) {
        Cand_id = cand_id;
        CandidateName = candidateName;
        this.zone = zone;
    }

    public Candidate(String candidateName, Zone zone) {
        CandidateName = candidateName;
        this.zone = zone;
    }

    public Candidate() {
    }

    public int getCand_id() {
        return Cand_id;
    }

    public void setCand_id(int cand_id) {
        Cand_id = cand_id;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
