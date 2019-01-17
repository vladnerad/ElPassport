import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Objects;

import static java.awt.event.KeyEvent.VK_ENTER;

public class TestView extends JFrame{
    private JTextField textField1;
    private JButton enter;
    private JPanel passp;
    private JLabel label1;
    private JLabel number;
    private JLabel disNum;
    private JLabel HPNum;
    private JSeparator botSep;
    private JComboBox typeDisel;
    private JComboBox typePump;
    private JComboBox typeMot;
    private JComboBox typeDozer;
    private JTextField reqSerNum;
    private JTextField reqDisNum;
    private JTextField reqHPNum;
    private JTextField reqHMNum;
    private JButton butt_add;

    Traktor traktor;

    public TestView() {
        setContentPane(passp);
        setTitle("Passport");
        setSize(450, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        reqSerNum.setVisible(false);
        reqDisNum.setVisible(false);
        reqHMNum.setVisible(false);
        reqHPNum.setVisible(false);
        butt_add.setText("Save");
        butt_add.setVisible(false);

        setVisible(true);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu actions = new JMenu("Actions");
        JMenuItem view = new JMenuItem("View passport");
        JMenuItem add_new_passport = new JMenuItem("Add new passport");
        JMenuItem update = new JMenuItem("Update passport");
        actions.add(view);
        actions.add(add_new_passport);
        actions.add(update);
        update.setEnabled(false);
        jMenuBar.add(actions);
        setJMenuBar(jMenuBar);


        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTrak();
                update.setEnabled(true);

            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER){
                    showTrak();
                    update.setEnabled(true);
                }
            }
        });


        add_new_passport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                textField1.setVisible(false);
                enter.setVisible(false);
                reqSerNum.setVisible(true);
                reqSerNum.setEditable(true);
                reqDisNum.setVisible(true);
                reqDisNum.setEditable(true);
                reqHPNum.setVisible(true);
                reqHPNum.setEditable(true);
                reqHMNum.setVisible(true);
                reqHMNum.setEditable(true);
                typeDozer.setEnabled(true);
                typeDisel.setEnabled(true);
                typePump.setEnabled(true);
                typeMot.setEnabled(true);

                butt_add.setVisible(true);

            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeDozer.setEnabled(true);
                typeDisel.setEnabled(true);
                typePump.setEnabled(true);
                typeMot.setEnabled(true);
                reqSerNum.setEditable(true);
                reqDisNum.setEditable(true);
                reqHPNum.setEditable(true);
                reqHMNum.setEditable(true);
            }
        });

        typeDozer.addItem("GST-9");
        typeDozer.addItem("GST-10");
        typeDozer.addItem("GST-12");
        typeDozer.addItem("GST-15");
        typeDozer.addItem("GST-20");
        typeDozer.setSelectedIndex(3);
        typeDozer.setEnabled(false);

        typeDisel.addItem("YaMZ-236");
        typeDisel.addItem("YaMZ-238");
        typeDisel.addItem("YaMZ-536");
        typeDisel.addItem("YaMZ-650");
        typeDisel.setSelectedIndex(1);
        typeDisel.setEnabled(false);

        typePump.addItem("Bosch 85");
        typePump.addItem("Bosch 110");
        typePump.addItem("Linde");
        typePump.addItem("Danfoss");
        typePump.setEnabled(false);

        typeMot.addItem("Bosch 160");
        typeMot.addItem("Bosch 170");
        typeMot.addItem("Bosch 280");
        typeMot.addItem("Linde 280");
        typeMot.addItem("Danfoss 160");
        typeMot.setEnabled(false);


        //typeDisel.setEditable(true);

        butt_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(reqSerNum.getText());
                int b = Integer.parseInt(reqDisNum.getText());
                int c = Integer.parseInt(reqHPNum.getText());
                int d = Integer.parseInt(reqHMNum.getText());
                traktor = new Traktor(a, b, d, c);
                //traktor.setSerialN(y);
//                traktor.setDieselN(Integer.parseInt(reqDisNum.getText()));
//                traktor.setHydPumpNum(Integer.parseInt(reqHPNum.getText()));
//                traktor.setHydMotNum(Integer.parseInt(reqHMNum.getText()));

                DB_helper.addToDB(traktor);
            }
        });


        this.revalidate();
    }

    private void showTrak(){
        int serial = Integer.parseInt(textField1.getText());
        reqSerNum.setVisible(true);
        reqDisNum.setVisible(true);
        reqHPNum.setVisible(true);
        reqHMNum.setVisible(true);
        reqSerNum.setEditable(false);
        reqDisNum.setEditable(false);
        reqHPNum.setEditable(false);
        reqHMNum.setEditable(false);
        try {
            Traktor traktor = Objects.requireNonNull(DB_helper.getTractorFromDB(serial));
            reqSerNum.setText(String.valueOf(traktor.getSerialN()));
            reqDisNum.setText(String.valueOf(traktor.getDieselN()));
            reqHPNum.setText(String.valueOf(traktor.getHydPumpNum()));
            reqHMNum.setText(String.valueOf(traktor.getHydMotNum()));
            //update.setEnabled(true);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        this.revalidate();
    }
}
