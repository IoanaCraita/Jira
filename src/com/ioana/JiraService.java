package com.ioana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JiraService {

    public Map<Issue, Integer> readIssue() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Issue, Integer> board = new HashMap<>();

        boolean addMore = true;
        while (addMore) {
            System.out.println("Select issue: Task/Bug/Improvement");

            try {
                String issueType = reader.readLine();
                Issue issue = null;
                switch (issueType) {
                    case "Task":
                        issue = new Task();
                        break;
                    case "Bug":
                        issue = new Bug();
                        break;
                    case "Improvement":
                        issue = new Improvement();
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                System.out.println("Priority:");
                int priority = Integer.parseInt(reader.readLine());
                if (priority <= 100 && issue != null) {
                    board.put(issue, priority);
                } else {
                    System.out.println("Invalid priority");
                }
                System.out.println("Name: ");
                String name = reader.readLine();
                issue.setName(name);

                System.out.println("Description: ");
                String description = reader.readLine();
                issue.setDescription(description);

                System.out.println("Assignee: ");
                String assignee = reader.readLine();
                issue.setAssignee(assignee);

                System.out.println("Still adding? ");
                String addMoreString = reader.readLine();
                addMore = addMoreString.equals("yes");

            } catch (IOException ioException) {
                System.out.println("There was a problem");
                ioException.printStackTrace();
            }
        }
        return board;
    }

    public  HashMap<Issue, Integer> sortMap(Map<Issue, Integer> board)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Issue, Integer> > list
                = new LinkedList<Map.Entry<Issue, Integer> >(
                board.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<Issue, Integer> sortedBoard = new LinkedHashMap<Issue, Integer>();
        for (Map.Entry<Issue, Integer> aa : list) {
            sortedBoard.put(aa.getKey(), aa.getValue());
        }
        return sortedBoard;
    }


    public void printBoard(Map<Issue, Integer> sortedBoard) {
     //   for (Map.Entry<Issue, Integer> entry : sortedBoard.entrySet()) {
        for (Issue issue :sortedBoard.keySet()){
            issue.print();
        }
    }
}



