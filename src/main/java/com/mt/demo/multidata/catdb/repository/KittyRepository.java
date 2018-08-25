package com.mt.demo.multidata.catdb.repository;

import com.mt.demo.multidata.catdb.entity.Cat;
import com.mt.demo.multidata.catdb.entity.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * CatRepository
 *
 * @author MT.LUO
 * 2018/8/22 11:37
 * @Description:
 */
public interface KittyRepository extends JpaRepository<Kitty, Integer>, JpaSpecificationExecutor<Kitty>, Serializable {

}
