/**
 * @author Sharafan Oksana
 * @date 07.01.2020
 * @package com.gmail.sharafan.model
 */
package com.gmail.sharafan.model;

import com.gmail.sharafan.entities.PersonUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();
    private List<PersonUser> model;

    public static Model getInstance(){
        return instance;
    }

    public Model() {
        model = new ArrayList<PersonUser>();
    }

    public void add (PersonUser personUser){
        model.add(personUser);
    }

    public List<String> list(){
        return model.stream()
                .map(PersonUser::getName)
                .collect(Collectors.toList());
    }
}
