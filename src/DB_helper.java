import java.sql.*;
import java.util.Objects;

public class DB_helper {

    private static final String userName = "root";
    private static final String password = "root";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/dozers?autoReconnect=true&useSSL=false";

    public static Traktor getTractorFromDB(int serial) throws SQLException {
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = Objects.requireNonNull(statement).executeQuery("SELECT * FROM passport WHERE serial_n = " + serial + ";");
            while (resultSet.next()) {
                return getTraktor(resultSet, serial);
            }
            return null;
        }
    }

    private static Traktor getTraktor(ResultSet resultSet, int serialN){
        try {
            return new Traktor(serialN, resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addToDB(Traktor traktor){
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO passport (serial_n, engine_n, HM_n, HP_n) values (" + traktor.getSerialN() + ", " + traktor.getDieselN() + ", " + traktor.getHydMotNum() + ", " + traktor.getHydPumpNum() + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
