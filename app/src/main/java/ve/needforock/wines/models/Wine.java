package ve.needforock.wines.models;

import com.orm.SugarRecord;

/**
 * Created by Soporte on 14-Aug-17.
 */

public class Wine extends SugarRecord {
    private String name, type;
    private String age;

    public Wine() {
    }

    public Wine(String name, String type, String age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
