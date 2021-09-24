package com.geekseat.theta.repository;

import com.geekseat.theta.model.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {
}
