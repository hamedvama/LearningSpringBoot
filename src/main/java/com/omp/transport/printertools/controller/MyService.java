package com.omp.transport.printertools.controller;

import com.omp.transport.printertools.model.Cours;
import com.omp.transport.printertools.model.Employee;
import com.omp.transport.printertools.model.MyFichier;
import com.omp.transport.printertools.repository.CoursCrudRepository;
import com.omp.transport.printertools.repository.EmployeeRepository;
import com.omp.transport.printertools.repository.MyFichierCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class MyService {

    @Autowired
    private CoursCrudRepository coursCrudRepository;

    @Autowired
    private MyFichierCrudRepository myFichierCrudRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/enregistre")
    @ResponseBody
    public void enregistrerCrours (){
        /*Cours cours = new Cours();
        cours.setCod_cours(Long.valueOf(10));
        cours.setLib_cours("Vocabulaire");
        coursCrudRepository.save(cours);*/
        Employee employee = new Employee();
        employee.setFirstname("vama");
        employee.setLastname("baba");

        Employee employee1 = new Employee();
        employee1.setFirstname("babany");
        employee1.setLastname("sticker");

        Employee employee3 = new Employee();
        employee3.setFirstname("babany");
        employee3.setLastname("sticker");

        employee.getColleagues().add(employee1);
        employee.getTeammates().add(employee3);

        employee1.getColleagues().add(employee);
        employee1.getTeammates().add(employee3);

        employeeRepository.save(employee);
        employeeRepository.save(employee1);
        employeeRepository.save(employee3);

        Optional<Employee> employeeO = employeeRepository.findById(Long.valueOf(1015));
        Employee employee2 = employeeO.get();
        Set<Employee> empl =  employee2.getColleagues();
        for (Employee employee4 : empl ) {
            System.out.println(employee4.getFirstname());

        }

    }

    @GetMapping("/fichierclob")
    @ResponseBody
    public void sauveficher(){
        Path path = Paths.get("src\\main\\resources\\photo.jpg");

        byte[] bArray = new byte[0];
        try {
            bArray = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // reading content from byte array
        for (int i = 0; i < bArray.length; i++){
            System.out.print((char) bArray[i]);
        }

        MyFichier myFichier = new MyFichier();
       // myFichier.setId_fichier(Long.valueOf(15));
        myFichier.setFichier_contenu(bArray);
        myFichier.setContfichier(bArray);
        myFichierCrudRepository.save(myFichier);
    }
}
