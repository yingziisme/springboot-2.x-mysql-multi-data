package com.mt.demo.multidata.catdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Kitty
 *
 * @author MT.LUO
 * 2018/8/23 10:22
 * @Description:
 */
@Data
@Entity
@Table(name="kitty_tb")
public class Kitty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer relation;
    private String kittyName;
}
