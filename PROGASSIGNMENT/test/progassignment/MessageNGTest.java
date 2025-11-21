/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package progassignment;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageNGTest {
    
    public MessageNGTest() {
    }

    
    

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String recipient = "";
        String messageText = "";
        Message instance = new Message();
        instance.sendMessage(recipient, messageText);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message();
       
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of displayMessage method, of class Message.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        Message instance = new Message();
        instance.displayMessage();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTotalMessages method, of class Message.
     */
    @Test
    public void testGetTotalMessages() {
        System.out.println("getTotalMessages");
        int expResult = 0;
        int result = Message.getTotalMessages();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getMessageID();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getRecipient method, of class Message.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getRecipient();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMessageText method, of class Message.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageText();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageHash();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFlag method, of class Message.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getFlag();
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setFlag method, of class Message.
     */
    @Test
    public void testSetFlag() {
        System.out.println("setFlag");
        String flag = "";
        Message instance = new Message();
        instance.setFlag(flag);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
