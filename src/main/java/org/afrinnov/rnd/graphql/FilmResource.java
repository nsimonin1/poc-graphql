package org.afrinnov.rnd.graphql;

import org.afrinnov.rnd.graphql.pojo.Film;
import org.afrinnov.rnd.graphql.pojo.Hero;
import org.afrinnov.rnd.graphql.service.GalaxyService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@GraphQLApi
public class FilmResource {
    @Inject
    private GalaxyService galaxyService;

    @Query("allFilms")
    @Description("Get all Films from a galaxy far far away")
    public List<Film> getAllFilms() {
        return galaxyService.getAllFilms();
    }

    @Query
    public Film getFilm(@Name("filmId") int filmId) {
        return galaxyService.getFilm(filmId);
    }

    public List<Hero> heroes(@Source Film film) {
        return galaxyService.getHeroesByFilm(film);
    }

    public List<List<Hero>> heroes(@Source List<Film> films) {
        return films.stream()
                .map(film -> galaxyService.getHeroesByFilm(film))
                .collect(Collectors.toList());
    }
}