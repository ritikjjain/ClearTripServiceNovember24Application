package com.application.cleartripservicenovember24.Controllers;

import java.util.*;

public class SocialMediaApp {
    private Map<Integer, User> users;

    public SocialMediaApp() {
        this.users = new HashMap<>();
    }

    // Register a new user
    public void registerUser(int id, String name) {
        if (!users.containsKey(id)) {
            User newUser = new User(id, name);
            users.put(id, newUser);
            System.out.println(name + " Registered!!");
        } else {
            System.out.println("User ID already exists.");
        }
    }

    // Upload a post
    public void uploadPost(int userId, String content) {
        User user = users.get(userId);
        if (user != null) {
            Post post = new Post(user, content);
            user.addPost(post);
            System.out.println("Upload Successful with post id: " + post.getPostId());
        } else {
            System.out.println("User not found.");
        }
    }

    // Follow or Unfollow another user
    public void interactWithUser(String interactionType, int userId1, int userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        if (interactionType.equalsIgnoreCase("FOLLOW")) {
            user1.follow(user2);
            System.out.println("Followed " + user2.getName() + "!!");
        } else if (interactionType.equalsIgnoreCase("UNFOLLOW")) {
            user1.unfollow(user2);
            System.out.println("Unfollowed " + user2.getName() + "!!");
        } else {
            System.out.println("Invalid interaction type.");
        }
    }

    // Show feed for a user
    public void showFeed(int userId) {
        User user = users.get(userId);
        if (user != null) {
            List<Post> feed = new ArrayList<>();
            // Posts from followed users
            for (User followedUser : users.values()) {
                if (user.getFollowedUsers().contains(followedUser.getId())) {
                    feed.addAll(followedUser.getPosts());
                }
            }
            // Posts from non-followed users
            for (User nonFollowedUser : users.values()) {
                if (!user.getFollowedUsers().contains(nonFollowedUser.getId())) {
                    feed.addAll(nonFollowedUser.getPosts());
                }
            }
            // Sort posts by timestamp (recent first)
            feed.sort((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

            // Display feed
            for (Post post : feed) {
                System.out.println("UserName - " + post.getUser().getName());
                System.out.println("Post - " + post.getContent());
                System.out.println("Post time - " + post.getRelativeTime());
                System.out.println("# of Likes - " + post.getLikes());
                System.out.println("# of Dislikes - " + post.getDislikes());
                System.out.println();
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Like/Dislike a post
    public void interactWithPost(String interactionType, int userId, String postId) {
        boolean postFound = false;
        User user = users.get(userId);
        if (user != null) {
            for (Post post : user.getPosts()) {
                if (post.getPostId().equals(postId)) {
                    postFound = true;
                    if (interactionType.equalsIgnoreCase("LIKE")) {
                        post.like();
                        System.out.println("Post Liked!!");
                    } else if (interactionType.equalsIgnoreCase("DISLIKE")) {
                        post.dislike();
                        System.out.println("Post Disliked!!");
                    } else {
                        System.out.println("Invalid interaction type.");
                    }
                    break;
                }
            }
            if (!postFound) {
                System.out.println("Post not found.");
            }
        } else {
            System.out.println("User not found.");
        }
    }
}

