package com.mt.demo.multidata.catdb.repository;

import com.mt.demo.multidata.catdb.entity.Cat;
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
public interface CatRepository extends JpaRepository<Cat, Integer>, JpaSpecificationExecutor<Cat>, Serializable {

    String checkSql = "select c.id from Cat c, Kitty k where c.relation = k.relation";

    @Query(checkSql + " and c.id=?1")
    Optional<Integer> findOneById(Integer id);

    @Query(checkSql + " and c.id in ?1")
    List<Integer> findOneById(List<Integer> id);

    @Query(checkSql + " and c.id=?1 and c.relation in ?2")
    Optional<Integer> checkAuth(Integer id, List<Integer> groupId);

    @Query(checkSql + " and c.id in ?1 and c.relation in ?2")
    List<Integer> checkAuth(List<Integer> id, List<Integer> groupId);


    String baseSql = "select c from Cat c, Kitty k where c.relation = k.relation";
    @Query(baseSql + " and c.id in ?1 and c.relation in ?2")
    List<Cat> selectCat(List<Integer> id, List<Integer> groupId);
}
