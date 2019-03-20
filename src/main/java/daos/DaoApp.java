package daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoApp {

    public static void main (String[] arg){


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DAO", "root", "secretpassword");

            carDAO carDAO = new carDAO(conn);


            // Create

            Car carMycarCreate = new Car();
            //carMycarCreate.setId(20);
            carMycarCreate.setMake("Audi");
            carMycarCreate.setModel("subaru");
            carMycarCreate.setYear("2010");
            carMycarCreate.setColor("Brown");
            carMycarCreate.setVin("1111");

            carDAO.create(carMycarCreate);




          /*  // DELETE
            /*
            Car carMycarDelete = new Car();
            carMycarDelete.setId(0);
            carDAO.delete(0);







            // UPDATE

            Car carMycarUpdate = new Car();
            carMycarUpdate.setMake("Nissan");
            carDAO.update(carMycarUpdate);




            // FindID

            Car myCarFindId = new Car();
           // myCarFindId.setId(6););
           carDAO.findById(6);



            // FindAll


           carDAO.findAll();

 */
        }


        catch (Exception e){
            System.out.println(e);
        }









        }
}
