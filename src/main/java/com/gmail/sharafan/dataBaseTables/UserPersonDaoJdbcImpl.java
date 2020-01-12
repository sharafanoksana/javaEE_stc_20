/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package com.gmail.sharafan.dataBaseTables;

import com.gmail.sharafan.connectionManager.ConnectionManager;
import com.gmail.sharafan.entities.PersonUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EJB
public class UserPersonDaoJdbcImpl implements UserPersonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonDaoJdbcImpl.class);
    public static final String SQL_INSERT_USERS =
//            "DROP TABLE IF EXISTS users;\n" +
                    "create TABLE users(\n" +
                    "    id          serial primary KEY,\n" +
                    "    name        VARCHAR(30) not NULL,\n" +
                    "    passwordHash       VARCHAR(30) not null UNIQUE,\n" +
                    ");\n" +
                    "\n" +
                    "alter table users owner to postgres;";

    private static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    private static final String UPDATE_USERS =
            "UPDATE users SET " +
                    "name=?, " +
                    "passwordHash=?, " +
                    "WHERE id=?";
    private static final String SELECT_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_FROM_USER = "DELETE FROM users WHERE id=?";

    private ConnectionManager connectionManager;

    @Inject
    public UserPersonDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addUser(PersonUser person) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USERS, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.executeUpdate();
            
            // присваиваем id каждому объекту UserPerson
            ResultSet rs = preparedStatement.getGeneratedKeys();
            //берем id из таблицы User, который был присвоен при заполнении таблицы каждому юзеру и вставляем
            // в объект UserPerson
            if (rs.next()) {
                person.setKey(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in addUser method", e);
            return false;
        }
        return true;
    }



    @Override
    public PersonUser getUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USERS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PersonUser userPerson = new PersonUser(
                        resultSet.getString(2),
                        resultSet.getString(3));
                userPerson.setKey(resultSet.getInt(1));
                return userPerson;
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getUserById method", e);
        }
        return null;
    }

    @Override
    public boolean updateUserById(PersonUser person) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setInt(3, person.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in updateUserById method", e);
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in deleteUserById method", e);
            return false;
        }
        return true;
    }

    @Override
    public Collection<PersonUser> getAllUserPerson() {
        List<PersonUser> listUserPerson = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listUserPerson.add(new PersonUser(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            return listUserPerson;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getAllUserPerson method", e);
        }
        return new ArrayList<>();
    }
}
