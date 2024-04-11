package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Team;
import com.example.jpa.entity.TeamMember;

@SpringBootTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Test
    public void insertTest() {
        // 외래키 제약조건 때문에 팀정보 삽입후 맴버정보를 삽입해야한다
        Team team1 = teamRepository.save(Team.builder().id("team 1").name("팀 1").build());
        Team team2 = teamRepository.save(Team.builder().id("team 2").name("팀 2").build());
        Team team3 = teamRepository.save(Team.builder().id("team 3").name("팀 3").build());

        // TeaMember 에 Team 정보를 넣어줘야 하므로 팀정보를 먼저 삽입후 팀정보를 삽입한다
        teamMemberRepository.save(TeamMember.builder().id("member 1").userName("홍길동").team(team1).build());
        teamMemberRepository.save(TeamMember.builder().id("member 2").userName("고길동").team(team1).build());
        teamMemberRepository.save(TeamMember.builder().id("member 3").userName("김길동").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member 4").userName("이길동").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member 5").userName("박길동").team(team3).build());
    }

    @Test
    public void getRowTest() {
        TeamMember teamMember = teamMemberRepository.findById("member 1").get();
        // @ManyToOne 은 기본으로 FetchType.EAGER 때문에 N쪽 조회시 1에 해당하는 정보도 가져온다
        // TeamMember(id=member 1, userName=홍길동, team=Team(id=team 1, name=팀 1))
        System.out.println(teamMember);

        // 객체 그래프 탐색 : 연관관계 라면 요소에 접근이 가능하다
        System.out.println(teamMember.getTeam()); // Team(id=team 1, name=팀 1)
        System.out.println(teamMember.getTeam().getName()); // 팀 1

        // 멤버 조회시 같은 팀에 소속된 멤버와 팀 조회
        // TeamMember(id=member 3, userName=김길동, team=Team(id=team 2, name=팀 2))
        // TeamMember(id=member 4, userName=이길동, team=Team(id=team 2, name=팀 2))
        teamMemberRepository.findByMemberEqualTeam("팀 2").forEach(member -> {
            System.out.println(member);
        });
    }

    @Test
    public void updateTest() {
        // 멤버의 팀을 변경
        // 수정할 회원을 먼저 조회한다
        TeamMember member = teamMemberRepository.findById("member 1").get();
        // 팀이 객체이기 때문에 객체를 만들고 값을 넣어준다
        Team team = Team.builder().id("team 3").build();
        member.setTeam(team);
        System.out.println("수정 후 " + teamMemberRepository.save(member));

    }

    @Test
    public void deleteTest() {
        // 팀을 삭제하려면 우선 멤버를 먼저 삭제해야 한다 (자식 먼저 삭제)
        teamMemberRepository.deleteById("member 5");
        teamMemberRepository.deleteById("member 1");
        // 그리고 팀 삭제 (부모 삭제)
        teamRepository.deleteById("team 3");
    }

    @Transactional
    @Test
    public void getRowTest2() {
        Team team = teamRepository.findById("team 2").get();
        System.out.println(team); // Team(id=team 2, name=팀 2)

        team.getTeamMember().forEach(member -> System.out.println(member));
        // TeamMember(id=member 3, userName=김길동, team=Team(id=team 2, name=팀 2))
        // TeamMember(id=member 4, userName=이길동, team=Team(id=team 2, name=팀 2))
    }
}
