package fi.haagahelia.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer categoryId;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category: " + this.name;
    }
}
