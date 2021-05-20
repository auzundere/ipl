package io.javabrains.apldashboard.repository;

import io.javabrains.apldashboard.module.Match;
import io.javabrains.apldashboard.module.Team;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0,count));
    }
}
