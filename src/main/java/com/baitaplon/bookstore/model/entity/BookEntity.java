package com.baitaplon.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(150)")
    private String name;

    @Column(name = "title", columnDefinition = "nvarchar(150)")
    private String title;

    @Column(name = "author", columnDefinition = "nvarchar(150)")
    private String author;
    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "total_page")
    private Integer total_page;

    @Column(name = "image", columnDefinition = "varchar(150)")
    private String image;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private Integer status;
    @Column(name = "des", columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    //@JsonBackReference
    private CategoryEntity category;

    private int available;

    @OneToMany(mappedBy = "book")
   // @JsonManagedReference
    private List<OrderDetailEntity> listOrderDetail;

    @OneToMany(mappedBy = "book")
    //@JsonManagedReference
    private List<ReviewEntity> reviewList = new ArrayList<>();
}
