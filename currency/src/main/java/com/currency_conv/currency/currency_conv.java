package com.currency_conv.currency;

import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class currency_conv {
    public double ans;
    public double d;
    public String s1;
    public String s2;
    public String st;
    public currency_conv()
    {
    
        JFrame frame=new JFrame();
        JButton button= new JButton("Convert");
        button.setPreferredSize(new Dimension(200,50));
        JLabel label=new JLabel("Cuurency converter");
        JPanel bu=new JPanel(new FlowLayout()); 
        JPanel panel=new JPanel(new FlowLayout());
        String [] options={"1.Ruppes","2.Dollar","3.Euro","4.Pound"};
        JComboBox<String> dropdown=new JComboBox<>(options);
        JComboBox<String> dropdown1=new JComboBox<>(options);
        //dropdown.setBounds(200,0,100,200);
        //dropdown1.setBounds(200,80,100,200);
        JPanel panelText=new JPanel(new FlowLayout()); 
        JPanel drop=new JPanel(new FlowLayout()); 
        dropdown.setPreferredSize(new Dimension(150,25));
        panel.add(dropdown);
        dropdown1.setPreferredSize(new Dimension(150,25));
       drop.add(dropdown1);
        JTextField j1=new JTextField("0");
        j1.setPreferredSize(new Dimension(300,50));
        panelText.add(j1);
        JPanel panelText2=new JPanel(new FlowLayout()); 
        //j1.setBounds(250,10,50,30);
        JTextField j2=new JTextField("0");
        j2.setPreferredSize(new Dimension(300,50));
       panelText2.add(j2);
       bu.add(button);
        //j2.setBounds(250,300,50,30);
       // button.setBounds(40, 200, 30, 50);
        frame.setLayout(new GridLayout(6,2,10,10));
        frame.setSize(500,300);
        /* 
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        */
        frame.add(panel);
       // JLabel spacer = new JLabel("");
        //spacer.setPreferredSize(new Dimension(Integer.MAX_VALUE,0));
       // panel.add(spacer);
        //frame.add(dropdown);
        frame.add(panelText);
        frame.add(drop);
        frame.add(panelText2);
        frame.add(bu);
        frame.setVisible(true);
         frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
         frame.setTitle("Currency Converter");
         
         //frame.pack();
         
         //frame.setVisible(true);
       
         button.addActionListener(e->{
            st=j1.getText();
           
            String as="";
            if(dropdown.getSelectedItem().equals("3.Euro"))
            {
               as="eur";
            }
            if(dropdown.getSelectedItem().equals("1.Ruppes"))
            {
               as="inr";
            }
            if(dropdown.getSelectedItem().equals("2.Dollar"))
            {
               as="usd";
            }
            if(dropdown.getSelectedItem().equals("4.Pound"))
            {
               as="gbp";
            }
            System.out.println(as);
            try {
              // const apiURL=`https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/${as}.json`
              String url1="https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/"+as+".json";
                URL url = new URL(url1);
                System.out.println("Generated URL: " + url.toString());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responsecode=conn.getResponseCode();
                System.out.println(responsecode);
                String inline="";
           Scanner scan=new Scanner(url.openStream());
           while(scan.hasNext())
           {
            inline+=scan.nextLine();
           }
           scan.close();
           JSONParser parse=new JSONParser();
         JSONObject data_obj = null;
        try {
            data_obj = (JSONObject) parse.parse(inline);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
         //System.out.println(data_obj);
      
         JSONObject obj=(JSONObject) data_obj.get(as);

           String as2="";
           if(dropdown1.getSelectedItem().equals("1.Ruppes"))
           {
            as2="inr";
           }
           else if(dropdown1.getSelectedItem().equals("2.Dollar"))
           {
            as2="usd";
           }
           else if(dropdown1.getSelectedItem().equals("3.Euro"))
           {
            as2="eur";
           }
           else{
            as2="gbp";

           }
            ans=(Double) obj.get(as2);
            System.out.println(ans+" "+as);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           
          s1=(String)dropdown.getSelectedItem();
        
         
        
          s2=(String)dropdown1.getSelectedItem();
        System.out.println(st+" "+s1+" "+s2);
        d= Double.parseDouble(st);
        d=d*ans;
        System.out.println(d);
        
        if(s1.equals(s2))
        {
            j2.setText(String.format("%.2f", st));
        }
        else
        {
        j2.setText(String.format("%.2f", d));
        }
       

       
       /*  else if(s1.equals("1.Ruppes"))
        {
            if(s2.equals("2.Dollar")){
           
            System.out.println(d/86.22);
          d=d/86.2;
            }
            else if(s2.equals("3.Euro"))
            {
                
                
                System.out.println(d*.0099);
                d=d*.0099;
               
            }
            else if(s2.equals("4.Pound"))
            {
                
                
                System.out.println(d/117.71);
                d=d/117.71;
                
               
            }
            float f=(float)d;
            j2.setText(String.format("%.2f", f));

        }
        else if(s1.equals("2.Dollar"))
        {
            if(s2.equals("1.Ruppes")){
           
                System.out.println(d*87.69);
              d=d*87.69;
                }
                if(s2.equals("3.Euro"))
                {
                    
                    
                    System.out.println(d*.86);
                    d=d*.86;
                   
                }
                if(s2.equals("4.Pound"))
                {
                    
                    
                    System.out.println(d*.74);
                    d=d*.74;
                   
                }
                
                j2.setText(String.format("%.2f", d));


        }
        else if(s1.equals("3.Euro"))
        {
            if(s2.equals("1.Ruppes")){
           
                System.out.println(d*101.84);
              d=d*101.84;
                }
                if(s2.equals("2.Dollar"))
                {
                    
                    
                    System.out.println(d*1.17);
                    d=d*1.17;
                   
                }
                if(s2.equals("4.Pound"))
                {
                    
                    
                    System.out.println(d*.87);
                    d=d*.87;
                   
                }
                
                j2.setText(String.format("%.2f", d));


        }
        else if(s1.equals("4.Pound"))
        {
            if(s2.equals("1.Ruppes")){
           
                System.out.println(d*117.92);
              d=d*117.92;
                }
                if(s2.equals("3.Euro"))
                {
                    
                    
                    System.out.println(d*1.15);
                    d=d*1.15;
                   
                }
                if(s2.equals("2.Dollar"))
                {
                    
                    
                    System.out.println(d*1.34);
                    d=d*1.34;
                   
                }
                
                j2.setText(String.format("%.2f", d));


        }
        */
        
          

        });
      
    }
    public static void main(String[] a)
    {
        new currency_conv();
      
       

    }
}
