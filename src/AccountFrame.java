import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;

public class AccountFrame extends JFrame {
    JLabel accnNoLBL, ownerLBL, balanceLBL, cityLBL, genderLBL, amountLBL;
    JTextField accNoTXT, ownerTXT, balanceTXT, amountTXT;
    JComboBox<City> citiesCMB;

    JButton  newBTN, saveBTN, showBTN, quitBTn, depositBtn, withdrawBTN;
    JRadioButton maleRDB, femaleRDB;
    ButtonGroup genderBTNGRP;

    JList<Account> accountJList;
    JPanel p1,p2,p3,p4,p5;

    Set<Account> accountSet = new TreeSet<>();
    Account acc, x;
    boolean newRec = true;

    //ComboBoxData
    DefaultComboBoxModel<City> citiesCMBMDL;
    DefaultListModel<Account> accountDefaultListModel;

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
        accNoTXT = new JTextField(); accNoTXT.setEnabled(false);
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
        genderBTNGRP.add(maleRDB);
        genderBTNGRP.add(femaleRDB);


    }

    public static void main(String[] args) {
        AccountFrame accountFrame = new AccountFrame();
        accountFrame.setVisible(true);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
