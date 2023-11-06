package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    //TODO
    String author;
    String content;

    public CommentImpl(String author,String content){
        setContent(content);
        this.author = author;
    }

    private void setContent(String content) {
        ValidationHelpers.validateStringLength(content,CONTENT_LEN_MIN,CONTENT_LEN_MAX,CONTENT_LEN_ERR);
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("""
                 %s
                User: %s
                """,getContent(),getAuthor());
    }
}