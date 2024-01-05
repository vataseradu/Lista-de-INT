package ListaDeInt;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI4ListaDeInt extends JFrame {

    ListaDeInt listaDeInt = new ListaDeInt(10, 0);

    private JLabel eticheta = new JLabel("Introduceti element");
    private JTextField elementCurent = new JTextField("", 10);
    private JLabel elementeLista = new JLabel("CONTINUT LISTA:");
    private JLabel valoareElement = new JLabel("");
    private JButton adaugaElement = new JButton("Adauga Element");
    private JButton stergereElement = new JButton("Sterge Element");
    private JButton sortareElement = new JButton("Sortare Element");

    private JOptionPane avertizareUtilizator = new JOptionPane("avertizare");

    public GUI4ListaDeInt() {

        adaugaElement.addActionListener(elb);
        stergereElement.addActionListener(elb);
        sortareElement.addActionListener(elb);
        Box bh1 = Box.createHorizontalBox();
        bh1.add(eticheta);
        bh1.add(Box.createHorizontalStrut(10));
        bh1.add(eticheta);
        bh1.add(Box.createHorizontalStrut(10));
        bh1.add(Box.createHorizontalGlue());

        Box bh2 = Box.createHorizontalBox();
        bh2.add(elementCurent);
        bh2.add(Box.createHorizontalStrut(10));
        bh2.add(elementCurent);
        bh1.add(Box.createHorizontalStrut(10));
        bh2.add(Box.createHorizontalGlue());
  
        Box bv5 = Box.createVerticalBox();
        bv5.add(Box.createVerticalStrut(36));
        bv5.add(adaugaElement);
        bv5.add(Box.createVerticalStrut(10));
        bv5.add(stergereElement);
        bv5.add(Box.createVerticalStrut(10));
        bv5.add(sortareElement);
        bv5.add(Box.createVerticalStrut(10));
        bv5.add(Box.createVerticalGlue());

        Box bv1 = Box.createVerticalBox();
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bh1);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bh2);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(valoareElement);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(Box.createVerticalGlue());


        Box bh3 = Box.createHorizontalBox();
        bh3.add(Box.createHorizontalStrut(10));
        bh3.add(bv1);
        bh3.add(Box.createHorizontalStrut(10));
        bh3.add(bv5);
        bh3.add(Box.createHorizontalStrut(10));
        bh3.add(Box.createHorizontalGlue());

        Container cp = getContentPane();
        cp.add(BorderLayout.CENTER, bh3);

    }

    int ultimaValoareProcesata = 0;

    class AscultatorEvenimenteButon implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String id = ((JButton) e.getSource()).getText();
            if (id.equals("Adauga Element")) {
                if ((elementCurent.getText()).equals("")) {
                    JOptionPane.showMessageDialog(GUI4ListaDeInt.this, "Introduceti un element", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        ultimaValoareProcesata = Integer.parseInt(elementCurent.getText());
                        listaDeInt.adaugareElement(ultimaValoareProcesata);
                        valoareElement.setText(listaDeInt + "");
                        elementCurent.setText("");
                    } catch (NumberFormatException x) {
                        JOptionPane.showMessageDialog(GUI4ListaDeInt.this, "Introduceti un numar INT", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                        elementCurent.setText("");

                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(GUI4ListaDeInt.this, "Something went wrong", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                        elementCurent.setText("");
                    }
                }


                if (listaDeInt.getNumarCurentDeElemente() == listaDeInt.dimensiuneaMaxima) {
                    JOptionPane.showMessageDialog(GUI4ListaDeInt.this, "stiva este plina", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }

            }
            if (id.equals("Sortare Element")) {
                listaDeInt.sortareElemente();
                valoareElement.setText(listaDeInt + "");
            }
            if (id.equals("Sterge Element")) {
                listaDeInt.stergereElement();
                valoareElement.setText(listaDeInt + "");
                if (listaDeInt.getNumarCurentDeElemente() == 0) {
                    JOptionPane.showMessageDialog(GUI4ListaDeInt.this, "stiva este goala", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }

    }

    private AscultatorEvenimenteButon elb = new AscultatorEvenimenteButon();

    public static void main(String[] args) {
        GUI4ListaDeInt ig = new GUI4ListaDeInt();

        ig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ig.setSize(700, 200);
        ig.setVisible(true);
        ig.setTitle("Lista de INT");

        try {
            File file = new File("Le.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
