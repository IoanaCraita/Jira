package com.ioana;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        JiraService jiraService = new JiraService();
        Map<Issue, Integer> board = jiraService.readIssue();
        Map<Issue, Integer> sortedBoard =  jiraService.sortMap(board);
        jiraService.printBoard(sortedBoard);
    }
}
