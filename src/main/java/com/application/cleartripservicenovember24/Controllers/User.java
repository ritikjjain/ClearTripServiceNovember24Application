package com.application.cleartripservicenovember24.Controllers;

import java.util.HashMap;
import java.util.Map;

// public class User {

//    private Map<String, Object> attributes = new HashMap<>();
//
//    public void setAttribute(String key, Object value) {
//        attributes.put(key, value);
//    }
//
//    public Object getAttribute(String key) {
//        return attributes.get(key);
//    }
//
////    private int user_id;
////    private String user_name;
//      private int post_id;
//
//
//    public void RegisterUser(int user_id, String user_name){
////        this.user_id = user_id;
////        this.user_name = user_name;
////        System.out.println(user_name + "Registered!!");
//        User user = new User(); // user object created multiple times then its name will be user only
//        user.setAttribute("user_id", user_id); // user.getAttribute(user_id);
//        user.setAttribute("user_name", user_name);
//    }
//
//    public void UploadPost(int user_id, String post){
////        this.user_id = user_id;
////        this.user_name = user_name;
//        System.out.println("Upload successful with post id : " + this.post_id++);
//    }
//
//    public void InteractWithUser(String interaction_type, int user_id1, int user_id2){
//        // interaction_type can be enum as well
//        if (interaction_type.equals("FOLLOW")){
//            System.out.println("Followed" + user_id2);
//        }
//        else if (interaction_type.equals("UNFOLLOW")){
//            System.out.println("Unfollowed" + user_id2);
//        }
//    }
//
//    public void ShowFeed(int user_id){
//
//    }


// }

import java.util.*;

public class User {
    private int id;
    private String name;
    private Set<Integer> followedUsers;
    private List<Post> posts;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.followedUsers = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getFollowedUsers() {
        return followedUsers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void follow(User user) {
        followedUsers.add(user.getId());
    }

    public void unfollow(User user) {
        followedUsers.remove(user.getId());
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}

