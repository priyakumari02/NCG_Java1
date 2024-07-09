package com.adobe.mappingexample.service;

import com.adobe.mappingexample.dao.ActorDao;
import com.adobe.mappingexample.dao.MovieDao;
import com.adobe.mappingexample.entity.Actor;
import com.adobe.mappingexample.entity.Movie;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieDao movieDao;
    private final ActorDao actorDao;

    @Transactional
    public void addMovieWithActors(Movie movie) {
        movieDao.save(movie); //Cascade saves actors also
    }


    public Actor getActor(int id) {
        Optional<Actor> opt =  actorDao.findById(id);
        if(opt.isPresent()) {
            return  opt.get();
        } else {
            return null;
        }
    }

    public  Movie getMovie(int id) {
        Optional<Movie> opt =  movieDao.findById(id);
        if(opt.isPresent()) {
            return  opt.get();
        } else {
            return null;
        }
    }

    @Transactional
    public void assignActorToMovie(int movieId, int actorId) {
        Movie m = movieDao.findById(movieId).get();
        Actor actor = actorDao.findById(actorId).get();
        m.getActors().add(actor); // Dirty Checking -> UPDATE
    }

    public Actor saveActor(Actor actor) {
       return actorDao.save(actor);
    }
}
