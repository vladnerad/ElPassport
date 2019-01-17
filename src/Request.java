import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class Request extends JPanel {

    private View view;
    private Traktor traktor;
    private int serial;

    public void setView(View view) {
        this.view = view;
    }

    public Request() {
        JButton button = new JButton("Show passport");
        setLayout(new GridLayout(3,1));
        JLabel ent = new JLabel("Enter serial number:");
        this.add(ent);
        JTextField num = new JTextField(4);
        this.add(num);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serial = Integer.parseInt(num.getText());
                try {
                    traktor = Objects.requireNonNull(DB_helper.getTractorFromDB(serial));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                PassPanel passPanel = new PassPanel(traktor, view);
//                view.setPassPanel(passPanel);
//                view.getPass();
            }
        });
        this.add(button);
        //pack();
    }
}
