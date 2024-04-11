package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "teamMember")
@Setter
@Getter
@Entity
public class Team {

    @Column(name = "team_id")
    @Id
    private String id;

    @Column(name = "team_name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> teamMember = new ArrayList<>();
}
