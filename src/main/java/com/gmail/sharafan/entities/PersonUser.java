/**
 * @author Sharafan Oksana
 * @date 07.01.2020
 * @package com.gmail.sharafan.entities
 */
package com.gmail.sharafan.entities;

import java.util.Objects;

public class PersonUser {
    private String name;
    private String password;

    public PersonUser() {
    }

    public PersonUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonUser personUser = (PersonUser) o;
        if (name != null ? !name.equals(personUser.name) : personUser.name != null) return false;
        return password != null ? password.equals(personUser.password) : personUser.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
