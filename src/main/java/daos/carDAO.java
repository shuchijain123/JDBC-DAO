package daos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class carDAO extends DAO<Car> {


    public carDAO(Connection conn) {
        super(conn);
    }


    private static final String INSERT = "Insert into Car" +
            "(id, make, model, year, color, vin)" +
            "values(?,?,?,?,?,?)";

    private static final String DELETE = "DELETE FROM Car WHERE id = ?";

    private static final String UPDATE = "UPDATE Car set make = 'Honda' WHERE make = ?";
    private static final String SELECT = "SELECT * from Car WHERE id = ?";

    private static final String SELECTALL = "SELECT * from Car";



@Override
    public Car findById(int id) {

    Car car = null;
    try{


        PreparedStatement pstmtselect = this.connection.prepareStatement(SELECT);

         pstmtselect.setInt(1, id);
        ResultSet rs =  pstmtselect.executeQuery();

        while (rs.next()){
            car = new Car();
            car.setId(rs.getInt("id"));
            car.setMake(rs.getString("make"));
            car.setModel(rs.getString("model"));
            car.setYear(rs.getString("year"));
            car.setColor(rs.getString("color"));
            car.setVin(rs.getString("vin"));


        }




    }catch(SQLException e){
        System.out.println(e);
    }

    System.out.println(car.toString());
    return car;
    }

    public List<Car> findAll() {
        List<Car> carlist = new ArrayList<>();


        Car car = null;
        try {


            PreparedStatement pstmtselect = this.connection.prepareStatement(SELECTALL);




            ResultSet rs = pstmtselect.executeQuery();
            int  id=1;

            while (rs.next()) {


               car = findById(id);
                 id++;

                 carlist.add(car);

            }




        } catch (SQLException e) {
            System.out.println(e);
        }

            for (int i =0 ;i<carlist.size();i++) {



            }

        return carlist;
    }


        public Car update(Car dto) {


            try(PreparedStatement pstmt = this.connection.prepareStatement(UPDATE);){
                pstmt.setString(1,dto.getMake());
                pstmt.executeUpdate();

            }catch(SQLException e){
                System.out.println(e);
            }



        return null;
    }

    public Car create(Car dto) {


      Car car = new Car();

        try(PreparedStatement pstmt = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getMake());
            pstmt.setString(3, dto.getModel());
            pstmt.setString(4, dto.getYear());
            pstmt.setString(5, dto.getColor());
            pstmt.setString(6, dto.getVin());
            pstmt.executeUpdate();


            ResultSet rs = pstmt.getGeneratedKeys();

            int key = rs.next() ? rs.getInt(1) : 0;

            if(key!=0){
                System.out.println("newId="+key);

                car=findById(key);
            }



            //TODO: get newly created auto_generated id from created record and return it below
            //Done

        }catch(SQLException e){
            System.out.println(e);
        }

        return car;
    }

   @Override
    public void delete(int id) {
        try(PreparedStatement pstmt = this.connection.prepareStatement(DELETE);){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
           System.out.println(e);
        }
    }
}











