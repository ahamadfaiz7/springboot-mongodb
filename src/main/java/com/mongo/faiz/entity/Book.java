package com.mongo.faiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Book")

public class Book {
    @Id
    private Integer id;
    private String bookName;
    private String authorName;
    private String goodName;
    private String _class;
    private Address address;
}
