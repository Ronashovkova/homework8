package com.cursor.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsersStream {

    private static List<User> buildUsersList() {
        List<User> users = new ArrayList<>();
        users.add(new User("123@gmail.com", LocalDate.of(2019, 12, 17), "Tigers"));
        users.add(new User("456@gmail.com", LocalDate.of(2019, 12, 20), "Beavers"));
        users.add(new User("789@gmail.com", LocalDate.of(2019, 11, 1), "Tigers"));
        users.add(new User("012@gmail.com", LocalDate.of(2019, 11, 3), "Beavers"));
        users.add(new User("754@gmail.com", LocalDate.of(2019, 12, 16), "Beavers"));
        return users;
    }

    public static void processUsers() {
        List<User> users = buildUsersList();
        Map<String, List<String>> teamEmailMap = users.stream().
                filter(user -> user.getLoginDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.groupingBy(User::getTeam,
                        Collectors.mapping(User::getEmail, Collectors.toList())));
        System.out.println("Map of teams with e-mails: " + teamEmailMap);
    }
}
