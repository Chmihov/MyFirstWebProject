package DAO;


import entity.AdersPerson;
import entity.PersonName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_DB extends ConnectSUBD   {


    public static void creadUser() throws SQLException {

        String selectName = "SELECT  id, name, adres_id FROM name;";
        String selectAdress = "SELECT   name FROM adress  WHERE id = ?;";


        Connection dbConnection = null;
        Statement statement = null;


        List<PersonName> list = new ArrayList();

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectName);
            while (resultSet.next()) {
                PersonName personName = new PersonName();
                String userName = resultSet.getString("name");
                Long userID = resultSet.getLong("id");
                Long userAdres_id = resultSet.getLong("adres_id");
                personName.setNamePerson(userName);
                personName.setId(userID);


                AdersPerson adersPerson = new AdersPerson();
                adersPerson.setId(userAdres_id);

                PreparedStatement preparedStatement = dbConnection.prepareStatement(selectAdress);
                preparedStatement.setLong(1, userAdres_id);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                if (resultSet1.next()) {

                    String adressName = resultSet1.getString("name");
                    adersPerson.setCity(adressName);
                }

                personName.setAdersPerson(adersPerson);

                list.add(personName);

            }

        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
        System.out.println(list);
    }
}
