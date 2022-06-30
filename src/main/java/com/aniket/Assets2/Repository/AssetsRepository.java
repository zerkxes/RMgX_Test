package com.aniket.Assets2.Repository;
import com.aniket.Assets2.entity.Assets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssetsRepository extends CrudRepository<Assets, Long>{
	Assets findByName(String name);
}