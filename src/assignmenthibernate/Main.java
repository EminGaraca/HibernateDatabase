package assignmenthibernate;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Baza podataka uposlenika - odabir opcija");
        JButton button1 = new JButton("Prikaz svih uposlenika");
        f.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame prikaz = new JFrame("Prikaz svih uposlenika");
                JTextArea area = new JTextArea();
                prikaz.add(area);
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = null;
                String hql="from Employees";
                Query query=session.createQuery(hql);
                List <Employees> employees = null;
                try {
                    tx1 = session.beginTransaction();
                    
                    employees=query.list();
                    
                    tx1.commit();
                    
                } catch (HibernateException ex) {
                    if (tx1 != null) {
                        tx1.rollback();
                    }
                } finally {
                    session.close();
                }
                
                for(int i=0 ; i<employees.size(); i++) {
                    area.setText(employees.toString().replace("[", "").replace(",", "").replace("]", ""));
                }

                prikaz.setLayout(
                        new FlowLayout());
                prikaz.setDefaultCloseOperation(EXIT_ON_CLOSE);

                prikaz.setSize(
                        600, 400);
                prikaz.setVisible(
                        true);

            }
        });
        JButton button2 = new JButton("Prikaz uposlenika sa platom većom od 1000");
        f.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame prikaz = new JFrame("Prikaz svih uposlenika");
                JTextArea area = new JTextArea();
                prikaz.add(area);
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = null;
                String hql="from Employees where salary>1000";
                Query query=session.createQuery(hql);
                List <Employees> employees = null;
                try {
                    tx1 = session.beginTransaction();
                    
                    employees=query.list();
                    
                    tx1.commit();
                    
                } catch (HibernateException ex) {
                    if (tx1 != null) {
                        tx1.rollback();
                    }
                } finally {
                    session.close();
                }
                
                for(int i=0 ; i<employees.size(); i++) {
                    area.setText(employees.toString().replace("[", "").replace(",", "").replace("]", ""));
                }

                prikaz.setLayout(
                        new FlowLayout());
                prikaz.setDefaultCloseOperation(EXIT_ON_CLOSE);

                prikaz.setSize(
                        600, 400);
                prikaz.setVisible(
                        true);

            }
        });
        JButton button3 = new JButton("Izmjena podataka o uposleniku");
        f.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Promjena podataka");
                JButton button1 = new JButton("Izmjena Imena");
                frame.add(button1);
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Promjena imena");
                        JTextField jTextField1 = new JTextField(" ID ");
                        frame.add(jTextField1);
                        JTextField jTextField2 = new JTextField(" Novo ime ");
                        frame.add(jTextField2);
                        JButton button1 = new JButton("Izmjeni ime");
                        frame.add(button1);
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                UpdateKlasa promjenaImena = new UpdateKlasa();
                                promjenaImena.promijeniIme(Integer.parseInt(jTextField1.getText()), jTextField2.getText());
                            }
                        });
                        frame.setLayout(
                                new FlowLayout());
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                        frame.setSize(
                                600, 400);
                        frame.setVisible(
                                true);
                    }
                });
                JButton button2 = new JButton("Izmjena godina");
                frame.add(button2);
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Promjena godina");
                        JTextField jTextField3 = new JTextField(" ID ");
                        frame.add(jTextField3);
                        JTextField jTextField4 = new JTextField(" Nove godine  ");
                        frame.add(jTextField4);
                        JButton button2 = new JButton("Izmjeni godine");
                        frame.add(button2);
                        button2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                UpdateKlasa updateKlasa = new UpdateKlasa();
                                updateKlasa.promijeniGodine(Integer.parseInt(jTextField3.getText()), Integer.parseInt(jTextField4.getText()));

                            }
                        });
                        frame.setLayout(
                                new FlowLayout());
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                        frame.setSize(
                                600, 400);
                        frame.setVisible(
                                true);
                    }
                });
                JButton button3 = new JButton("Izmjena adrese");
                frame.add(button3);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Promjena adrese");
                        JTextField jTextField5 = new JTextField(" ID ");
                        frame.add(jTextField5);
                        JTextField jTextField6 = new JTextField(" Nova adresa  ");
                        frame.add(jTextField6);
                        JButton button3 = new JButton("Izmjeni adresu");
                        frame.add(button3);
                        button3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                UpdateKlasa updateKlasa = new UpdateKlasa();
                                updateKlasa.promijeniAdresu(Integer.parseInt(jTextField5.getText()), jTextField6.getText());
                            }
                        });
                        frame.setLayout(
                                new FlowLayout());
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        frame.setSize(
                                600, 400);
                        frame.setVisible(
                                true);
                    }
                });
                JButton button4 = new JButton("Izmjena plate");
                frame.add(button4);
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Promjena plate");
                        JTextField jTextField7 = new JTextField(" ID ");
                        frame.add(jTextField7);
                        JTextField jTextField8 = new JTextField(" Nova plata  ");
                        frame.add(jTextField8);
                        JButton button3 = new JButton("Izmjeni platu");
                        frame.add(button3);
                        button3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                UpdateKlasa updateKlasa = new UpdateKlasa();
                                updateKlasa.promijeniPlatu(Integer.parseInt(jTextField7.getText()), Integer.parseInt(jTextField8.getText()));
                            }
                        });
                        frame.setLayout(
                                new FlowLayout());
                        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                        frame.setSize(
                                600, 400);
                        frame.setVisible(
                                true);
                    }
                });
                frame.setLayout(
                        new FlowLayout());
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                frame.setSize(
                        600, 400);
                frame.setVisible(
                        true);
            }

        });

        JButton button4 = new JButton("Brisanje uposlenika");
        f.add(button4);
        button4.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                JFrame frame = new JFrame("Brisanje korisnika");
                frame.setLayout(new FlowLayout());
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setVisible(true);
                JTextField jTextField = new JTextField("Unesi id");
                frame.add(jTextField);
                JButton jButton = new JButton("Izbriši korisnika");
                frame.add(jButton);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BrisanjeKorisnika brisanjeKorisnika = new BrisanjeKorisnika();
                        brisanjeKorisnika.izbrisiKorisnika(Integer.parseInt(jTextField.getText()));
                    }
                });
            }
        }
        );
        JButton button5 = new JButton("Unos novog uposlenika");
        f.add(button5);
        button5.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                JFrame unosUposlenika = new JFrame("Unos uposlenika");
                JTextField jTextField1 = new JTextField("Ime uposlenika");
                unosUposlenika.add(jTextField1);
                JTextField jTextField2 = new JTextField("Broj godina");
                unosUposlenika.add(jTextField2);
                JTextField jTextField3 = new JTextField("Adresa");
                unosUposlenika.add(jTextField3);
                JTextField jTextField4 = new JTextField("Plata uposlenika");
                unosUposlenika.add(jTextField4);
                JButton button = new JButton("Unesi podatke");
                unosUposlenika.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UnosUposlenika frame1 = new UnosUposlenika();
                        frame1.unosUposlenika(jTextField1.getText(), Integer.parseInt(jTextField2.getText()), jTextField3.getText(), Integer.parseInt(jTextField4.getText()));
                    }
                });
                unosUposlenika.setLayout(new FlowLayout());
                unosUposlenika.setDefaultCloseOperation(EXIT_ON_CLOSE);
                unosUposlenika.setSize(600, 400);
                unosUposlenika.setVisible(true);
            }
        });
        f.setLayout(
                new FlowLayout());
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        f.setSize(
                600, 400);
        f.setVisible(
                true);
    }
}
