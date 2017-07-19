/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Sergio
 */
public class prueba {
//    public static void main(String... args) {
//        JFrame frame = new JFrame();
//        JPanel panel = new JPanel();
//        for (int i = 0; i < 10; i++) {
//            panel.add(new JButton("Hello-" + i));
//        }
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBounds(50, 30, 300, 200);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        contentPane.add(scrollPane);
//        frame.setContentPane(contentPane);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setVisible(true);
//    }
    public static void main(String[] args) {
        Usuario usuario = new Usuario("perro","er");
        System.out.println(usuario.encriptarContra("mitch"));
//		ScrollableJTable();
//	}
//	public static void ScrollableJTable(){
//		JFrame frame = new JFrame("Creating a Scrollable JTable!");
//		JPanel panel = new JPanel();
//		String data[][] = {{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},{"001","vinod","Bihar","India","Biology","65","First"},{"002","Raju","ABC","Kanada","Geography","58","second"},{"003","Aman","Delhi","India","computer","98","Dictontion"},{"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"}};
//		String col[] = {"Roll","Name","State","country","Math","Marks","Grade"};
//		JTable table = new JTable(data,col);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		JTableHeader header = table.getTableHeader();
//		header.setBackground(Color.yellow);
//		JScrollPane pane = new JScrollPane(table);	
//		panel.add(pane);
//		frame.add(panel);
//		frame.setSize(500,200);
//		frame.setUndecorated(true);
//		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
}}
