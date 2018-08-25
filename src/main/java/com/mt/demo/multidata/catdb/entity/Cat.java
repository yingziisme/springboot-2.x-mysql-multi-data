package com.mt.demo.multidata.catdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Cat
 *
 * @author MT.LUO
 * 2018/8/22 11:36
 * @Description:
 */
@Data
@Entity
@Table(name="cat_tb")
public class Cat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer relation;
    private String catName;
}
