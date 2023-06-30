package com.baitaplon.bookstore.model.entity;

import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    //@JsonBackReference
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    //@JsonBackReference
    private UserEntity user;

    @Column(name = "rate")
    private int rate;

    @Nationalized
    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date createdDate;
}
