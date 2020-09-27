package com.musicstore.jpa;

import com.musicstore.model.Album;
import org.springframework.data.repository.CrudRepository;


public interface JpaMusicStoreRepository extends CrudRepository<Album, Long> {
}