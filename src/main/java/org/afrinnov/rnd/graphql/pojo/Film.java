package org.afrinnov.rnd.graphql.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Film {
    private String title;
    private Integer episodeID;
    private String director;
    private LocalDate releaseDate;
}
