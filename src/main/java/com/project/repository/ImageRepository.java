package com.project.repository;

import com.project.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, String> {
    List<Image> findAllByProductId(String productId);
}
