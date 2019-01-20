package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.document.Playlist;

public interface PlaylistRespository extends ReactiveMongoRepository<Playlist, String>{

}
