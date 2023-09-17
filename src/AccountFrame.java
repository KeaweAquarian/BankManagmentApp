import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class AccountFrame extends JFrame {
    JLabel  ownerLBL, accnNoLBL,balanceLBL, cityLBL, genderLBL, amountLBL;
    JTextField accNoTXT, ownerTXT, balanceTXT, amountTXT;
    JComboBox<City> citiesCMB;

    JButton  newBTN, saveBTN, showBTN, quitBTn, depositBtn, withdrawBTN;
    JRadioButton maleRDB, femaleRDB;
    ButtonGroup genderBTNGRP;

    JList<Account> accountsLST;
    JPanel p1,p2,p3,p4,p5;

    Set<Account> accountSet = new TreeSet<>();
    Account acc, x;
    boolean newRec = true;

    //ComboBoxData
    DefaultComboBoxModel<City> citiesCMBMDL;
    DefaultListModel<Account> accountsLSTMDL;

    //Table Data
    JTable table;
    DefaultTableModel tableModel;
    ArrayList<Transactions> transList = new ArrayList<>();

    public AccountFrame() {
        super("Account Operations");
        setLayout(null);
        setSize(600, 400);

        accnNoLBL = new JLabel("Account No.");
        ownerLBL = new JLabel("Owner");
        balanceLBL = new JLabel("Balance");
        cityLBL = new JLabel("City");
        genderLBL = new JLabel("Gender");
        amountLBL = new JLabel("Amount");

        // TextFields
        accNoTXT = new JTextField();
        ownerTXT = new JTextField();
        balanceTXT = new JTextField(); balanceTXT.setEnabled(false);
        amountTXT = new JTextField();
        amountTXT.setPreferredSize(new Dimension(150, 25));

        //ComboBox
        citiesCMBMDL = new DefaultComboBoxModel<City>();
        citiesCMBMDL.addElement(null);
        citiesCMBMDL.addElement(new City("Brooklen", "New York"));
        citiesCMBMDL.addElement(new City("Dothan", "Alabama"));
        citiesCMBMDL.addElement(new City("Panama", "Florida"));
        citiesCMBMDL.addElement(new City("Miami", "Florida"));

        //Adding data to JComboBOx
        citiesCMB = new JComboBox<City>(citiesCMBMDL);

        //Radio Button
        maleRDB = new JRadioButton("Male", true);
        femaleRDB = new JRadioButton("Female");
        genderBTNGRP = new ButtonGroup();
        genderBTNGRP.add(maleRDB);
        genderBTNGRP.add(femaleRDB);

        //Buttons
        newBTN = new JButton("New");
        saveBTN = new JButton("Save");
        showBTN = new JButton("Show");
        quitBTn = new JButton("Quit");
        depositBtn = new JButton("Deposit");
        withdrawBTN = new JButton("WithDraw");

        //Table
        accountsLSTMDL = new DefaultListModel<>();
        accountsLST = new JList<>(accountsLSTMDL);

        //Panels
        p1 = new JPanel(); p1.setBounds(5,5,300,150);
        p1.setLayout(new GridLayout(5,2));

        p2 = new JPanel(); p2.setBounds(5,155,300,40);
        p2.setLayout(new FlowLayout());

        p3 = new JPanel(); p3.setBounds(5,195,600,40);
        p3.setLayout(new FlowLayout());

        p4 = new JPanel(); p4.setBounds(305,5,300,190);
        p4.setLayout(new BorderLayout());

        p5 = new JPanel(); p5.setBounds(5,240,580,120);
        p5.setLayout(new BorderLayout());



        //Adding componets to panel
          p1.add(accnNoLBL);
          p1.add(accNoTXT);
        p1.add(ownerTXT);
        p1.add(ownerLBL);
        p1.add(ownerTXT);
        p1.add(balanceLBL);
        p1.add(balanceTXT);
        p1.add(cityLBL);
        p1.add(citiesCMB);
        p1.add(maleRDB);
        p1.add(femaleRDB);

        p2.add(newBTN);
        p2.add(saveBTN);
        p2.add(showBTN);
        p2.add(quitBTn);

        p3.add(amountLBL);
        p3.add(amountTXT);
        p3.add(depositBtn);
        p3.add(withdrawBTN);

        p4.add(accountsLST);



        //Adding panels to frame
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        //Table Creation
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("TrsNO");
        tableModel.addColumn("TrsDate");
        tableModel.addColumn("TrsType");
        tableModel.addColumn("TrsAmount");

        JScrollPane scrollPane = new JScrollPane(table);
        p5.add(scrollPane);

        //Functionality
        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accNoTXT.setText("");
                ownerTXT.setText("");
                citiesCMB.setSelectedIndex(0);
                maleRDB.setSelected(true);
                balanceTXT.setText("");
                amountTXT.setText("");
                newRec = true;
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newRec){
                    //Insertion
                    if (ownerTXT.getText().length() !=0){
                        acc = new Account(
                                ownerTXT.getText(), (City) citiesCMB.getSelectedItem(),
                                maleRDB.isSelected() ? 'M' : 'F');
                        accNoTXT.setText(String.valueOf(acc.accountNumber));
                        accountSet.add(acc);
                        accountsLSTMDL.addElement(acc);
                        newRec = false;
                    }else {
                        JOptionPane.showMessageDialog(null,"Fill All fields Before Saving");
                    }
                }else {

                    //Updating
                    accountSet.remove(acc);

                    int a = Integer.parseInt(accNoTXT.getText());
                    String o = ownerTXT.getText();
                    City c = (City) citiesCMB.getSelectedItem();

                    char g = maleRDB.isSelected()? 'M':'F';
                    double b = Double.parseDouble(balanceTXT.getText());
                    acc = new Account(a, o, c, g, b);
                    accountSet.add(acc);
                    accountsLSTMDL.setElementAt(acc,accountsLST.getSelectedIndex());
                    newRec = false;
                }
            }
        });

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                Iterator<Account> it = accountSet.iterator();

                while (it.hasNext()){
                    s += it.next().toString() + "\n";
                    JOptionPane.showMessageDialog(null,s);
                }


            }
        });

        depositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newRec && amountTXT.getText().length() != 0){

                    //Add Transactions to table
                    Transactions t = new Transactions(acc, LocalDate.now(),
                            'D', Double.parseDouble(amountTXT.getText()));
                    DisplayTransactionInTable(t);
                    //Perform deposit from account
                    acc.deposit(Double.parseDouble(amountTXT.getText()));
                    balanceTXT.setText(String.valueOf(acc.balance));
                }
            }

            private void DisplayTransactionInTable(Transactions t) {
                //Displaying data into table
                tableModel.addRow(new Object[]{
                        t.getTrsNo(),
                        t.getDate(),
                        t.getOperation(),
                        t.getAmount(),
                        t.getAcc()

                });

                //Adding object to array list
                transList.add(t);
            }
        });

        withdrawBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newRec && amountTXT.getText().length() !=0){

                    //Adding Transaction to table
                    Transactions t = new Transactions(
                            acc, LocalDate.now(),
                            'W',
                            Double.parseDouble(amountTXT.getText()));
                    DisplayTransactionInTable(t);

                    //Perform withdraw on account
                    acc.withdraw(Double.parseDouble(amountTXT.getText()));
                    balanceTXT.setText(String.valueOf(acc.balance));

                }
            }

            private void DisplayTransactionInTable(Transactions t) {
                //Displaying data into table
                tableModel.addRow(new Object[]{
                        t.getTrsNo(),
                        t.getDate(),
                        t.getOperation(),
                        t.getAmount(),
                        t.getAcc()

                });

                //Adding object to array list
                transList.add(t);
            }
        });

        accountsLST.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                acc = x = accountsLST.getSelectedValue();

                accNoTXT.setText(String.valueOf(acc.accountNumber));
                ownerTXT.setText(acc.owner);
                citiesCMBMDL.setSelectedItem(acc.city);

                if (acc.gender == 'M') maleRDB.setSelected(true);
                else femaleRDB.setSelected(true);

                balanceTXT.setText(String.valueOf(acc.balance));
                amountTXT.setEnabled(true);
                depositBtn.setEnabled(true);
                newRec = false;

                //Clear table
                for (int i = tableModel.getRowCount() -1; i>0; i--){
                    tableModel.removeRow(i);
                }

                //Get Transactions to selected Account
                SearchTransactionList(acc.accountNumber);
            }

            private void SearchTransactionList(int accountNumber) {
                List<Transactions> filteredList = new ArrayList<>();

                //iterate throught the list
                for (Transactions t: transList){

                    //filter values that contains trsNo
                    if (t.getAcc().accountNumber == accountNumber){
                        filteredList.add(t);
                    }
                }

                //Display the filtered List
                for (int i = 0; i < filteredList.size(); i++) {
                    tableModel.addRow(new Object[]{
                            filteredList.get(i).getTrsNo(),
                            filteredList.get(i).getDate(),
                            filteredList.get(i).getOperation(),
                            filteredList.get(i).getAmount()
                });

                }
            }
        });




    }

    public static void main(String[] args) {
        AccountFrame accountFrame = new AccountFrame();
        accountFrame.setVisible(true);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
