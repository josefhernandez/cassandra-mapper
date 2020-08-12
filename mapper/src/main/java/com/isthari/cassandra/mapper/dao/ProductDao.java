package com.isthari.cassandra.mapper.dao;
import java.util.UUID;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.isthari.cassandra.mapper.data.Product;

@Dao
public interface ProductDao {
  @Select
  Product findById(UUID productId);

  @Insert
  void save(Product product);

  @Delete
  void delete(Product product);
}