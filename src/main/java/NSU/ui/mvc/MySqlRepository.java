package NSU.ui.mvc;

import NSU.ui.Group;
import NSU.ui.Student;
import NSU.ui.MessageRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class MySqlRepository implements MessageRepository {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, Student> messages = new ConcurrentHashMap<Long, Student>();

    private Connection connection;

    public MySqlRepository() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson8", "root", "");
    }

    public void closeConnection(){
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Iterable<Student> findAll() {
        String query = "select * from student";
        ArrayList<Student> students = new ArrayList<Student>();
        try(Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Student message = new Student();
                message.setIdent(rs.getString(1));
                message.setName(rs.getString(3));
                message.setSecondName(rs.getString(4));
                message.setLastName(rs.getString(5));

                String groupId = rs.getString(2);
                message.setGroupId(findGroupName(groupId));
                message.setBday(rs.getString(6));
                students.add(message);
            }
        //closeConnection();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return students;
    }
    public String findGroupName(String groupId) {

        try(Statement st = connection.createStatement()) {
        String queryGroup = "select * from `group` where id="+groupId;
        ResultSet resGroup = st.executeQuery(queryGroup);
        resGroup.next();
        String id = resGroup.getString(2);
        return id;

        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
    @Override
    public Student save(Student student) throws SQLException {
        try(Statement st = connection.createStatement()) {
            st.execute("INSERT `group` (group_name)" +
                    "VALUES ('" + student.getGroupId() + "');");
            ResultSet rset = st.executeQuery("select * from `group` where group_name = " + student.getGroupId());
            rset.next();
            int id = rset.getInt("id");
            st.execute("INSERT student(group_id, first_name, second_name, last_name, birthday_date)" +
                    "VALUES ( '" + id +"','" + student.getName() +"','" + student.getSecondName() +"','" + student.getLastName() +"','" + student.getBday() +"');");
            rset.close();
        }

        Long id = student.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            student.setId(id);
        }
        this.messages.put(id, student);
        return student;
    }

    @Override
    public Student findMessage(Long id) {
        return null;
    }

    @Override
    public Iterable<Group> showGroups() {
        String query = "select * from `group`";
        //ArrayList<Group> groups = new ArrayList<Group>();
        try {
            Statement st = connection.createStatement();
            ResultSet groupRes = st.executeQuery(query);

            ArrayList<Group> lstGroup = new ArrayList<Group>();
            while (groupRes.next()) {
                Group group = new Group();
                group.setId(groupRes.getInt("id"));
                group.setGroupName(groupRes.getString("group_name"));
                lstGroup.add(group);
            }
            groupRes.close();
            for (Group i : lstGroup){
                System.out.println("Группа " + i.getGroupName());
                ResultSet studentRes = st.executeQuery("select * from student where group_id="+ i.getId());

                while (studentRes.next()) {
                    Student student = new Student();
                    student.setName(studentRes.getString("first_name"));
                    System.out.println(student.getName());
                    student.setSecondName(studentRes.getString("second_name"));
                    student.setLastName(studentRes.getString("last_name"));
                    student.setBday(studentRes.getString("birthday_date"));
                    System.out.println(studentRes.getString("first_name") + " "+ studentRes.getString("second_name") + " " + studentRes.getString("last_name") + " " + studentRes.getString("birthday_date"));
                    i.lstStudents.add(student);
                }
                System.out.println();
                studentRes.close();
            }
            st.close();

            return lstGroup;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findById(String ident) {
        System.out.println("ert");
        //String query = "select * from student where id="+Integer.getInteger(ident);
        try(Statement st = connection.createStatement()) {
            System.out.println(ident);
            ResultSet studentRes = st.executeQuery("select * from student where id="+Integer.parseInt(ident));

            studentRes.next();
            Student student = new Student();
            student.setIdent(studentRes.getString("id"));
            student.setName(studentRes.getString("first_name"));
            student.setSecondName(studentRes.getString("second_name"));
            student.setLastName(studentRes.getString("last_name"));
            student.setBday(studentRes.getString("birthday_date"));
            String groupId = studentRes.getString(2);
            student.setGroupId(findGroupName(groupId));
            studentRes.close();
            return student;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
