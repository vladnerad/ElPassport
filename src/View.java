import javax.swing.*;
import java.sql.SQLException;

public class View extends JFrame {

//    private Controller controller;
    JFrame jFrame;
//    Request request;
//    PassPanel passPanel;
//
//    public void setPassPanel(PassPanel passPanel) {
//        this.passPanel = passPanel;
//    }
//
//    public View(Controller controller) {
//        this.controller = controller;
//    }
//
    public View() {
        jFrame = new JFrame();
//        TestView jPanel = new TestView();
//        jFrame.add(jPanel);
        jFrame.setTitle("Passport");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(450, 500);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.validate();


    }
//
//    public void initGUI(){
////        request = new Request();
////        request.setView(this);
//        jFrame = new JFrame();
//        jFrame.setTitle("Passport");
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setSize(450, 500);
//        jFrame.setResizable(false);
////        jFrame.add(request);
//        //jFrame.add(traktorInfo);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
//        jFrame.validate();
//    }
//
//    public void printTraktorToConsole(Traktor traktor){
//        System.out.println(traktor.getDieselN());
//        System.out.println(traktor.getHydPumpNum());
//        System.out.println(traktor.getHydMotNum());
//    }
//
//    public void getPass(){
//        jFrame.remove(request);
//        jFrame.add(passPanel);
//        jFrame.revalidate();
//    }
//
//    public void back(){
//        Request request = new Request();
//        request.setView(this);
//        jFrame.getContentPane().removeAll();
//        jFrame.add(request);
//        jFrame.revalidate();
//    }
}
