package com.mongo.faiz.controller;

import com.mongo.faiz.entity.Book;
import com.mongo.faiz.repository.BookRepo;
import org.bson.json.JsonWriterSettings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@RestController

public class BookController {


    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    BookRepo repo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        mongoTemplate.save(book);

        return "Added Successfully";
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        try {
            return mongoTemplate.findAll(Book.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/findAllDocuments")
    public List<Document> getDocuments() {
        try {
            return mongoTemplate.findAll(Document.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Document>();
        }
    }

    @GetMapping(value = "/url",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRawData() {
        ProjectionOperation project = project().andExclude("ok");
        Aggregation aggregate = newAggregation(project);
        AggregationResults<JSONObject> aggregationResult = mongoTemplate.aggregate(aggregate, "Book", JSONObject.class);
        org.bson.Document doc = aggregationResult.getRawResults();
        String docString = doc.toJson(JsonWriterSettings
                .builder()
                .build());
        return docString;
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        Book book = mongoTemplate.findById(id, Book.class);
        mongoTemplate.remove(book);
        return "Deleted Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}