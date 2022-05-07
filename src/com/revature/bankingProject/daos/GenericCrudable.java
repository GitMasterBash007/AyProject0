package com.revature.bankingProject.daos;

import java.io.IOException;

public interface GenericCrudable<T> {



    // Create
    T create(T newObject);

    // Read
    T[] findAll() throws IOException;
    T findById(String id);

    // Update
    boolean update(T updatedObj);

    //Delete
    boolean delete(String id);

}