package com.seagrey.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //实体类间关系
    //type 一, blog 多
    //One一端为关系被维护端
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
