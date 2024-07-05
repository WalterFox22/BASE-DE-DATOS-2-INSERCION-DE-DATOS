import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");

        String url="jdbc:mysql://localhost:3306/ESTUDIATES2024";
        String user="root";
        String password="123456";

        String nombre="Pedro Perez";
        String cedula="17154878";
        double b1=12.4;
        double b2=10.4;

        String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";



        try (Connection connection= DriverManager.getConnection(url,user,password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            cadenaPreparada.setString(1, cedula);
            cadenaPreparada.setString(2, nombre);
            cadenaPreparada.setDouble(3, b1);
            cadenaPreparada.setDouble(4, b2);
            cadenaPreparada.executeUpdate();

            System.out.println("Se ha registrado la estudiante");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}


