package com.ioana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JiraService {

    public Map<Issue, Integer> readBoard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Issue, Integer> board = new HashMap<>();

        boolean addMore = true;
        while (addMore) {
            try {
                Issue issue = readIssue(reader);
                if (issue == null) {
                    continue;
                }

                System.out.println("Priority:");
                int priority = Integer.parseInt(reader.readLine());
                if (priority <= 100 && priority >= 0) {
                    board.put(issue, priority);
                } else {
                    System.out.println("Invalid priority");
                }

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

    private Issue readIssue(BufferedReader reader) throws IOException {
        System.out.println("Select issue: Task/Bug/Improvement");
        String issueType = reader.readLine();
        switch (issueType) {
            case "Task":
                Task taskIssue = new Task();
                readCommonIssueData(taskIssue, reader);

                System.out.println("Type: ");
                String taskType = reader.readLine();
                Type type = Type.valueOf(taskType);
                taskIssue.setType(type);

                return taskIssue;
            case "Bug":
                Bug bugIssue = new Bug();
                readCommonIssueData(bugIssue, reader);

                System.out.println("Steps: ");
                String steps = reader.readLine();
                bugIssue.setStepsToReproduce(steps);

                return bugIssue;
            case "Improvement":
                //TODO: needs to be implemented
                return null;
            default:
                System.out.println("Invalid option");
                return null;
        }
    }

    private void readCommonIssueData(Issue issue, BufferedReader reader) throws IOException {
        System.out.println("Name: ");
        String name = reader.readLine();
        issue.setName(name);

        System.out.println("Description: ");
        String description = reader.readLine();
        issue.setDescription(description);

        System.out.println("Assignee: ");
        String assignee = reader.readLine();
        issue.setAssignee(assignee);
    }

    public HashMap<Issue, Integer> sortBoard(Map<Issue, Integer> board) {
        // Create a list from elements of HashMap
        List<Map.Entry<Issue, Integer>> list = new LinkedList<>(board.entrySet());

        // Sort the list using lambda expression
        Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<Issue, Integer> sortedBoard = new LinkedHashMap<Issue, Integer>();
        for (Map.Entry<Issue, Integer> aa : list) {
            sortedBoard.put(aa.getKey(), aa.getValue());
        }
        return sortedBoard;
    }


    public void printBoard(Map<Issue, Integer> sortedBoard) {
        //   for (Map.Entry<Issue, Integer> entry : sortedBoard.entrySet()) {
        for (Issue issue : sortedBoard.keySet()) {
            issue.print();
        }
    }
}



