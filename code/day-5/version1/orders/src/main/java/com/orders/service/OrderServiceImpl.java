package com.orders.service;

import com.orders.dto.OrderDto;
import com.orders.entities.Order;
import com.orders.repo.OrderRepository;
import com.orders.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrderDto placeOrder(OrderDto orderDto) {
        Order order = ConversionUtil.orderDtoToOrder(orderDto);
        orderRepository.save(order);
        return ConversionUtil.orderToOrderDto(order);
    }
}