package com.gmail.sharafan.dataBaseTables;

import com.gmail.sharafan.entities.PersonUser;

import java.util.Collection;

public interface UserPersonDao {
    public boolean addUser(PersonUser person);
    public PersonUser getUserById(Integer id);
    public boolean updateUserById(PersonUser person);
    public boolean deleteUserById(Integer id);

    Collection<PersonUser> getAllUserPerson();
}
