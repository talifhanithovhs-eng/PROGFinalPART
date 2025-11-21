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
public class QuickChatNGTest {
    
    public QuickChatNGTest() {
    }

    

    /**
     * Test of startChat method, of class QuickChat.
     */
    @Test
    public void testStartChat() {
        System.out.println("startChat");
        QuickChat instance = new QuickChat();
        instance.startChat();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
