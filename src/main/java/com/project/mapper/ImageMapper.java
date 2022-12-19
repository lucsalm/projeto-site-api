package com.project.mapper;

import com.project.model.Image;

public class ImageMapper {

    public static Image createImage(String productId, String image){
        Image imageObject = new Image();
        imageObject.setImage(image);
        imageObject.setProductId(productId);
        return imageObject;
    }
}
