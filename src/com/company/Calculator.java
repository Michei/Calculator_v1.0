package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.math.*;

public class Calculator extends JFrame {
    JButton n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    JTextField input; int sym=15;
    String j,str;int vs,vx;
    boolean ter=true; // Разрешает или запрещает ввод цифр с новой строки.
    boolean zer=true; // Первый символ в строке НОЛЬ (по умолчанию "Да").
    boolean but=false; // Нажата ли кнопка Арифметического действия.
    boolean flag=false; // Введено ли новое число.
    BigDecimal bc = new BigDecimal("0");
    MathContext mc = new MathContext(10);
    eHandler handler = new eHandler();

    public Calculator(String s) {
        super(s);
        input = new JTextField(sym);
        input.setCaretColor(Color.WHITE);
        input.setText("0");
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setCaretPosition(1);

        n1 = new JButton("1");
        n2 = new JButton("2");
        n3 = new JButton("3");
        n4 = new JButton("4");
        n5 = new JButton("5");
        n6 = new JButton("6");
        n7 = new JButton("7");
        n8 = new JButton("8");
        n9 = new JButton("9");
        n0 = new JButton("0");
        b1 = new JButton("/");
        b2 = new JButton("*");
        b3 = new JButton("-");
        b4 = new JButton("+");
        b5 = new JButton("=");
        b6 = new JButton("C");
        b7 = new JButton(",");
        b8 = new JButton("<");
        b9 = new JButton("√");
        b10 = new JButton("%");
        b11 = new JButton("π");
        b12 = new JButton("`");

        add(input);
        add(n1);add(n2);add(n3);
        add(n4);add(n5);add(n6);
        add(n7);add(n8);add(n9);
        add(n0);add(b1);add(b2);
        add(b3);add(b4);add(b5);
        add(b6);add(b7);add(b8);
        add(b9);add(b10);add(b11);
        add(b12);

        n1.addActionListener(new ButtonEventListener());
        n2.addActionListener(new ButtonEventListener());
        n3.addActionListener(new ButtonEventListener());
        n4.addActionListener(new ButtonEventListener());
        n5.addActionListener(new ButtonEventListener());
        n6.addActionListener(new ButtonEventListener());
        n7.addActionListener(new ButtonEventListener());
        n8.addActionListener(new ButtonEventListener());
        n9.addActionListener(new ButtonEventListener());
        n0.addActionListener(new ButtonEventListener());
        b1.addActionListener(handler);b2.addActionListener(handler);
        b3.addActionListener(handler);b4.addActionListener(handler);
        b5.addActionListener(handler);b6.addActionListener(handler);
        b7.addActionListener(handler);b8.addActionListener(handler);
        b9.addActionListener(handler);b10.addActionListener(handler);
        b11.addActionListener(handler);b12.addActionListener(handler);
    }

    class ButtonEventListener implements ActionListener {
        String k;
        void key (String k){   //Функция действует при нажатии кнопки от 1 до 9 (0 обрабатывается отдельно)
            this.k = k;
            if (ter){ input.setText(k);ter = false;flag=false;}
            else if (j.equals("0")) {input.setText(j+"."+k);zer=true;ter=false;flag=false;}
            else input.setText(j + k);
        }

        public void actionPerformed(ActionEvent e) {
            j = input.getText();String v = input.getText();

            vs = v.indexOf("0",-2);vx = v.indexOf(".",-2);

            if(input.getText().length() <= sym-1) {

                if (e.getSource() == n1){k="1";key(k);}
                if (e.getSource() == n2){k="2";key(k);}
                if (e.getSource() == n3){k="3";key(k);}
                if (e.getSource() == n4){k="4";key(k);}
                if (e.getSource() == n5){k="5";key(k);}
                if (e.getSource() == n6){k="6";key(k);}
                if (e.getSource() == n7){k="7";key(k);}
                if (e.getSource() == n8){k="8";key(k);}
                if (e.getSource() == n9){k="9";key(k);}
                if (e.getSource() == n0){
                    if (j.equals("0")) {input.setText(j+".0"); zer = false;ter = false;}
                    else if (!ter && vx != 1)input.setText(j + "0");
                    else if (ter && vx == 1)input.setText(j + "0");
                    else if (vx == 1)input.setText(j + "0");}
                if (ter){input.setText("0");zer=true;ter = false;flag=false;}
            }
        }
    }
    public static void main(String[] args) throws IOException, FontFormatException {
        Calculator s = new Calculator("Calculator v1.0");
        s.setVisible(true);
        Font fontb = new Font("Verdana,Arial,sans-serif", Font.BOLD, 17);
        Font fontn = new Font("DigitalDisplayRegular-ODEO.ttf", Font.BOLD, 19);
        Font fo = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\User\\IdeaProjects\\Proga\\src\\com\\company\\ds-digital-bold-italic.ttf")).deriveFont(36f);
        s.b1.setFont(fontb);s.b2.setFont(fontb);s.b3.setFont(fontb);s.b4.setFont(fontb);s.b5.setFont(fontb);s.b6.setFont(fontb);s.b7.setFont(fontb);s.b8.setFont(fontb);s.b9.setFont(fontb);s.b10.setFont(fontb);s.b11.setFont(fontb);s.b12.setFont(fontb);
        s.n1.setFont(fontn);s.n2.setFont(fontn);s.n3.setFont(fontn);s.n4.setFont(fontn);s.n5.setFont(fontn);s.n6.setFont(fontn);s.n7.setFont(fontn);s.n8.setFont(fontn);s.n9.setFont(fontn);s.n0.setFont(fontn);
        s.input.setFont(fo);
        s.input.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        s.input.setBounds(10,10,209,50);
        s.setLayout(null);
        s.b1.setBounds(10, 70, 50, 40);
        s.b2.setBounds(63, 70, 50, 40);
        s.b3.setBounds(116, 70, 50, 40);
        s.b4.setBounds(169, 70, 50, 40);
        s.b9.setBounds(10, 113, 50, 40);
        s.b10.setBounds(63, 113, 50, 40);
        s.b11.setBounds(116, 113, 50, 40);
        s.b12.setBounds(169, 113, 50, 40);
        s.n7.setBounds(10, 156, 50, 40);
        s.n8.setBounds(63, 156, 50, 40);
        s.n9.setBounds(116, 156, 50, 40);
        s.b6.setBounds(169, 156, 50, 40);
        s.n4.setBounds(10, 199, 50, 40);
        s.n5.setBounds(63, 199, 50, 40);
        s.n6.setBounds(116, 199, 50, 40);
        s.b8.setBounds(169, 199, 50, 40);
        s.n1.setBounds(10, 242, 50, 40);
        s.n2.setBounds(63, 242, 50, 40);
        s.n3.setBounds(116, 242, 50, 40);
        s.b5.setBounds(169, 242, 50, 83);
        s.n0.setBounds(10, 285, 103, 40);
        s.b7.setBounds(116, 285, 50, 40);
        s.setBounds(400, 400, 242, 378);
        s.setLocation(330,310);
        s.setResizable(false);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class eHandler implements ActionListener{
        String y;
        String trim (String y){   //Функция удаления нулей справа в числе
            this.y = y;
            int len = y.length();
            boolean ans = false;char s = 0;
            for ( int t = len-1; t>0; t--) {
                s = y.charAt(t);
                if (s == '.') { ans = true;break; }
            }
            if (ans){
                for ( int t = len-1; t>0; t--){
                    s = y.charAt(t);
                    if (s == '0') { y = y.substring(0, t); }
                    else if (s == '.') { y = y.substring(0, t);break; }
                    else break;
                }
            }return y;
        }
        BigDecimal bi; BigDecimal ba; int d;
        void calc (BigDecimal bi,BigDecimal ba,int d){  //Функция прмежуточного вычисления
            this.bi=bi;this.ba=ba;this.d=d;
            if (d==1){
                if (bi.compareTo(BigDecimal.ZERO)==0 || ba.compareTo(BigDecimal.ZERO)==0)
                {
                    input.setText("0");
                    ter = true;flag = true;but=false;
                    bc = new BigDecimal("0");
                } else {
                    bc = bi.divide(ba, 10, RoundingMode.DOWN);   //Деление
                    String y = bc.toString();
                    input.setText(trim(y));
                }
            }
            if (d==2){bc = bi.multiply(ba);   //Умножение
                String y = bc.toString();
                input.setText(trim(y));
            }
            if (d==3){bc = bi.subtract(ba);   //Вычитание
                String y = bc.toString();
                input.setText(trim(y));
            }
            if (d==4){bc = bi.add(ba);   //Сложение
                String y = bc.toString();
                input.setText(trim(y));
            }
            if (d==5) {
                if (bi.compareTo(BigDecimal.ZERO) > 0){   //Корень
                    bc = bi.sqrt(mc);
                    String y = bc.toString();
                    input.setText(trim(y));
                }
            }
            if (d==6){bc = ba.divide(BigDecimal.valueOf(100), 10, RoundingMode.DOWN);
                bc = bc.multiply(bi);}     //Процент
            String y = bc.toString();
            input.setText(trim(y));
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==b10) {   //Функция "Процент"
                if(but && flag) {ter=true;d=6;}
                if(but && !flag) {
                    ba = new BigDecimal(input.getText());

                    if (ba.compareTo(BigDecimal.ZERO)==0)
                    {
                        input.setText("0");
                        d = 6;bi = bc;
                        ter = true;flag = false;but=false;
                    } else {
                        calc(bi,ba,d);
                        d = 6;bi = bc;
                        ter = true;flag = false;but=false;
                    }
                }
                if (!but && !flag){   // Если не введено новое число
                    bi = new BigDecimal(input.getText());d = 6;
                    but = true;ter = true;flag = true;
                }
            }
            if (e.getSource()==b9){   //Извлечение квадратного корня
                bi = new BigDecimal(input.getText());
                d = 5;
                if (bi.compareTo(BigDecimal.ZERO)==0) {
                    String y = "0";
                    input.setText(y);
                    bi = bc;
                    ter = true;flag = false;but=false;
                    bc = new BigDecimal("0");
                } else {
                    calc(bi,ba,d);
                    d = 5;bi = bc;
                    ter = true;flag = false;but=false;
                }
            }
            if (e.getSource()==b11) {input.setText("3.1415926535");}   //Вставляет число Пи

            if (e.getSource()==b1){   //Кнопка "Деление"
                if(but && flag) {ter=true;d=1;}
                else if (but && !flag) {
                    ba = new BigDecimal(input.getText());
                    if (bi.compareTo(BigDecimal.ZERO)==0 || ba.compareTo(BigDecimal.ZERO)==0)
                    {
                        String y = "0";
                        input.setText(y);
                        d = 1;bi = bc;
                        ter = true;flag = true;but=false;
                    } else {
                        calc(bi,ba,d);
                        d = 1;bi = bc;
                        ter = true;flag = true;
                    }
                }
                if (!but && !flag){   // Если не введено второе число
                    bi = new BigDecimal(input.getText());d = 1;
                    but = true;ter = true;flag = false;
                    if (bi.compareTo(BigDecimal.ZERO) == 0) {
                        d = 1;
                        ter = true;
                        flag = true;
                    } else {
                        bi = new BigDecimal(input.getText());
                        d = 1;
                        but = true;
                        ter = true;
                        flag = true;
                    }
                }
            }
            if (e.getSource()==b2){   //Кнопка "Умножение"
                if(but && flag) {ter=true;d=2;}
                else if (but && !flag) {
                    ba = new BigDecimal(input.getText());
                    calc(bi,ba,d);
                    d = 2;bi = bc;
                    ter = true;flag=true;
                }
                if (!but && !flag){bi = new BigDecimal(input.getText());d=2;but=true;ter = true;flag=true;}
            }
            if (e.getSource()==b3){   //Кнопка "Вычитание"
                if(but && flag) {ter=true;d=3;}
                else if (but && !flag) {
                    ba = new BigDecimal(input.getText());
                    calc(bi,ba,d);
                    d = 3;bi = bc;
                    ter = true;flag=true;
                }
                if (!but && !flag){bi = new BigDecimal(input.getText());
                    d=3;but=true;ter=true;flag=true;}
            }

            if (e.getSource()==b4){   // Кнопка "Сложение"
                if(but && flag) {ter=true;d=4;}
                else if (but && !flag) {
                    ba = new BigDecimal(input.getText());
                    calc(bi,ba,d);
                    d = 4;bi = bc;
                    ter = true;flag=true;
                }
                if (!but && !flag){bi = new BigDecimal(input.getText());d=4;but=true;ter = true;flag=true;}
            }

            if (e.getSource()==b5){
                ba = new BigDecimal(input.getText()); ter = false;flag=true;
                if (d==1){         //Деление
                    if (ba.compareTo(BigDecimal.ZERO)==0 || bi.compareTo(BigDecimal.ZERO)==0)
                    {
                        input.setText("0");
                        ter = true;flag = true;but=false;
                        bc = new BigDecimal("0");
                    } else {
                        //System.out.println("bi="+bi+"   ba"+ba+"   bc="+bc);
                        calc(bi,ba,d);bi = bc;
                        ter = true;but=false;flag=false;
                    }
                }
                if (d==2){        //Умножение
                    calc(bi,ba,d);bi = bc;
                    ter = true;but=false;flag=false;
                }
                if (d==3){        //Вычитание
                    calc(bi,ba,d);bi = bc;
                    ter = true;but=false;flag=false;
                }
                if (d==4){        //Сложение
                    calc(bi,ba,d);bi = bc;
                    ter = true;but=false;flag=false;
                }
                if (d==5){        //Корень
                    if (ba.compareTo(BigDecimal.ZERO)==0 || bi.compareTo(BigDecimal.ZERO)==0)
                    {
                        input.setText("0");
                        ter = true;but=false;flag = true;
                        bc = new BigDecimal("0");
                    } else {
                        calc(bi,ba,d);bi = bc;
                        ter = true;but=false;flag=false;
                    }
                }
                if (d==6){         //Проценты
                    if (ba.compareTo(BigDecimal.ZERO)==0 || bi.compareTo(BigDecimal.ZERO)==0)
                    {
                        input.setText("0");
                        ter = true;flag = true;but=false;
                        bc = new BigDecimal("0");
                    } else {
                        calc(bi,ba,d);bi = bc;
                        ter = true;but=false;flag=false;
                    }
                }
            }
            if (e.getSource()==b6){input.setText("0"); //  Кнопка "С"
                bi= new BigDecimal("0");ba= new BigDecimal("0");bc= new BigDecimal("0");
                zer = true; ter = true;but=false;flag=false;}

            if (e.getSource()==b7){    //  Вставляет символ "."
                str = input.getText();
                int x = str.indexOf('.',-2);
                if (x==-1) {input.setText(input.getText() + "."); ter = false;}
            }
            if (e.getSource()==b8){    //  Стирает один символ справа
                String text = input.getText();
                int t = input.getText().length();
                if (t>1){text = text.substring(0,t-1);input.setText(text);
                    bi= new BigDecimal(input.getText());}
                if (t==1){input.setText("0");bi= new BigDecimal(input.getText());ter = true;}
            }
        }
    }
}