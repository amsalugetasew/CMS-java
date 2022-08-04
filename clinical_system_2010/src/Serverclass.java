
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gech
 */
public class Serverclass {
     public static void main (String[] argv){
 try {
      //Create and get reference to rmi registry
      Registry registry = LocateRegistry.createRegistry(1099);
      Naming.rebind("clinical", (Remote) new Mainclass());
      System.out.println("cclinicallinical server is created!!!");
      System.out.println("clinical Server is ready....................");
    } catch (Exception e) {
      System.out.println(e);
    }
}
}
