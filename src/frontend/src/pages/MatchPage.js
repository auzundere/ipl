import React, {useEffect, useState} from 'react';
import {MatchDetailCard} from "../components/MatchDetailCard";
import {useParams} from "react-router-dom";
import './MatchPage.css';
import {YearSelector} from "../components/YearSelector";

export const MatchPage = (name, value) => {

    const [matches, setMatches] = useState([]);
    const {teamName, year} = useParams();

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
                const data = await response.json();
                setMatches(data);
            };
            fetchMatches().then(r => {
            });
        }, [teamName, year]
    );

    return (
        <div className="MatchPage">
            <div className="year-selector">
                <h3> Select Year </h3>
                <YearSelector teamName={teamName}/>
            </div>
            <div>
                <h1 className="page-heading">{teamName} in {year}</h1>
                {
                    matches.map(match => <MatchDetailCard teamName={teamName} match={match}
                                                          key={Math.floor(Math.random() * 1000000) + 1}/>)
                }
            </div>
        </div>
    );
}
