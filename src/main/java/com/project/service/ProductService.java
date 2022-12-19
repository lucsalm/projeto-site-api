package com.project.service;


import com.project.mapper.ImageMapper;
import com.project.model.Image;
import com.project.model.Product;
import com.project.repository.ImageRepository;
import com.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final static Integer DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;


    public Mono<Page<Product>> findProductsByPage(Integer page) {
        return Mono.just(productRepository.findAll(PageRequest.of(page, DEFAULT_PAGE_SIZE)).map(product -> {
            List<String> images = imageRepository.findAllByProductId(product.getProductId())
                    .stream().map(Image::getImage).collect(Collectors.toList());

            product.setImages(!images.isEmpty() ? List.of(images.get(0)): new ArrayList<>());

            return product;
        }));
    }

    public Mono<Object> addProduct(Product product) {
        return Mono.just(productRepository.save(product).getProductId())
                .flatMap(productId -> {

                    List<Image> images = product.getImages().stream().map(image ->
                            ImageMapper.createImage(productId, image)
                    ).collect(Collectors.toList());

                    imageRepository.saveAll(images);
                    return Mono.empty();
                });
    }
}
