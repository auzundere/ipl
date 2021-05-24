package io.javabrains.apldashboard.repository;

import io.javabrains.apldashboard.module.Match;
import io.javabrains.apldashboard.module.Team;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    List<Match> getByTeam1AndDateIsBetweenOrTeam2AndDateIsBetweenOrderByDateDesc(
            String teamName1, LocalDate date1,
            LocalDate date2, String teamName2, LocalDate date3, LocalDate date4);
    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0,count));
    }

}
