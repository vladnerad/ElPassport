public class Main {

    public static void main(String[] args) {
//        String userName = "root";
//        String password = "root";
//        String connectionUrl = "jdbc:mysql://localhost:3306/dozers?autoReconnect=true&useSSL=false";
//        Class.forName("com.mysql.jdbc.Driver");
//
//        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
//        Statement statement = connection.createStatement()){
//            System.out.println("Enter machine serial №: ");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String numMach = br.readLine();
//            br.close();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM passport WHERE serial_n = " + Integer.parseInt(numMach) + ";");
//            while (resultSet.next()){
//                System.out.println("Disel serial: " + resultSet.getInt(3));
//                System.out.println("HM serial: " + resultSet.getInt(4));
//                System.out.println("HP serial: " + resultSet.getInt(5));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        new TestView();
        //view.initEnt();
//        view.initGUI();

    }
}
