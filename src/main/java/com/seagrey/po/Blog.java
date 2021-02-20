package com.seagrey.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity//JPA,Hibernate,自动生成数据库
@Table(name = "t_blog")//指定数据库名称
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    //首图
    private String firstPicture;
    //标记
    private String flag;
    //浏览次数
    private Integer views;
    //赞赏(是否开启)
    private Boolean appreciation;
    //转载声明(是否开启)
    private Boolean shareStatement;
    //评论(是否开启)
    private Boolean commentAbled;
    //发布(草稿还是已发布状态)
    private Boolean pubished;
    //推荐(是否开启)
    private Boolean recommend;
    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    //实体类间关系
    //blog 多, type 一
    //Many一端为关系维护端
    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
}
