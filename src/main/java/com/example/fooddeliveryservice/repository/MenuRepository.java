package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.Menu;
import com.example.fooddeliveryservice.entity.MenuProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(nativeQuery = true, value =("SELECT menu.restaurant_id FROM menu WHERE menu.price <= :maxPrice " +
            "AND menu.price >= :minPrice " +
            "GROUP BY menu.restaurant_id " +
            "HAVING COUNT(*) < :dishes"))
    List<Integer> findByPriceRangeLesser(@Param("maxPrice") Double maxPrice, @Param("minPrice") Double minPrice,
                                @Param("dishes") Integer dishes);

    @Query(nativeQuery = true, value =("SELECT menu.restaurant_id FROM menu WHERE menu.price <= :maxPrice " +
            "AND menu.price >= :minPrice " +
            "GROUP BY menu.restaurant_id " +
            "HAVING COUNT(*) > :dishes"))
    List<Integer> findByPriceRangeGreater(@Param("maxPrice") Double maxPrice, @Param("minPrice") Double minPrice,
                                   @Param("dishes") Integer dishes);

    @Query("SELECT menu FROM Menu menu WHERE menu.dishName LIKE %:searchTerm%")
    List<MenuProjection> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
