import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassPanel extends JPanel {

    private View view;

    public PassPanel(Traktor traktor, View view) {
        this.view = view;
        setLayout(new GridLayout(4,1));
        JLabel serial = new JLabel("Serial number: " + traktor.getSerialN());
        JLabel dvs = new JLabel("Diesel number: " + traktor.getDieselN());
        JLabel hp = new JLabel("HydPump number: " + traktor.getHydPumpNum());
        JLabel hm = new JLabel("HydMot number: " + traktor.getHydMotNum());
        this.add(serial);
        this.add(dvs);
        this.add(hp);
        this.add(hm);
        JButton jButton = new JButton("BACK");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                view.back();
            }
        });
        this.add(jButton);
        //pack();
    }
}
