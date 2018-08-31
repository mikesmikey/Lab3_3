import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OXForm {
    private JLabel xscorelabel;
    private JLabel drawscorelabel;
    private JLabel oscorelabel;
    private JPanel mainpanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private OX ox = new OX();
    private int col, row;

    public OXForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 0;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 0;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 0;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 1;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 1;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 1;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 2;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 2;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 2;
                if (ox.put(col, row)) {
                    render();
                    process();
                }
            }
        });
    }

    int clickcount=0;
    private void process() {
        clickcount++;
        boolean win = ox.checkWin();
        if (win || clickcount == 9)
        {
            int playagain;
            if (!win) {
                ox.setCountDraw(1);
                render();
                playagain = JOptionPane.showConfirmDialog( mainpanel, " NOBODY WIN, Do you want to play again?", "No Winner :(", JOptionPane.YES_NO_OPTION);
            } else {
                render();
                playagain = JOptionPane.showConfirmDialog( mainpanel, ox.getCurrentPlayer()+" WIN, Do you want to play again?", "We have a Winner!!!", JOptionPane.YES_NO_OPTION);
            }

            if (playagain == JOptionPane.YES_OPTION) {
                clickcount = 0;
                ox.Reset();
                render();
            } else {
                System.exit(0);
            }
        }
        ox.switchPlayer();
    }

    private void render() {
        button1.setText(ox.get(0, 0));
        button2.setText(ox.get(1, 0));
        button3.setText(ox.get(2, 0));
        button4.setText(ox.get(0, 1));
        button5.setText(ox.get(1, 1));
        button6.setText(ox.get(2, 1));
        button7.setText(ox.get(0, 2));
        button8.setText(ox.get(1, 2));
        button9.setText(ox.get(2, 2));

        xscorelabel.setText("X : "+ox.getCountX());
        oscorelabel.setText("O : "+ox.getCountO());
        drawscorelabel.setText("DRAW : "+ox.getCountDraw());
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new OXForm().mainpanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
