package com.jss.old_misc.actors;


import java.util.List;

public abstract class User {
      //  private long userID;

    public String getFullName() {
        return fullName;
    }

    private String fullName;
        //private String pass;
        private List<String> listOfFeedback;


        public User() {
        }

        public User(String fullName) {
            this.fullName = fullName;
        }
    }
