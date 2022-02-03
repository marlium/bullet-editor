// bullet text editor v0.01

package bullet;

import java.io.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

class bullet extends JFrame implements ActionListener{

    private static JTextArea a;
    private static JFrame f;
    private static int relue = 0;
    private static boolean p = true; // pushin p


    public static void main(String args[]){
        bullet b = new bullet();
    }

    bullet(){
        f = new JFrame("bullet-editor v0.01");

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        JMenu m3 = new JMenu("Bullet");

        JSeparator mis0 = new JSeparator();
        JSeparator mis1 = new JSeparator();
        JSeparator mis2 = new JSeparator();

        JMenuItem mi11 = new JMenuItem("New");
        JMenuItem mi12 = new JMenuItem("Open");
        JMenuItem mi13 = new JMenuItem("Save");
        JMenuItem mi14 = new JMenuItem("Save ASS..");

        JMenuItem mi21 = new JMenuItem("Undo");
        JMenuItem mi22 = new JMenuItem("Redo");
        JMenuItem mi23 = new JMenuItem("Cut");
        JMenuItem mi24 = new JMenuItem("Copy");
        JMenuItem mi25 = new JMenuItem("Paste");
        JMenuItem mi26 = new JMenuItem("Find");

        a = new JTextArea();

        mi11.addActionListener(this);
        mi12.addActionListener(this);
        mi13.addActionListener(this);
        mi14.addActionListener(this);
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);
        mi24.addActionListener(this);
        mi25.addActionListener(this);
        mi26.addActionListener(this);

        m1.add(mi11);
        m1.add(mi12);
        m1.add(mis0); // s0
        m1.add(mi13);
        m1.add(mi14);
        m2.add(mi21);
        m2.add(mi22);
        m2.add(mis1); // s1
        m2.add(mi23);
        m2.add(mi24);
        m2.add(mi25);
        m2.add(mis2); // s2
        m2.add(mi26);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);


        f.add(a);
        f.setSize(850,650);
        f.setVisible(p);
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();

        if (s.equals("Cut")){
            a.cut();
        }
        else if (s.equals("Copy")){
            a.copy();
        }
        else if (s.equals("Paste")){
            a.paste();
        }
        else if (s.equals("Save ASS..")){
            JFileChooser fc = new JFileChooser("f:");
            int r = fc.showSaveDialog(null);
            if (r == JFileChooser.APPROVE_OPTION){
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                try{
                    FileWriter wr = new FileWriter(file, false);
                    BufferedWriter w = new BufferedWriter(wr);
                    w.write(a.getText());
                    w.flush();

                }
                catch (Exception evt){
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
        }
        else if (s.equals("Open")){
            JFileChooser fc = new JFileChooser("f:");
            int r = fc.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION){
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                try{
                    String x = "", y = "";
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    y = br.readLine();
                    while ((x = br.readLine()) != null){
                        y = y + x;
                    }
                    a.setText(y);
                }
                catch (Exception evt){
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
        }
    }
}
