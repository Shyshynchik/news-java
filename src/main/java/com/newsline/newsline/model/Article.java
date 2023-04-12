package com.newsline.newsline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newsline.newsline.utils.deserializer.IntegerDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "articles", schema = "public", catalog = "news")
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title", nullable = false)
    @NotNull(message = "title must be written")
    @JsonProperty("title")
    private String title;

    @Basic
    @Column(name = "date")
    @JsonProperty("date")
    private Date date;
    @Basic
    @Column(name = "annotation")
    @JsonProperty("annotation")
    private String annotation;
    @Basic
    @Column(name = "body")
    @JsonProperty("body")
    private String body;
    @Basic
    @Column(name = "counter")
    @JsonProperty(value = "counter")
    @JsonDeserialize(using = IntegerDeserializer.class)
    private Integer counter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article that = (Article) o;

        if (id != that.id) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(annotation, that.annotation)) return false;
        if (!Objects.equals(body, that.body)) return false;
        return Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (counter != null ? counter.hashCode() : 0);
        return result;
    }

}
