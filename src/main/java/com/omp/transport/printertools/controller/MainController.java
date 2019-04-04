package com.omp.transport.printertools.controller;

import com.omp.transport.printertools.connection.ConnectionDB;
import com.omp.transport.printertools.model.Cours;
import com.omp.transport.printertools.model.MyFichier;
import com.omp.transport.printertools.repository.CoursCrudRepository;
import com.omp.transport.printertools.repository.MyFichierCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class MainController {

    long id;
    @Autowired
    private CoursCrudRepository coursCrudRepository;

    @GetMapping(path = "/enreg")
    @ResponseBody
    public String Home(){
        Cours cours = new Cours();
        cours.setCod_cours(Long.valueOf(20));
        cours.setLib_cours("Grammaire");
        coursCrudRepository.save(cours);

        id = new Long(11);
        System.out.print(coursCrudRepository.findById(id).toString());

        return "Hello World";
    }

    @Autowired
    private MyFichierCrudRepository myFichierCrudRepository;
    @GetMapping(path = "/fichier")
    @ResponseBody
    public String Homme(){
        MyFichier myFichier = new MyFichier();
        myFichier.setId_fichier(new Long(3));
        File file =  new File("C:\\Users\\hamed\\IdeaProjects\\printertools\\src\\main\\resources\\Test.txt");
        System.out.print(file.getAbsolutePath());
        ConnectionDB connectionDB =  null;
        Connection connection = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            //myFichier.setFichier_contenu(fileReader);
            myFichierCrudRepository.save(myFichier);
            System.out.print("ok");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connectionDB =  new ConnectionDB();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = connectionDB.getconnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String updateSQL = "UPDATE REPORT_FICHIER SET REPORT_FILE =? WHERE REPORT_ID =? AND REPORTFICHIER_ID =?";
        try {
            PreparedStatement prStmt = connection.prepareStatement(updateSQL);
            prStmt.setClob(1, fileReader);
            prStmt.setInt(2, 1);
            prStmt.setInt(3, 1);
            prStmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return " ok ";
    }
}
