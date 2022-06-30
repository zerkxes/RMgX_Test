package com.aniket.Assets2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aniket.Assets2.entity.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
