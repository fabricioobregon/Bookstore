package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;

public class BookManager {

    public BookManager(Enum USERMODE) {
        if(!USERMODE.equals(UserMode.VISITOR)){
            System.out.println("Managing Books");
        }
        System.out.println("You do not have permission to manage books!");
    }
}
