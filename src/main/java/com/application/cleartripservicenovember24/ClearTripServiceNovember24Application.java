package com.application.cleartripservicenovember24;
import com.application.cleartripservicenovember24.Controllers.SocialMediaApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ClearTripServiceNovember24Application {

    public static void main(String[] args) {
        SpringApplication.run(ClearTripServiceNovember24Application.class, args);
        Scanner scanner = new Scanner(System.in);
        SocialMediaApp app = new SocialMediaApp();

        while (true) {
            System.out.println("Enter command:");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 3);

            if (command[0].equalsIgnoreCase("RegisterUser")) {
                int id = Integer.parseInt(command[1]);
                String name = command[2];
                app.registerUser(id, name);
            } else if (command[0].equalsIgnoreCase("UploadPost")) {
                int userId = Integer.parseInt(command[1]);
                String content = command[2];
                app.uploadPost(userId, content);
            } else if (command[0].equalsIgnoreCase("InteractionWithUser")) {
                String interactionType = command[1];
                int userId1 = Integer.parseInt(command[2]);
                int userId2 = Integer.parseInt(command[3]);
                app.interactWithUser(interactionType, userId1, userId2);
            } else if (command[0].equalsIgnoreCase("ShowFeed")) {
                int userId = Integer.parseInt(command[1]);
                app.showFeed(userId);
            } else if (command[0].equalsIgnoreCase("InteractWithPost")) {
                String interactionType = command[1];
                int userId = Integer.parseInt(command[2]);
                String postId = command[3];
                app.interactWithPost(interactionType, userId, postId);
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

}

//import java.util.Scanner;
//
//public class CleartripServiceNovember24Application {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        SocialMediaApp app = new SocialMediaApp();
//
//        while (true) {
//            System.out.println("Enter command:");
//            String input = scanner.nextLine();
//            String[] command = input.split(" ", 3);
//
//            if (command[0].equalsIgnoreCase("RegisterUser")) {
//                int id = Integer.parseInt(command[1]);
//                String name = command[2];
//                app.registerUser(id, name);
//            } else if (command[0].equalsIgnoreCase("UploadPost")) {
//                int userId = Integer.parseInt(command[1]);
//                String content = command[2];
//                app.uploadPost(userId, content);
//            } else if (command[0].equalsIgnoreCase("InteractionWithUser")) {
//                String interactionType = command[1];
//                int userId1 = Integer.parseInt(command[2]);
//                int userId2 = Integer.parseInt(command[3]);
//                app.interactWithUser(interactionType, userId1, userId2);
//            } else if (command[0].equalsIgnoreCase("ShowFeed")) {
//                int userId = Integer.parseInt(command[1]);
//                app.showFeed(userId);
//            } else if (command[0].equalsIgnoreCase("InteractWithPost")) {
//                String interactionType = command[1];
//                int userId = Integer.parseInt(command[2]);
//                String postId = command[3];
//                app.interactWithPost(interactionType, userId, postId);
//            } else {
//                System.out.println("Invalid command.");
//            }
//        }
//    }
//}

