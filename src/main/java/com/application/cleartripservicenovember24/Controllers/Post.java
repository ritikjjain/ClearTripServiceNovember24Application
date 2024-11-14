package com.application.cleartripservicenovember24.Controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private static int postCount = 0;
    private String postId;
    private User user;
    private String content;
    private LocalDateTime timestamp;
    private int likes;
    private int dislikes;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
        this.postId = String.format("%03d", ++postCount);
    }

    public String getPostId() {
        return postId;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public String getRelativeTime() {
        LocalDateTime now = LocalDateTime.now();
        long minutes = java.time.Duration.between(timestamp, now).toMinutes();
        if (minutes < 60) {
            return minutes + "m ago";
        }
        long hours = java.time.Duration.between(timestamp, now).toHours();
        return hours + " hr ago";
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }
}

