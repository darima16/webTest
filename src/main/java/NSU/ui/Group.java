package NSU.ui;

import java.util.ArrayList;

public class Group {
    public ArrayList<Student> lstStudents = new ArrayList<>();
    private int id;
    private String groupName;

    Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }
    public Group(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


}

