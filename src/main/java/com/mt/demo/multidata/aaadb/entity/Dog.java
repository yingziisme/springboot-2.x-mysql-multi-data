package com.mt.demo.multidata.aaadb.entity;

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
@Table(name="dog_tb")
public class Dog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dogName;
}
