package com.ioana;

public abstract class Issue {
   private String name;
   private String assignee;
   private String description;



   public void print() {
       System.out.println(name + " " + assignee + " " + description);
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
