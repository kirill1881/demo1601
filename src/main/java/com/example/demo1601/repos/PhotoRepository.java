package com.example.demo1601.repos;

import com.example.demo1601.models.PhotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoModel, Long> {
    PhotoModel findById(long id);
    List<PhotoModel> findAllByAuthorId(long authorId);
}
