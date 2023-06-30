package com.baitaplon.bookstore.model.entity;

import com.baitaplon.bookstore.model.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50, columnDefinition = "nvarchar(150)")
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<BookEntity> bookEntities = new ArrayList<>();

}
