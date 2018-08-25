package com.mt.demo.multidata.aaadb.repository;

import com.mt.demo.multidata.aaadb.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * CatRepository
 *
 * @author MT.LUO
 * 2018/8/22 11:37
 * @Description:
 */
public interface DogRepository extends JpaRepository<Dog, Integer>, JpaSpecificationExecutor<Dog>, Serializable {
}
