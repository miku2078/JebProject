import java.sql.*;

public class MysqlSearch {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // 数据库驱动
    private Connection connection = null;
    private String db_url = "jdbc:mysql://localhost:3306/db_student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "yuri";

    MysqlSearch(String db_name) {
        db_url = db_url.replace("db_student", db_name);
        System.out.println(db_url);
    }

    boolean connect() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("正在连接数据库...");
            connection = DriverManager.getConnection(db_url, USER, PASS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void close() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void sqlSearch(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();
            for(int i = 1; i <= columnCount; ++i) {
                System.out.printf("%-10s", metadata.getColumnName(i) + "  ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    System.out.printf("%-10s", value + "  ");
                }
                System.out.println();
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
