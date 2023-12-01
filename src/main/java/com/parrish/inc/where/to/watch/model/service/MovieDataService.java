package com.parrish.inc.where.to.watch.model.service;

import com.parrish.inc.where.to.watch.model.exception.RecordNotFoundException;
import com.parrish.inc.where.to.watch.model.entity.MovieDataEntity;
import com.parrish.inc.where.to.watch.model.repository.MovieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieDataService {

    @Autowired
    MovieDataRepository repository;

    public List<MovieDataEntity> getAllMovieData()
    {
        List<MovieDataEntity> movieDataList = repository.findAll();

        if(movieDataList.size() > 0) {
            return movieDataList;
        } else {
            return new ArrayList<MovieDataEntity>();
        }
    }

    public MovieDataEntity getMovieDataById(Long id) throws RecordNotFoundException
    {
        Optional<MovieDataEntity> movieData = repository.findById(id);

        if(movieData.isPresent()) {
            return movieData.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id",id);
        }
    }

    public MovieDataEntity createOrUpdateMovieData(MovieDataEntity entity) throws RecordNotFoundException
    {
        if(entity.getId()!=null)
        {
            Optional<MovieDataEntity> movieData = repository.findById(entity.getId());

            if(movieData.isPresent())
            {
                MovieDataEntity newEntity = movieData.get();
                newEntity.setMovieDate(entity.getMovieDate());
                newEntity.setMovieName(entity.getMovieName());
                newEntity.setMovieStreamingLocations(entity.getMovieStreamingLocations());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
        else
        {
            entity = repository.save(entity);
            return entity;
        }
    }

    public void deleteMovieDataById(Long id) throws RecordNotFoundException
    {
        Optional<MovieDataEntity> movieData = repository.findById(id);

        if(movieData.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }
}
