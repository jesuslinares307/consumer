package com.example.consumer.services;

import com.example.consumer.dtos.FoodOrderDto;
import com.example.consumer.models.FoodOrder;
import com.example.consumer.repositories.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository, ModelMapper modelMapper) {
        this.foodOrderRepository = foodOrderRepository;
        this.modelMapper = modelMapper;
    }

    public void persistFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", persistedFoodOrder);
    }

}