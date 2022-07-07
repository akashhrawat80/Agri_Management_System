package com.company;
import javax.swing.*;

import com.company.menu.*;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.model.ContentType;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Vector;
public class Calf_Management extends JFrame implements ActionListener,ItemListener{
    public static HealthRecord h;
    public static addBreed b;

    Vector breedVector,StatusVector,colorVector,AnimalTypesVector,DamVector,GroupVector,HealthVector,ManagementCodesVector,SireVector,LocationVector;
    public DefaultComboBoxModel<String> comboBreed,comboStatus,comboColor,comboAnimalTypes,comboDam,comboGroup,comboHealth,comboLocation,comboManagementCodes,comboSire;

    JButton cancelReports, addReports, clearAllReports, removeReports;
    JList<String> areaReports;
    JScrollPane paneReports;
    JTextField textReports;
    DefaultListModel<String> lReports;
    BufferedWriter fileReports;
    BufferedReader readerReports;
    //.........Calender variables...............
    private String[] imageFileNames = { "0.png", "1.png", "2.png", "3.png", "4.png", "5.png"};

    private String _dataFile;
    private com.mindfusion.scheduling.Calendar calndar;
    private String imagedir = "Resources/";
    private static final long serialVersionUID = 1L;
    //..........................................
    //......inventory variables...
    JTextField LocationInventory,GroupInventory;
    JButton InventoryCheck,AddInventory,TransferInventory,LossInventory,EditInventory;
    JTable tableInventory;
    TableModel modelInventory;
    //.........Health...................
    JTextField AnimalIdHealth,AlternateIdHealth;
    JComboBox<String> currentStatusText;
    JButton AddHealth,EditHealth,RemoveHealth;
    JTable tableHealth;
    TableModel modelHealth;
    //..........Notes..............
    JButton AddNotes,removeNotes,EditNotes,updateNotes;
    JTable tableNotes;
    TableModel modelNotes;
    //Sell....................................
    JButton EditSell,SellBtn,RemoveSell,SelectSell;
    JTextField LocationSell,GroupSell;
    JComboBox ProductsSell;
    JRadioButton AnimalToSell,AnimalsSold,SoldProducts;
    JTable tableSell;
    TableModel modelSell;
    //.....Milk test......................................
    JTable tableMilk;
    TableModel modelMilk;
    JTextField lactationMilk,lactationMilk1;
    JButton recordMilk;
    //....Feed................................................
    JTable tableFeed;
    TableModel modelFeed;
    JTextField idFeed,altidFeed;
    JButton addFeed,EditFeed,RemoveFeed;
    JComboBox statusFeed;

    //.........Weight.....................................
    JTable tableWeight;
    TableModel modelWeight;
    JTextField idWeight,altidWeight;
    JButton addWeight,EditWeight,RemoveWeight;
    JComboBox statusWeight;
    //....Wean................................................
    JTable tableWean;
    TableModel modelWean;
    JTextField idWean,altidWean;
    JButton addWean,EditWean,RemoveWean;
    JComboBox statusWean;

    //....Birth................................................
    JTable tableBirth;
    TableModel modelBirth;
    JTextField idBirth,altidBirth;
    JButton addBirth,EditBirth,RemoveBirth;
    JComboBox statusBirth;

    //....Mating................................................
    JTable tableMating;
    TableModel modelMating;
    JTextField idMating,altidMating;
    JButton addMating,EditMating,RemoveMating;
    JComboBox statusMating;
    //.................Bloodline.............................
    JTree tree;
    //........................................................
    JLabel group1;
    JLabel location1;
    JLabel id;
    JLabel location;
    JLabel Group;
    JLabel Animal_id;
    JLabel gender;
    JLabel breed;
    JLabel color;
    JLabel status;
    JLabel mgnt_code;
    JLabel health_code;
    JLabel setup_animal_id,setup_alt_id,right_ear,left_ear,electronic_id;
    JTextField t1,t2,t3,t4,t5,w1,w2,w3,w4,parity_count;
    JButton cancel,search,exit;
    JMenuBar bar;
    JCheckBoxMenuItem a1,a2,a3,a4,a5,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13;
    JMenuItem i1,i2,i3,i4,i5,i6,i7,back,printer,about,healt_monitor;
    JMenu file,add,main_animal_id,query,help;
    JTabbedPane catalog;
    JCheckBox breeding_stock;
    int i;
    public JComboBox<String> group1_list,loaction1_list,animal_type,location_box,id_list,group_list,gender_list,breed_list,color_list,status_list,mgnt_code_list,health_code_list,Sire_name,Dam_name;
    JPanel inventory,sell,reports,feed,milk_test,setup,notes,calender,blood_line,mating,birth,wean,health,weeight;
    public Calf_Management() {
        bar = new JMenuBar();
        bar.setBounds(0, 0, 841, 20);
        add(bar);

        file = new JMenu("File");
        bar.add(file);
        add = new JMenu("Add/Edit");
        bar.add(add);
        main_animal_id = new JMenu("Main Animal ID");
        bar.add(main_animal_id);
        query = new JMenu("Query");
        bar.add(query);
        help = new JMenu("Help");
        bar.add(help);

        i1 = new JMenuItem("Animal Types");
        i1.addActionListener(this);
        add.add(i1);
        i2 = new JMenuItem("Locations");
        i2.addActionListener(this);
        add.add(i2);
        i3 = new JMenuItem("Groups");
        i3.addActionListener(this);
        add.add(i3);
        add.addSeparator();
        i4 = new JMenuItem("Property Lists");
        i4.addActionListener(this);
        add.add(i4);
        i5 = new JMenuItem("Contemporary Groups");
        i5.addActionListener(this);
        add.add(i5);
        add.addSeparator();
        i6 = new JMenuItem("Defined Events");
        add.add(i6);
        add.addSeparator();
        i7 = new JMenuItem("Groups of Events ");
        add.add(i7);

        printer = new JMenuItem("Printer Setup");//use printerjob
        printer.addActionListener(this);
        file.add(printer);
        file.addSeparator();
        healt_monitor = new JMenuItem("Health Monitoring");
        healt_monitor.addActionListener(this);
        file.add(healt_monitor);
        file.addSeparator();
        back = new JMenuItem("Return to main page");
        back.addActionListener(this);
        file.add(back);

        a1 = new JCheckBoxMenuItem("Animal ID");
        main_animal_id.add(a1);
        a2 = new JCheckBoxMenuItem("Alernate ID");
        main_animal_id.add(a2);
        a3 = new JCheckBoxMenuItem("Right Ear Tag");
        main_animal_id.add(a3);
        a4 = new JCheckBoxMenuItem("Left Ear Tag");
        main_animal_id.add(a4);
        a5 = new JCheckBoxMenuItem("Electronic ID");
        main_animal_id.add(a5);

        q1 = new JCheckBoxMenuItem("Show Non-Living only");
        query.add(q1);
        q2 = new JCheckBoxMenuItem("Show Living only");
        query.add(q2);
        q3 = new JCheckBoxMenuItem("Show all");
        query.add(q3);
        query.addSeparator();
        q4 = new JCheckBoxMenuItem("Show Non Breeding");
        query.add(q4);
        q5 = new JCheckBoxMenuItem("Show Breeding");
        query.add(q5);
        q6 = new JCheckBoxMenuItem("Show Both");
        query.add(q6);
        query.addSeparator();
        q7 = new JCheckBoxMenuItem("Show Males");
        query.add(q7);
        q8 = new JCheckBoxMenuItem("Show Females");
        query.add(q8);
        q9 = new JCheckBoxMenuItem("Show Both");
        query.add(q9);
        query.addSeparator();
        q10 = new JCheckBoxMenuItem("Show Identified");
        query.add(q10);
        q11 = new JCheckBoxMenuItem("Show Unidentified");
        query.add(q11);
        q12 = new JCheckBoxMenuItem("Show Both");
        query.add(q12);
        query.addSeparator();
        q13 = new JCheckBoxMenuItem("Show General");
        query.add(q13);

        about = new JMenuItem("About");
        help.add(about);

        id = new JLabel("Animal Type");
        id.setBounds(2, 15, 120, 25);
        id.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(id);
        String[] type = {"<types>", "Cattle", "Dairy", "Hogs", "Horses", "Ponies", "Sheeps"};
        animal_type = new JComboBox<>(type);
        animal_type.setBounds(2, 36, 100, 17);
        animal_type.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(animal_type);

        location = new JLabel("Location");
        location.setBounds(110, 15, 120, 25);
        location.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(location);
        LocationVector = new Vector();
        comboLocation = new DefaultComboBoxModel<>(LocationVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Location.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboLocation.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        location_box = new JComboBox<>(comboLocation);
        location_box.addItem("");
        location_box.addItem("<AllLocations>");
        location_box.setBounds(110, 36, 130, 17);
        location_box.setFont(new Font("Tahoma", Font.BOLD, 13));
        location_box.addItemListener(this);
        add(location_box);

        Group = new JLabel("Group");
        Group.setBounds(250, 15, 120, 25);
        Group.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(Group);
        GroupVector = new Vector();
        comboGroup = new DefaultComboBoxModel<>(GroupVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Group.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboGroup.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        group_list = new JComboBox<>(comboGroup);
        group_list.addItem("");
        group_list.addItem("<Add/Edit>");
        group_list.setBounds(250, 36, 112, 17);
        group_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        group_list.addItemListener(this);
        add(group_list);

        Animal_id = new JLabel("Animal_ID");
        Animal_id.setBounds(370, 15, 120, 25);
        Animal_id.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(Animal_id);
        String[] ids = {"<New>", "Calf_009", "Calf_0010", "Cow_8514", "Dairy Cow_01", "Dairy Cow_02", "Dairy Cow_02A", "Dairy Cow_03", "Dairy Cow_04", "Dairy Cow_04A", "Dairy Cow_04B", "Dairy Cow_05"};
        id_list = new JComboBox<>(ids);
        id_list.setBounds(370, 36, 125, 17);
        id_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(id_list);

        search = new JButton("search");
        search.setBounds(500, 36, 100, 17);
        search.setBackground(Color.BLUE.darker());
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        catalog = new JTabbedPane();
        inventory = new JPanel();
        sell = new JPanel();
        weeight = new JPanel();
        reports = new JPanel();
        feed = new JPanel();
        milk_test = new JPanel();
        setup = new JPanel();
        notes = new JPanel();
        calender = new JPanel();
        blood_line = new JPanel();
        mating = new JPanel();
        birth = new JPanel();
        wean = new JPanel();
        health = new JPanel();

        catalog.add("Inventory", inventory);
        catalog.add("Sell", sell);
        catalog.add("Weight", weeight);
        catalog.add("Reports", reports);
        catalog.add("Feed", feed);
        catalog.add("Milk Test", milk_test);
        catalog.add("Setup", setup);
        catalog.add("Notes", notes);
        catalog.add("Calender", calender);
        catalog.add("Blood Line", blood_line);
        catalog.add("Mating", mating);
        catalog.add("Birth", birth);
        catalog.add("Wean", wean);
        catalog.add("Health", health);

        catalog.setBounds(2, 55, 820, 400);
        add(catalog);
        //.................Birth.............................................................
        birth.setLayout(null);
        JLabel lbirth = new JLabel("Animal ID");
        lbirth.setBounds(20, 10, 50, 20);
        birth.add(lbirth);
        JLabel l1birth = new JLabel("Alternate ID");
        l1birth.setBounds(20, 30, 50, 20);
        birth.add(l1birth);
        JLabel pbirth = new JLabel("Current Status");
        pbirth.setBounds(20, 50, 50, 20);
        birth.add(pbirth);
        String arrbirth[] = {" "};
        statusBirth = new JComboBox(arrbirth);
        statusBirth.setBounds(70, 50, 150, 20);
        birth.add(statusBirth);

        addBirth = new JButton("<html>Add</html>");
        addBirth.setBounds(10, 290, 90, 40);
        birth.add(addBirth);
        EditBirth = new JButton("<html>Edit</html>");
        EditBirth.setBounds(110, 290, 90, 40);
        birth.add(EditBirth);
        RemoveBirth = new JButton("<html>Remove</html>");
        RemoveBirth.setBounds(210, 290, 90, 40);
        birth.add(RemoveBirth);
        idBirth = new JTextField();
        idBirth.setEditable(false);
        idBirth.setBounds(70, 10, 150, 20);
        birth.add(idBirth);
        altidBirth = new JTextField();
        altidBirth.setEditable(false);
        altidBirth.setBounds(70, 30, 150, 20);
        birth.add(altidBirth);
        String[] columnsBirth = {"Animal ID", "Age", "Oty"};
        Object[][] rowsBirth = {};
        modelBirth = new DefaultTableModel(rowsBirth, columnsBirth);
        tableBirth = new JTable(modelBirth);
        JScrollPane paneBirth = new JScrollPane(tableBirth, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneBirth.setBounds(10, 90, 750, 200);
        paneBirth.setBackground(Color.WHITE.brighter());
        birth.add(paneBirth);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datepanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datepicker = new JDatePickerImpl(datepanel, new DateLabelFormatter());
        datepicker.setBounds(2, 2, 120, 20);
        birth.add(datepicker);
        //..............Bloodline................................................................
        DefaultMutableTreeNode A=new DefaultMutableTreeNode("Bull 09");
        DefaultMutableTreeNode B=new DefaultMutableTreeNode("Bull 09");
        DefaultMutableTreeNode C=new DefaultMutableTreeNode("Bull 09");
        A.add(B);
        B.add(C);
        tree=new JTree(A);
        blood_line.add(tree);
        //.........................................................................................
        //........Mating...........................................................................
        mating.setLayout(null);
        JLabel lmating = new JLabel("Animal ID");
        lmating.setBounds(20, 10, 50, 20);
        mating.add(lmating);
        JLabel l1mating = new JLabel("Alternate ID");
        l1mating.setBounds(20, 30, 50, 20);
        mating.add(l1mating);
        JLabel pmating = new JLabel("Current Status");
        pmating.setBounds(20, 50, 50, 20);
        mating.add(pmating);
        String arrmating[] = {" "};
        statusMating = new JComboBox(arrmating);
        statusMating.setBounds(70, 50, 150, 20);
        mating.add(statusMating);

        addMating = new JButton("<html>Add</html>");
        addMating.setBounds(10, 290, 90, 40);
        mating.add(addMating);
        EditMating = new JButton("<html>Edit</html>");
        EditMating.setBounds(110, 290, 90, 40);
        mating.add(EditMating);
        RemoveMating = new JButton("<html>Remove</html>");
        RemoveMating.setBounds(210, 290, 90, 40);
        mating.add(RemoveMating);
        idMating = new JTextField();
        idMating.setEditable(false);
        idMating.setBounds(70, 10, 150, 20);
        mating.add(idMating);
        altidMating = new JTextField();
        altidMating.setEditable(false);
        altidMating.setBounds(70, 30, 150, 20);
        mating.add(altidMating);
        String[] columnsMating = {"Animal ID", "Age", "Oty"};
        Object[][] rowsMating = {};
        modelMating = new DefaultTableModel(rowsMating, columnsMating);
        tableMating = new JTable(modelMating);
        JScrollPane paneMating = new JScrollPane(tableMating, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneMating.setBounds(10, 90, 750, 200);
        paneMating.setBackground(Color.WHITE.brighter());
        mating.add(paneMating);

        //setup........................................................................
        setup_animal_id = new JLabel("Animal ID");
        setup_animal_id.setBounds(2, 2, 120, 25);
        setup_animal_id.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.setLayout(null);
        setup.add(setup_animal_id);
        t1 = new JTextField(10);
        t1.setBounds(90, 2, 100, 20);
        setup.add(t1);

        setup_alt_id = new JLabel("Alt. ID");
        setup_alt_id.setBounds(2, 23, 120, 25);
        setup_alt_id.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(setup_alt_id);
        t2 = new JTextField();
        t2.setBounds(90, 23, 100, 20);
        setup.add(t2);

        right_ear = new JLabel("Right Ear Tag");
        right_ear.setBounds(2, 44, 120, 25);
        right_ear.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(right_ear);
        t3 = new JTextField();
        t3.setBounds(90, 44, 100, 20);
        setup.add(t3);

        left_ear = new JLabel("Left Ear Tag");
        left_ear.setBounds(2, 65, 120, 25);
        left_ear.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(left_ear);
        t4 = new JTextField();
        t4.setBounds(90, 65, 100, 20);
        setup.add(t4);

        electronic_id = new JLabel("Electronic ID");
        electronic_id.setBounds(2, 86, 120, 25);
        electronic_id.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(electronic_id);
        t5 = new JTextField();
        t5.setBounds(90, 86, 100, 20);
        setup.add(t5);

        JLabel date = new JLabel("Date");
        date.setBounds(280, 2, 100, 20);
        setup.add(date);

        JLabel current = new JLabel("Current");
        current.setBounds(210, 23, 100, 20);
        setup.add(current);

        UtilDateModel model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datepanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datepicker1 = new JDatePickerImpl(datepanel1, new DateLabelFormatter());
        datepicker1.setBounds(270, 23, 120, 20);
        setup.add(datepicker1);

        JLabel start = new JLabel("Birth");
        start.setBounds(210, 44, 100, 20);
        setup.add(start);

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datepanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datepicker2 = new JDatePickerImpl(datepanel2, new DateLabelFormatter());
        datepicker2.setBounds(270, 44, 120, 20);
        setup.add(datepicker2);

        JLabel weaned = new JLabel("Weaned");
        weaned.setBounds(210, 65, 100, 20);
        setup.add(weaned);

        UtilDateModel model3 = new UtilDateModel();
        Properties p3 = new Properties();
        p3.put("text.today", "Today");
        p3.put("text.month", "Month");
        p3.put("text.year", "Year");
        JDatePanelImpl datepanel3 = new JDatePanelImpl(model3, p3);
        JDatePickerImpl datepicker3 = new JDatePickerImpl(datepanel3, new DateLabelFormatter());
        datepicker3.setBounds(270, 65, 120, 20);
        setup.add(datepicker3);

        JLabel death = new JLabel("Death");
        death.setBounds(210, 86, 100, 20);
        setup.add(death);

        UtilDateModel model4 = new UtilDateModel();
        Properties p4 = new Properties();
        p4.put("text.today", "Today");
        p4.put("text.month", "Month");
        p4.put("text.year", "Year");
        JDatePanelImpl datepanel4 = new JDatePanelImpl(model4, p4);
        JDatePickerImpl datepicker4 = new JDatePickerImpl(datepanel4, new DateLabelFormatter());
        datepicker4.setBounds(270, 86, 120, 20);
        setup.add(datepicker4);

        JLabel weight = new JLabel("Weight");
        weight.setBounds(390, 2, 100, 20);
        setup.add(weight);

        w1 = new JTextField();
        w1.setBounds(390, 23, 100, 20);
        setup.add(w1);
        w2 = new JTextField();
        w2.setBounds(390, 44, 100, 20);
        setup.add(w2);
        w3 = new JTextField();
        w3.setBounds(390, 65, 100, 20);
        setup.add(w3);
        w4 = new JTextField();
        w4.setBounds(390, 86, 100, 20);
        setup.add(w4);
        JSeparator j = new JSeparator(JSeparator.HORIZONTAL);
        j.setBounds(210, 110, 280, 2);
        setup.add(j);
        breeding_stock = new JCheckBox("Breeding Stock");
        breeding_stock.setBounds(210, 115, 150, 20);
        setup.add(breeding_stock);

        JLabel parity = new JLabel("#Parity/Births");
        parity.setBounds(210, 140, 80, 20);
        setup.add(parity);
        parity_count = new JTextField(10);
        parity_count.setBounds(300, 140, 50, 20);
        setup.add(parity_count);
        JSeparator j3 = new JSeparator(JSeparator.HORIZONTAL);
        j3.setBounds(210, 170, 280, 2);
        setup.add(j3);

        JLabel sire = new JLabel("Sire");
        sire.setBounds(210, 185, 60, 20);
        setup.add(sire);
        SireVector = new Vector();
        comboSire = new DefaultComboBoxModel<>(SireVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Sire.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboSire.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Sire_name = new JComboBox<>(comboSire);
        Sire_name.addItem("");
        Sire_name.addItem("<Change>");
        Sire_name.setBounds(280, 185, 150, 20);
        Sire_name.addItemListener(this);
        setup.add(Sire_name);

        JLabel Dam = new JLabel("Dam");
        Dam.setBounds(210, 215, 60, 20);
        setup.add(Dam);
        DamVector = new Vector();
        comboDam = new DefaultComboBoxModel<>(DamVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Dam.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboDam.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Dam_name = new JComboBox<>(comboDam);
        Dam_name.addItem("");
        Dam_name.addItem("<Change>");
        Dam_name.setBounds(280, 215, 150, 20);
        Dam_name.addItemListener(this);//event processing object
        setup.add(Dam_name);

        //bottom
        JSeparator j1 = new JSeparator(JSeparator.HORIZONTAL);
        j1.setBounds(2, 105, 300, 2);
        setup.add(j1);
        gender = new JLabel("Gender");
        gender.setBounds(2, 111, 120, 25);
        gender.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(gender);
        String[] type1 = {"<gender>", "Bull", "Cow"};
        gender_list = new JComboBox<>(type1);
        gender_list.setBounds(90, 111, 100, 17);
        gender_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(gender_list);

        breed = new JLabel("Breed");
        breed.setBounds(2, 132, 120, 25);
        breed.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(breed);
        breedVector = new Vector();
        comboBreed = new DefaultComboBoxModel<>(breedVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Breed_addition.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboBreed.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        breed_list = new JComboBox<>(comboBreed);
        breed_list.addItem("");
        breed_list.addItem("<Add/Edit>");
        breed_list.setBounds(90, 132, 100, 17);
        breed_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        breed_list.addItemListener(this);
        setup.add(breed_list);

        color = new JLabel("Color");
        color.setBounds(2, 153, 120, 25);
        color.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(color);
        colorVector = new Vector();
        comboColor = new DefaultComboBoxModel<>(colorVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Cow_Colour_addition.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboColor.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        color_list = new JComboBox<>(comboColor);
        color_list.addItem("");
        color_list.addItem("<Add/Edit>");
        color_list.setBounds(90, 153, 100, 17);
        color_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        color_list.addItemListener(this);
        setup.add(color_list);

        status = new JLabel("Status");
        status.setBounds(2, 174, 120, 25);
        status.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(status);
        StatusVector = new Vector();
        comboStatus = new DefaultComboBoxModel<>(StatusVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Status.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboStatus.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        status_list = new JComboBox<>(comboStatus);
        status_list.addItem("");
        status_list.addItem("<Add/Edit>");
        status_list.setBounds(90, 174, 100, 17);
        status_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        status_list.addItemListener(this);
        setup.add(status_list);

        mgnt_code = new JLabel("Mgnt. Code");
        mgnt_code.setBounds(2, 195, 120, 25);
        mgnt_code.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(mgnt_code);
        ManagementCodesVector = new Vector();
        comboManagementCodes = new DefaultComboBoxModel<>(ManagementCodesVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Management_code.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboManagementCodes.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        mgnt_code_list = new JComboBox<>(comboManagementCodes);
        mgnt_code_list.addItem("");
        mgnt_code_list.addItem("<Add/Edit>");
        mgnt_code_list.setBounds(90, 195, 100, 17);
        mgnt_code_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        mgnt_code_list.addItemListener(this);
        setup.add(mgnt_code_list);

        health_code = new JLabel("Health Code");
        health_code.setBounds(2, 216, 120, 25);
        health_code.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(health_code);
        HealthVector = new Vector();
        comboHealth = new DefaultComboBoxModel<>(HealthVector);
        try {
            File f = new File("D:/akash/Agri_Management_System/Health_Code.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboHealth.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        health_code_list = new JComboBox<>(comboHealth);
        health_code_list.addItem("");
        health_code_list.addItem("<Add/Edit>");
        health_code_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        health_code_list.setBounds(90, 216, 100, 20);
        health_code_list.addItemListener(this);
        setup.add(health_code_list);

        JSeparator j2 = new JSeparator(JSeparator.HORIZONTAL);
        j2.setBounds(2, 244, 190, 2);
        setup.add(j2);

        group1 = new JLabel("Group");
        group1.setBounds(2, 251, 120, 25);
        group1.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(group1);
        try {
            File f = new File("D:/akash/Agri_Management_System/Group.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboGroup.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        group1_list = new JComboBox<>(comboGroup);
        group1_list.addItem("");
        group1_list.addItem("<Add/Edit>");
        group1_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        group1_list.setBounds(90, 251, 100, 20);
        group1_list.addItemListener(this);
        setup.add(group1_list);

        location1 = new JLabel("Location");
        location1.setBounds(2, 272, 120, 25);
        location1.setFont(new Font("Tahoma", Font.BOLD, 13));
        setup.add(location1);
        try {
            File f = new File("D:/akash/Agri_Management_System/Location.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                comboLocation.addElement(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        loaction1_list = new JComboBox<>(comboLocation);
        loaction1_list.addItem("");
        loaction1_list.addItem("<Add/Edit>");
        loaction1_list.setFont(new Font("Tahoma", Font.BOLD, 13));
        loaction1_list.setBounds(90, 272, 100, 20);
        loaction1_list.addItemListener(this);
        setup.add(loaction1_list);
        //.............................................................
        //Inventory......................................................
        inventory.setLayout(null);
        JLabel linventory = new JLabel("Location");
        linventory.setBounds(20, 10, 50, 20);
        inventory.add(linventory);
        JLabel l1inventory = new JLabel("Group");
        l1inventory.setBounds(20, 30, 50, 20);
        inventory.add(l1inventory);
        InventoryCheck = new JButton("<html>Inv.<br>Check</html>");
        InventoryCheck.setBounds(250, 10, 60, 40);
        inventory.add(InventoryCheck);
        AddInventory = new JButton("<html>Add</html>");
        AddInventory.setBounds(10, 290, 90, 40);
        inventory.add(AddInventory);
        TransferInventory = new JButton("<html>Transfer</html>");
        TransferInventory.setBounds(110, 290, 90, 40);
        inventory.add(TransferInventory);
        LossInventory = new JButton("<html>Loss</html>");
        LossInventory.setBounds(210, 290, 90, 40);
        inventory.add(LossInventory);
        EditInventory = new JButton("<html>Edit</html>");
        EditInventory.setBounds(310, 290, 90, 40);
        inventory.add(EditInventory);
        LocationInventory = new JTextField();
        LocationInventory.setEditable(false);
        LocationInventory.setBounds(70, 10, 150, 20);
        inventory.add(LocationInventory);
        GroupInventory = new JTextField();
        GroupInventory.setEditable(false);
        GroupInventory.setBounds(70, 30, 150, 20);
        inventory.add(GroupInventory);
        String[] columns = {"Animal ID", "Location", "Group", "Oty", "Avg. Weight", "Total Weight"};
        Object[][] rows = {};
        modelInventory = new DefaultTableModel(rows, columns);
        tableInventory = new JTable(modelInventory);
        JScrollPane pane = new JScrollPane(tableInventory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(10, 70, 750, 200);
        inventory.add(pane);

        //....................................................................
        //Reports...............................................................
        reports.setLayout(null);
        JLabel l1 = new JLabel("Reports");
        l1.setBounds(5, 10, 100, 15);
        reports.add(l1);
        try {
            fileReports = new BufferedWriter(new FileWriter("Reports.txt", true));
        } catch (IOException iOexception) {
            iOexception.printStackTrace();
        }

        lReports = new DefaultListModel<>();
        lReports.addElement("");
        File f = new File("D:/akash/Agri_Management_System/reports.txt");
        try {
            readerReports = new BufferedReader(new FileReader(f));
            while (readerReports.readLine() != null) {
                lReports.addElement(readerReports.readLine());
            }
        } catch (Exception eee) {
            JOptionPane.showMessageDialog(this, eee.getMessage());
        }
        areaReports = new JList<>(lReports);
        areaReports.setFocusable(true);
        paneReports = new JScrollPane(areaReports);
        paneReports.setBounds(10, 35, 600, 300);
        reports.add(paneReports);

        textReports = new JTextField();
        textReports.setBounds(620, 40, 130, 30);
        reports.add(textReports);
        cancelReports = new JButton("Edit");
        cancelReports.setBounds(620, 70, 100, 20);
        cancelReports.addActionListener(this);
        reports.add(cancelReports);
        clearAllReports = new JButton("Clear All");
        clearAllReports.setBounds(620, 100, 100, 20);
        clearAllReports.addActionListener(this);
        reports.add(clearAllReports);
        removeReports = new JButton("Remove");
        removeReports.setBounds(620, 130, 100, 20);
        removeReports.addActionListener(this);
        reports.add(removeReports);
        addReports = new JButton("Add");
        addReports.setBounds(620, 160, 100, 20);
        addReports.addActionListener(this);
        reports.add(addReports);
        //....................................................................................
        //............Health............................................................
        health.setLayout(null);
        JLabel lhealth = new JLabel("AnimalId");
        lhealth.setBounds(20, 10, 70, 20);
        health.add(lhealth);
        JLabel l1health = new JLabel("AlternateId");
        l1health.setBounds(20, 30, 80, 20);
        health.add(l1health);
        JLabel currentStatus = new JLabel("Current Status");
        currentStatus.setBounds(20, 50, 80, 20);
        health.add(currentStatus);
        String[] cuurHealth = {""};
        currentStatusText = new JComboBox<>(cuurHealth);
        currentStatusText.setBounds(110, 50, 150, 20);
        health.add(currentStatusText);
        AddHealth = new JButton("<html>Add</html>");
        AddHealth.setBounds(150, 300, 90, 40);
        AddHealth.addActionListener(this);
        health.add(AddHealth);
        EditHealth = new JButton("<html>Edit</html>");
        EditHealth.setBounds(250, 300, 90, 40);
        health.add(EditHealth);
        RemoveHealth = new JButton("<html>Remove</html>");
        RemoveHealth.setBounds(350, 300, 90, 40);
        health.add(RemoveHealth);
        AnimalIdHealth = new JTextField();
        AnimalIdHealth.setEditable(false);
        AnimalIdHealth.setBounds(110, 10, 150, 20);
        health.add(AnimalIdHealth);
        AlternateIdHealth = new JTextField();
        AlternateIdHealth.setEditable(false);
        AlternateIdHealth.setBounds(110, 30, 150, 20);
        health.add(AlternateIdHealth);
        String[] columnsHealth = {"Animal ID", "Date", "Amount", "Treatment", "Reason"};
        Object[][] rowsHealth = {};
        modelHealth = new DefaultTableModel(rowsHealth, columnsHealth);
        tableHealth = new JTable(modelHealth);
        JScrollPane paneHealth = new JScrollPane(tableHealth, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneHealth.setBounds(10, 100, 750, 200);
        health.add(paneHealth);
        //...................................................................
        //Notes..............................................................
        notes.setLayout(null);
        JLabel note = new JLabel("Notes");
        note.setBounds(20, 10, 50, 20);
        notes.add(note);
        AddNotes = new JButton("<html>Add</html>");
        AddNotes.setBounds(10, 290, 90, 40);
        notes.add(AddNotes);
        removeNotes = new JButton("<html>Transfer</html>");
        removeNotes.setBounds(110, 290, 90, 40);
        notes.add(removeNotes);
        EditNotes = new JButton("<html>Loss</html>");
        EditNotes.setBounds(210, 290, 90, 40);
        notes.add(EditNotes);

        String[] columnsNotes = {"Animal ID", "Date", "Note Type", "Note"};
        Object[][] rowsNotes = {};
        modelNotes = new DefaultTableModel(rowsNotes, columnsNotes);
        tableNotes = new JTable(modelNotes);
        JScrollPane panenote = new JScrollPane(tableNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panenote.setBounds(10, 70, 750, 200);
        notes.add(panenote);
        UtilDateModel modelNotes = new UtilDateModel();
        Properties pNotes = new Properties();
        pNotes.put("text.today", "Today");
        pNotes.put("text.month", "Month");
        pNotes.put("text.year", "Year");
        JDatePanelImpl datepanelNotes = new JDatePanelImpl(modelNotes, pNotes);
        JDatePickerImpl datepickerNotes = new JDatePickerImpl(datepanelNotes, new DateLabelFormatter());
        datepickerNotes.setBounds(310, 290, 120, 20);
        notes.add(datepickerNotes);

        UtilDateModel modelNotes1 = new UtilDateModel();
        Properties pNotes1 = new Properties();
        pNotes1.put("text.today", "Today");
        pNotes1.put("text.month", "Month");
        pNotes1.put("text.year", "Year");
        JDatePanelImpl datepanelNotes1 = new JDatePanelImpl(modelNotes1, pNotes1);
        JDatePickerImpl datepickerNotes1 = new JDatePickerImpl(datepanelNotes1, new DateLabelFormatter());
        datepickerNotes1.setBounds(440, 290, 120, 20);
        notes.add(datepickerNotes1);

        updateNotes = new JButton("<html>Update</html>");
        updateNotes.setBounds(570, 290, 90, 20);
        notes.add(updateNotes);
        //....................................................................
        //.....Sell.......................................................
        sell.setLayout(null);
        JLabel lsell = new JLabel("Location");
        lsell.setBounds(20, 10, 50, 20);
        sell.add(lsell);
        JLabel l1sell = new JLabel("Group");
        l1sell.setBounds(20, 30, 50, 20);
        sell.add(l1sell);
        JLabel psell = new JLabel("Products");
        psell.setBounds(20, 50, 50, 20);
        sell.add(psell);
        String arrSell[] = {"Milk"};
        ProductsSell = new JComboBox(arrSell);
        ProductsSell.setBounds(70, 50, 150, 20);
        sell.add(ProductsSell);

        AnimalToSell = new JRadioButton("Animals to Sell");
        AnimalToSell.setBounds(250, 10, 150, 20);
        sell.add(AnimalToSell);
        AnimalsSold = new JRadioButton("Animals Sold");
        AnimalsSold.setBounds(250, 30, 150, 20);
        sell.add(AnimalsSold);
        SoldProducts = new JRadioButton("Sold Products");
        SoldProducts.setBounds(250, 50, 150, 20);
        sell.add(SoldProducts);
        ButtonGroup b = new ButtonGroup();
        b.add(AnimalsSold);
        b.add(AnimalToSell);
        b.add(SoldProducts);

        SellBtn = new JButton("<html>Sell</html>");
        SellBtn.setBounds(10, 290, 90, 40);
        sell.add(SellBtn);
        EditSell = new JButton("<html>Edit</html>");
        EditSell.setBounds(110, 290, 90, 40);
        sell.add(EditSell);
        RemoveSell = new JButton("<html>Remove</html>");
        RemoveSell.setBounds(210, 290, 90, 40);
        sell.add(RemoveSell);
        SelectSell = new JButton("<html>Select All</html>");
        SelectSell.setBounds(330, 290, 90, 40);
        sell.add(SelectSell);
        LocationSell = new JTextField();
        LocationSell.setEditable(false);
        LocationSell.setBounds(70, 10, 150, 20);
        sell.add(LocationSell);
        GroupSell = new JTextField();
        GroupSell.setEditable(false);
        GroupSell.setBounds(70, 30, 150, 20);
        sell.add(GroupSell);
        String[] columnsSell = {"Animal ID", "Age", "Oty"};
        Object[][] rowsSell = {};
        modelSell = new DefaultTableModel(rowsSell, columnsSell);
        tableSell = new JTable(modelSell);
        JScrollPane paneSell = new JScrollPane(tableSell, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneSell.setBounds(10, 90, 750, 200);
        paneSell.setBackground(Color.WHITE.brighter());
        sell.add(paneSell);
        //...................................................................
        //Milk Test......................................................
        milk_test.setLayout(null);
        JLabel lmilk = new JLabel("Lactation");
        lmilk.setBounds(20, 10, 50, 20);
        milk_test.add(lmilk);

        JLabel lmilk1 = new JLabel("Calved");
        lmilk1.setBounds(250, 10, 50, 20);
        milk_test.add(lmilk1);

        recordMilk = new JButton("<html>Record</html>");
        recordMilk.setBounds(210, 290, 90, 40);
        milk_test.add(recordMilk);

        lactationMilk = new JTextField();
        lactationMilk.setEditable(false);
        lactationMilk.setBounds(70, 10, 150, 20);
        milk_test.add(lactationMilk);

        lactationMilk1 = new JTextField();
        lactationMilk1.setEditable(false);
        lactationMilk1.setBounds(305, 10, 150, 20);
        milk_test.add(lactationMilk1);

        String[] columnsMilk = {"Date", "Lbs. Milk", "% Fat", "% Protein", "SCC  ", "Comments"};
        Object[][] rowsMilk = {};
        modelMilk = new DefaultTableModel(rowsMilk, columnsMilk);
        tableMilk = new JTable(modelMilk);
        tableMilk.setShowHorizontalLines(true);
        tableMilk.setShowVerticalLines(true);
        JScrollPane paneMilk = new JScrollPane(tableMilk, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneMilk.setBounds(10, 70, 750, 200);
        milk_test.add(paneMilk);
        //.....Feed....................................................
        feed.setLayout(null);
        JLabel lfeed = new JLabel("Animal ID");
        lfeed.setBounds(20, 10, 50, 20);
        feed.add(lfeed);
        JLabel l1feed = new JLabel("Alternate ID");
        l1feed.setBounds(20, 30, 50, 20);
        feed.add(l1feed);
        JLabel pfeed = new JLabel("Current Status");
        pfeed.setBounds(20, 50, 50, 20);
        feed.add(pfeed);
        String arrfeed[] = {" "};
        statusFeed = new JComboBox(arrfeed);
        statusFeed.setBounds(70, 50, 150, 20);
        feed.add(statusFeed);

        addFeed = new JButton("<html>Add</html>");
        addFeed.setBounds(10, 290, 90, 40);
        feed.add(addFeed);
        EditFeed = new JButton("<html>Edit</html>");
        EditFeed.setBounds(110, 290, 90, 40);
        feed.add(EditFeed);
        RemoveFeed = new JButton("<html>Remove</html>");
        RemoveFeed.setBounds(210, 290, 90, 40);
        feed.add(RemoveFeed);
        idFeed = new JTextField();
        idFeed.setEditable(false);
        idFeed.setBounds(70, 10, 150, 20);
        feed.add(idFeed);
        altidFeed = new JTextField();
        altidFeed.setEditable(false);
        altidFeed.setBounds(70, 30, 150, 20);
        feed.add(altidFeed);
        String[] columnsFeed = {"Animal ID", "Age", "Oty"};
        Object[][] rowsFeed = {};
        modelFeed = new DefaultTableModel(rowsFeed, columnsFeed);
        tableFeed = new JTable(modelFeed);
        JScrollPane paneFeed = new JScrollPane(tableFeed, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneFeed.setBounds(10, 90, 750, 200);
        paneFeed.setBackground(Color.WHITE.brighter());
        feed.add(paneFeed);
        //..............Wean.............................................................................................................
        wean.setLayout(null);
        JLabel lwean = new JLabel("Animal ID");
        lwean.setBounds(20, 10, 50, 20);
        wean.add(lwean);
        JLabel l1wean = new JLabel("Alternate ID");
        l1wean.setBounds(20, 30, 50, 20);
        wean.add(l1wean);
        JLabel pwean = new JLabel("Current Status");
        pwean.setBounds(20, 50, 50, 20);
        wean.add(pwean);
        String arrwean[] = {" "};
        statusWean = new JComboBox(arrwean);
        statusWean.setBounds(70, 50, 150, 20);
        wean.add(statusWean);

        addWean = new JButton("<html>Add</html>");
        addWean.setBounds(10, 290, 90, 40);
        wean.add(addWean);
        EditWean = new JButton("<html>Edit</html>");
        EditWean.setBounds(110, 290, 90, 40);
        wean.add(EditWean);
        RemoveWean = new JButton("<html>Remove</html>");
        RemoveWean.setBounds(210, 290, 90, 40);
        wean.add(RemoveWean);
        idWean = new JTextField();
        idWean.setEditable(false);
        idWean.setBounds(70, 10, 150, 20);
        wean.add(idWean);
        altidWean = new JTextField();
        altidWean.setEditable(false);
        altidWean.setBounds(70, 30, 150, 20);
        wean.add(altidWean);
        String[] columnsWean = {"Animal ID", "Age", "Oty"};
        Object[][] rowsWean = {};
        modelWean = new DefaultTableModel(rowsWean, columnsWean);
        tableWean = new JTable(modelWean);
        JScrollPane paneWean = new JScrollPane(tableWean, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneWean.setBounds(10, 90, 750, 200);
        paneWean.setBackground(Color.WHITE.brighter());
        wean.add(paneWean);
        //...............................................................................................................................
        //...................Weight...........................................................................................................
        weeight.setLayout(null);
        JLabel lweight = new JLabel("Animal ID");
        lweight.setBounds(20, 10, 50, 20);
        weeight.add(lweight);
        JLabel l1weight = new JLabel("Alternate ID");
        l1weight.setBounds(20, 30, 50, 20);
        weeight.add(l1weight);
        JLabel pweight = new JLabel("Current Status");
        pweight.setBounds(20, 50, 50, 20);
        weeight.add(pweight);
        String arrweight[] = {" "};
        statusWeight = new JComboBox(arrweight);
        statusWeight.setBounds(70, 50, 150, 20);
        weeight.add(statusWeight);

        addWeight = new JButton("<html>Add</html>");
        addWeight.setBounds(10, 290, 90, 40);
        weeight.add(addWeight);
        EditWeight = new JButton("<html>Edit</html>");
        EditWeight.setBounds(110, 290, 90, 40);
        weeight.add(EditWeight);
        RemoveWeight = new JButton("<html>Remove</html>");
        RemoveWeight.setBounds(210, 290, 90, 40);
        weeight.add(RemoveWeight);
        idWeight = new JTextField();
        idWeight.setEditable(false);
        idWeight.setBounds(70, 10, 150, 20);
        weeight.add(idWeight);
        altidWeight = new JTextField();
        altidWeight.setEditable(false);
        altidWeight.setBounds(70, 30, 150, 20);
        weeight.add(altidWeight);
        String[] columnsWeight = {"Animal ID", "Age", "Oty"};
        Object[][] rowsWeight = {};
        modelWeight = new DefaultTableModel(rowsWeight, columnsWeight);
        tableWeight = new JTable(modelWeight);
        JScrollPane paneWeight = new JScrollPane(tableWeight, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        paneWeight.setBounds(10, 90, 750, 200);
        paneWeight.setBackground(Color.WHITE.brighter());
        weeight.add(paneWeight);
        //................Calender....................................
        calndar = new com.mindfusion.scheduling.Calendar();
        calndar.setTheme(ThemeType.Light);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        nextButtonInToolbar(toolBar, imageFileNames[0]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calndar.setCurrentView(CalendarView.SingleMonth);
            }
        });

        nextButtonInToolbar(toolBar, imageFileNames[1]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calndar.setCurrentView(CalendarView.MonthRange);
            }
        });

        nextButtonInToolbar(toolBar, imageFileNames[2]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calndar.setCurrentView(CalendarView.List);
            }
        });

        nextButtonInToolbar(toolBar, imageFileNames[3]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calndar.setCurrentView(CalendarView.WeekRange);
            }
        });

        nextButtonInToolbar(toolBar, imageFileNames[4]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calndar.setCurrentView(CalendarView.Timetable);
            }
        });
        calender.setLayout(new BorderLayout());
        calender.add(toolBar, BorderLayout.PAGE_START);
        calender.add(calndar, BorderLayout.CENTER);

        addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                onWindowOpened();
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                exit();
            }
        });

        // Initialize the date file
        _dataFile = new java.io.File("Schedule.dat").getAbsolutePath();

        //.................................................................
        cancel=new JButton("Back");
        cancel.setBackground(Color.BLUE.darker());
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(0,456,100,18);
        cancel.addActionListener(this);
        add(cancel);
        exit=new JButton("EXIT");
        exit.setBackground(Color.BLUE.darker());
        exit.setForeground(Color.WHITE);
        exit.setBounds(500,456,100,18);
        exit.addActionListener(this);
        add(exit);


        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBounds(50,50,841,514);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void onWindowOpened() {
        if (new java.io.File(_dataFile).exists())
            calndar.getSchedule().loadFrom(_dataFile, ContentType.Xml);
    }

    private void exit() {
        calndar.getSchedule().saveTo(_dataFile, ContentType.Xml);
    }

    private JButton nextButtonInToolbar(JToolBar bar, String imageName)
    {
        JButton button = new JButton(new ThumbnailAction(imagedir, imageName));
        button.setBorderPainted(false);
        button.setMargin(new Insets(5, 5, 5, 5));
        button.setSize(35, 35);

        bar.add(button);
        return button;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Calf_Management();
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Property Lists")){
            new PropertyLists_JFrame().setVisible(true);
        }
        if(e.getSource()==cancel){
            new DashBoard().setVisible(true);
            this.dispose();
        }if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getActionCommand().equals("Return to main page")){
            new DashBoard().setVisible(true);
            this.dispose();
        }else if(e.getActionCommand().equals("Health Monitoring")) {
            new Health_Monitoring().setVisible(true);
            this.dispose();
        }else if(e.getActionCommand().equals("Groups")){
            try {
                new addGroup().setVisible(true);
            }catch(Exception eee){
                eee.printStackTrace();
            }
        }else if(e.getActionCommand().equals("Locations")){
            try {
                new addLocation().setVisible(true);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        //....Reports......................
        if (e.getSource() == cancelReports) {
        try {
            fileReports.close();
            //
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this,exception.getMessage());
            }
        } else if (e.getSource() == addReports) {
            String s = textReports.getText();
            lReports.addElement(s);
            try {
                fileReports.write(s);
                fileReports.newLine();
                fileReports.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            textReports.setText("");
        } else if (e.getSource() == clearAllReports) {
            int i = JOptionPane.showConfirmDialog(this, "Are you sure to delete all?");
            if (i == 0) {
                lReports.clear();
                try {
                    fileReports = new BufferedWriter(new FileWriter("Reports.txt"));
                    fileReports.write("");
                } catch (IOException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error Clearing,try again");
                }
            }
        } else if (e.getSource() == removeReports) {
            String str=areaReports.getSelectedValue();
            int s = areaReports.getSelectedIndex();
            int i = JOptionPane.showConfirmDialog(this, "Do you want to delete "+str+" ?");
            if(i==0) {
                lReports.remove(s);
                try {
                    fileReports = new BufferedWriter(new FileWriter("Reports.txt", true));
                    while (readerReports.readLine() != null) {
                        if (readerReports.readLine().equals(str)) {
                            fileReports.write("" + "\r");
                        }
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error Clearing,try again");
                }
            }
        }
        //..................Health/.......................
        if(e.getSource()==AddHealth){
            try {
               h=new HealthRecord();
                h.setVisible(true);
            }catch(Exception exception){
                JOptionPane.showMessageDialog(this,exception.getMessage());
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(breed_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                b=new addBreed();
                b.setVisible(true);
                breed_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(mgnt_code_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addManagementCodes().setVisible(true);
                mgnt_code_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(color_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addCowColor().setVisible(true);
                color_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(status_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addStatus().setVisible(true);
                status_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(health_code_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addHealth().setVisible(true);
                health_code_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(group1_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addGroup().setVisible(true);
                group1_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(loaction1_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addLocation().setVisible(true);
                loaction1_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(Sire_name.getSelectedItem().equals("<Change>")){
            try {
                new addSire().setVisible(true);
                Sire_name.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(Dam_name.getSelectedItem().equals("<Change>")){
            try {
                new addDam().setVisible(true);
                Dam_name.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        //.............inventory....................
        String sInventoryLocation= (String) location_box.getSelectedItem();
        LocationInventory.setText(sInventoryLocation);
        String sInventoryGroup=(String) group_list.getSelectedItem();
        GroupInventory.setText(sInventoryGroup);
        if(location_box.getSelectedItem().equals("<AllLocations>")){
            try {
                new addLocation().setVisible(true);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        if(group_list.getSelectedItem().equals("<Add/Edit>")){
            try {
                new addGroup().setVisible(true);
                group_list.setSelectedIndex(0);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        //..........................................
    }

    public static class DateLabelFormatter extends AbstractFormatter{//since the class is inner ..ie. static keyword can be used.
        private final String datepattern="yyyy-mm-dd";
        private final SimpleDateFormat dateFormatter=new SimpleDateFormat(datepattern);
        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }
        @Override
        public String valueToString(Object value){
            if(value!=null){
                Calendar c=(Calendar) value;
                return dateFormatter.format(c.getTime());
            }
                return "";
        }
    }
}
class ThumbnailAction extends AbstractAction
{
    public ThumbnailAction(String path, String imagePath)
    {
        // The LARGE_ICON_KEY is the key for setting the
        // icon when an Action is applied to a button.
        ImageIcon icon = createImageIcon(path, imagePath);
        putValue(LARGE_ICON_KEY, icon);
    }

    private ImageIcon createImageIcon(String path, String fileName) {
        java.net.URL imgURL = getClass().getResource(path + fileName);
        if (imgURL == null)
            imgURL = getClass().getResource("/" + path + fileName);

        if (imgURL != null) {
            return new ImageIcon(imgURL, fileName);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private static final long serialVersionUID = 1L;
}