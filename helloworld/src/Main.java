import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mysql =  input.next();
        MysqlSearch sql = new MysqlSearch("db_student");
        if(sql.connect()) {
            sql.sqlSearch(mysql);
            sql.close();
        }

        input.close();
    }
}