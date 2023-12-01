package com.parrish.inc.where.to.watch.model.controller;
import java.util.List;

import com.parrish.inc.where.to.watch.model.exception.RecordNotFoundException;
import com.parrish.inc.where.to.watch.model.entity.MovieDataEntity;
import com.parrish.inc.where.to.watch.model.service.MovieDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieData")
public class MovieDataController
{
    @Autowired
    MovieDataService service;

    @GetMapping
    public ResponseEntity<List<MovieDataEntity>> getAllMovieData() {
        List<MovieDataEntity> list = service.getAllMovieData();

        return new ResponseEntity<List<MovieDataEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDataEntity> getMovieDataById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        MovieDataEntity entity = service.getMovieDataById(id);

        return new ResponseEntity<MovieDataEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDataEntity> createOrUpdateMovieData(@RequestBody MovieDataEntity movieData)
            throws RecordNotFoundException {
        MovieDataEntity updated = service.createOrUpdateMovieData(movieData);
        return new ResponseEntity<MovieDataEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteMovieDataById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteMovieDataById(id);
        return HttpStatus.FORBIDDEN;
    }

}