import DAO.User_DB;

import java.sql.SQLException;
import DAO.User_DB;
import DAO.ConnectSUBD;
import entity.PersonName;


public class Main extends User_DB {
    public static void main(String[] args) {


        try {
            creadUser();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }

    }
}
