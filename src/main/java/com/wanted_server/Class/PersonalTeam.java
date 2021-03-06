package com.wanted_server.Class;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PersonalTeam {

    @Id
    @GeneratedValue
    @Column(name = "personal_team_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    //== 생성 메서드 ==//
    static public PersonalTeam createPersonalTeam(Team team) {
        PersonalTeam personalTeam = new PersonalTeam();
        team.addPersonalTeam(personalTeam);
        return personalTeam;
    }

    @Override
    public String toString() {
        return "PersonalTeam{" +
                "id=" + id +
                ", personal=" + personal.getId() +
                ", team=" + team.getId() +
                '}';
    }
}
