package com.entrajuda.museu.image;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findById(Integer image_id);
}