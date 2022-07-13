package com.ioana;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        JiraService jiraService = new JiraService();
        Map<Issue, Integer> board = jiraService.readBoard();
        Map<Issue, Integer> sortedBoard =  jiraService.sortBoard(board);
        jiraService.printBoard(sortedBoard);

    }
}
