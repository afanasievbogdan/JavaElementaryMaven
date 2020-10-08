package HomeWork21;

import java.sql.*;
import java.sql.Connection;

public class Main {

    private static final String URL =
                    "jdbc:mysql://localhost:3306/student?useUnicode=true&useSSL=true&useJDBCCompliant" +
                    "TimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            if (!connection.isClosed()) {
                System.out.println("Database connected");
            }

            Statement statement = connection.createStatement();
            statement.execute("insert into students (studentID, full_name, groupID, admission_year) values ('1', 'Bohdan', null, '2018');");
            statement.execute("insert into students (studentID, full_name, groupID, admission_year) values ('2', 'Ivan', null, '2019');");
            statement.execute("insert into students (studentID, full_name, groupID, admission_year) values ('3', 'Alex', null, '2020');");

            ResultSet resultSetByName = statement.executeQuery("select studentID, full_name, admission_year from students order by full_name;");
            while (resultSetByName.next())
            {
                int id = resultSetByName.getInt(1);
                String name = resultSetByName.getString(2);
                int year = resultSetByName.getInt(3);

                System.out.printf("%d, %s, %d\n", id, name, year);
            }
            System.out.println("===================");
            ResultSet resultSetById = statement.executeQuery("select studentID, full_name, admission_year from students order by studentID;");
            while (resultSetById.next())
            {
                int id = resultSetById.getInt(1);
                String name = resultSetById.getString(2);
                int year = resultSetById.getInt(3);

                System.out.printf("%d, %s, %d\n", id, name, year);
            }

            statement.execute("delete from students;");

            connection.close();
            if (connection.isClosed()){
                System.out.println("Database disconnected");
            }
        } catch (SQLException sql) {
            System.out.println("Some problems with DB connection");
        }

    }
}

