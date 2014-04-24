/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Juice;
import com.dthebus.gymweb.repository.JuiceRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author darren
 */
public class JuiceTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static JuiceRepository repo;
    public JuiceTest() {
    }

      @Test
      public void createJuice() {
         repo = ctx.getBean(JuiceRepository.class);
         Juice p = new Juice.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createJuice")
     public void readJuice(){
         repo = ctx.getBean(JuiceRepository.class);
         Juice entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readJuice")
     private void updateJuice(){
         repo = ctx.getBean(JuiceRepository.class);
         Juice entity = repo.findOne(id);
         Juice updatedentity = new Juice.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Juice updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateJuice")
     private void deleteJuice(){
         repo = ctx.getBean(JuiceRepository.class);
         Juice person = repo.findOne(id);
         repo.delete(person);
         Juice deletedPerson = repo.findOne(id);
         Assert.assertNull(deletedPerson);
         }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
