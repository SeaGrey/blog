package com.seagrey.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickName;
    private String email;
    private String content;
    //头像
    private String avatar;
    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne()
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;
}

