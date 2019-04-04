package com.omp.transport.printertools;

import com.omp.transport.printertools.connection.ConnectionDB;
import com.omp.transport.printertools.model.MyFichier;
import com.omp.transport.printertools.repository.MyFichierCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    static MyFichier myFichier;
    static File file =  new File("C:\\Users\\hamed\\IdeaProjects\\printertools\\src\\main\\resources\\Test.txt");
    static ConnectionDB connectionDB =  null;
    static Connection connection = null;
    static FileReader fileReader = null;

    public static void main(String[] args) throws SQLException, IOException {
        fileReader = new FileReader(file);
        try {
            connectionDB =  new ConnectionDB();
            connection = connectionDB.getconnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stocker();

    }

    public static void stocker(){

        //String updateSQL = "UPDATE FICHIER SET FICHIER_CONTENU =? WHERE ID_FICHIER =?";
        String InsertSQL = "INSERT INTO FICHIER VALUES(4,?)";
        try {
            PreparedStatement prStmt = connection.prepareStatement(InsertSQL);
            prStmt.setCharacterStream(1, fileReader, (int) file.length());
            prStmt.executeUpdate();
            prStmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFichier(){
        String SelectSQL = "SELECT ID_FICHIER, FICHIER_CONTENU FROM FICHIER WHERE ID_FICHIER = 2";
        ResultSet resultSet = null;
        Reader dataReader = null;
        try {
            PreparedStatement prStmt = connection.prepareStatement(SelectSQL);
             resultSet = prStmt.executeQuery();

            dataReader = resultSet.getCharacterStream(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        File data = new File("C:\\Users\\hamed\\IdeaProjects\\printertools\\src\\main\\resources\\TestRead.txt");

        try {
            writer = new FileWriter(data);
            char[] buffer = new char[1];
            while (dataReader.read(buffer) > 0) {
                writer.write(buffer);
            }
            writer.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
