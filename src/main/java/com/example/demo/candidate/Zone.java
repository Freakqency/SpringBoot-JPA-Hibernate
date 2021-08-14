package com.example.demo.candidate;

import javax.persistence.*;

@Entity
@Table(name = "ZONE")
public class Zone {
    @Id
    @SequenceGenerator(name = "zone_sequence", sequenceName = "zone_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "zone_sequence"
    )
    @Column(name = "znId")
    private int znId;
    private String name;

    public Zone(String name) {
        this.name = name;
    }

    public Zone(int znId, String name) {
        this.znId = znId;
        this.name = name;
    }

    public Zone() {
    }

    public int getZnId() {
        return znId;
    }

    public void setZnId(int znId) {
        this.znId = znId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}