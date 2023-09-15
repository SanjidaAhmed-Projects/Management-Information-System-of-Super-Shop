import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopyFields;
import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.sun.speech.freetts.audio.AudioPlayer;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import org.joda.time.DateTime;
import sun.audio.AudioStream;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.audio.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
//import sun.audio.AudioPlayer;


public class FoodsJFrame extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs = null;
    PreparedStatement pst=null;
    public FoodsJFrame() {
        initComponents();
        conn=JavaConnector.ConnectorDb();
        Update_Table();
        CurrentDate();
        Fill_Combo();
        
       
    }
    
    public void Close()
    {
        //WindowEvent winClosingEvent = new WindowEvent( this, WindowEvent.WINDOW_CLOSING );
        //Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
        this.setVisible(false);
        this.dispose();
    }
    
    private void Fill_Combo()
    {
        try
        {
            String sql="Select * from Product_food";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
            String Name=rs.getString("Name");
            cmb_select.addItem(Name);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
                //conn.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    public void CurrentDate(){
  
        Thread clock = new Thread(){
            public void run(){
               for(;;){
                   Calendar cal = new GregorianCalendar();
  
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            menu_date.setText(+ day + "/" + (month + 1) + "/" + year);
            //System.out.println("Current date : " + day + "/" + (month + 1) + "/" + year);

            int second = cal.get(Calendar.SECOND);
            int minute = cal.get(Calendar.MINUTE);
            int hour = cal.get(Calendar.HOUR);
            menu_time.setText(+ hour + ":" + minute + ":" + second);
                  
                   
                   try {
                       sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(EmployeeDetailsJFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   
               } 
            }
        };
        clock.start();    
  }
    
    
    /*private void game() {
       /*try{
           String sDate1="2010-01-01";  
    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
       String sDate2=((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText();
    Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2); 
       
       if(date2.before(date1))
    {
        JOptionPane.showMessageDialog(null, "don't");
    }
    else
    {
        
    }
       }
    catch(ParseException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }*/
      
        
        
        
        
        
        
	
/*DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
Date startDate = null; 
try 
{ 
    startDate = dateFormat.parse("03/04/1975");

String foramtedDate =dateFormat.format(startDate); 
System.out.println("After format Date is="+foramtedDate); 
}  
catch (ParseException e)
{ 
    e.printStackTrace();
} 
  
    }
    /*try{
        String sDate1="2010-01-01";  
    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
    //Date sDate2=null;
    String sDate2=((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText();
//((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText();
    Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2);
    if(date2.before(date1))
    {
        JOptionPane.showMessageDialog(null, "don't");
    }
    else
    {
        
    }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
  
    }*/
    /*{
        String date;
Date date1=null;
Date date2=null;     
SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
dateFormatter.format(date1).equals(dateFormatter.format(date2));
while(true)
{
    Scanner s = new Scanner (System.in);
    date = s.nextLine();
    Calendar cal = Calendar.getInstance();
    try {
        // trying to parse current date here
        // newDate = dateFormatter.parse(cal.getTime().toString()); //throws exception

        // trying to parse inputted date here
        //date2 = dateFormatter.parse(date); //no exception
        date2 = dateFormatter.parse(dateFormatter.format(new Date() ));
    } catch (ParseException e) {
        e.printStackTrace(System.out);
    }

}*/

        
        /*Date today = new Date();                   
  Date myDate = new Date(today.getYear(),today.getMonth()-1,today.getDay());
  System.out.println("My Date is"+myDate);    
  System.out.println("Today Date is"+today);
  if (today.compareTo(myDate)<0)
      System.out.println("Today Date is Lesser than my Date");
  else if (today.compareTo(myDate)>0)
      System.out.println("Today Date is Greater than my date"); 
  else
      System.out.println("Both Dates are equal"); */
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1string=sdf.parse("2009-12-31");
        Date date2string=txt_adddate.getDate();
        
        //Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(date1string);
//Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(date2string);

date1.before(date2);
        
        /*Date date1 = new Date();
        Date date2 = new Date();
        if(date1.before(date2)){JOptionPane.showMessageDialog(null, "don't");}*/
       /* try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2009-12-31");
        Date date2 = txt_adddate.getDate();
            date2.before(date1);
            
                JOptionPane.showMessageDialog(null, "don't");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*private void something()
    {
        Date a=(Date) txt_adddate.getDate();
        Calendar cal = Calendar.getInstance();
    
    // set Date portion to January 1, 1970
    cal.set( cal.YEAR, 1970 );
    cal.set( cal.MONTH, cal.JANUARY );
    cal.set( cal.DATE, 1 );
    
    cal.set( cal.HOUR_OF_DAY, 0 );
    cal.set( cal.MINUTE, 0 );
    cal.set( cal.SECOND, 0 );
    cal.set( cal.MILLISECOND, 0 );
    
    //java.sql.Date jsqlD = 
       new java.sql.Date( cal.getTime().getTime() );
    java.sql.Date jsqlD = java.sql.Date.valueOf( "2010-01-31" );
    if(jsqlD.after(a))
            {
                JOptionPane.showMessageDialog(null, "don't");
            }
            else
            {
                
            }
        
        /*String date= "04-01-2015";
        Date mydate = new Date(date);
        
        /*Date date = (Date) new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        if(txt_adddate.getDate().before(date))
        {
            JOptionPane.showMessageDialog(null, "don't");
        }
        else
        {
            
        }

//DateTime date = DateTime.parse("2007-03-12T00:00:00.000+01:00");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        /*Date date = new Date(2015-1900,00,01);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //String dateString = sdf.format(date);
        
        if(txt_adddate.getDate().before(date))
        {
            JOptionPane.showMessageDialog(null, "don't");
        }
        else
        {
            
        }*/
        /*java.util.Date ddd = txt_adddate.getDate();
        String str = "04-01-2015";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            java.util.Date date = sdf.parse(str);
            if(ddd.before(date))
            {
                JOptionPane.showMessageDialog(null, "don't");
            }
            else
            {
                
            }
            
        }
        catch(ParseException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }*/
        
    //}
    
    private void Update_Table()
    {
        try
        {
            String sql="Select * from Product_food";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tbl_foods.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
                //conn.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        cmb_select = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_report = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_foods = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl_img = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        txt_imgpath = new javax.swing.JTextField();
        txt_proid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_adddate = new com.toedter.calendar.JDateChooser();
        btn_browse = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        menu_date = new javax.swing.JMenu();
        menu_time = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menu_logout = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-new-window-icon.png"))); // NOI18N
        jButton1.setToolTipText("New Window");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-document-save-all-icon.png"))); // NOI18N
        jButton2.setToolTipText("Save");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Previous-icon.png"))); // NOI18N
        jButton3.setToolTipText("Previous Page");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Next-icon.png"))); // NOI18N
        jButton4.setToolTipText("Next Page");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-refresh-4-icon.png"))); // NOI18N
        jButton5.setToolTipText("Refresh");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N

        txt_search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        cmb_select.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_select.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_selectPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        btn_report.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reports-icon.png"))); // NOI18N
        btn_report.setText("Report");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clear-icon.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit-Document-icon.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add-Folder-icon.png"))); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trash-empty-icon.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_print.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon.png"))); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_report)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_print)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_foods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_foods.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_foodsMouseClicked(evt);
            }
        });
        tbl_foods.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_foodsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_foods);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product(Foods) Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Image:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Product ID:");

        jDesktopPane1.setLayer(lbl_img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Price:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Add Date:");

        txt_adddate.setDateFormatString("yyyy-MM-dd");

        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_price, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_proid, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_adddate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_browse)
                                .addGap(18, 18, 18)
                                .addComponent(txt_imgpath, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_proid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addComponent(txt_adddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_browse)
                    .addComponent(txt_imgpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton6)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files-New-Window-icon.png"))); // NOI18N
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-document-save-all-icon.png"))); // NOI18N
        jMenuItem4.setText("Save");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-window-close-icon.png"))); // NOI18N
        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete-icon.png"))); // NOI18N
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-refresh-4-icon.png"))); // NOI18N
        jMenuItem5.setText("Refresh");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Previous-icon.png"))); // NOI18N
        jMenuItem7.setText("Previous");
        jMenu2.add(jMenuItem7);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Next-icon.png"))); // NOI18N
        jMenuItem9.setText("Next");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        menu_date.setText("Date");
        menu_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dateActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu_date);

        menu_time.setText("Time");
        jMenuBar1.add(menu_time);

        jMenu5.setText("Help");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-info-icon.png"))); // NOI18N
        jMenuItem6.setText("About");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        menu_logout.setForeground(new java.awt.Color(204, 0, 0));
        menu_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apps-session-logout-icon.png"))); // NOI18N
        menu_logout.setText("Logout");
        menu_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_logoutMouseClicked(evt);
            }
        });
        menu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_logoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu_logout);

        jMenu4.setForeground(new java.awt.Color(0, 51, 204));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email-send-receive-icon.png"))); // NOI18N
        jMenu4.setText("Send Mail");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_select, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cmb_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(1301, 673));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_logoutMouseClicked

        Close();
        LogInJFrame login=new LogInJFrame();
        login.setVisible(true);
    }//GEN-LAST:event_menu_logoutMouseClicked

    private void menu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_logoutActionPerformed

    }//GEN-LAST:event_menu_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Close();
        NewWindow nw = new NewWindow();
        nw.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String sql = "Insert into Product_food (ID,Name,Price,Date,Image) values (?,?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);

            pst.setString(1, txt_proid.getText());
            pst.setString(2, txt_name.getText());
            
            pst.setString(3, txt_price.getText());
            //pst.setString(5, txt_adddate.getDateFormatString());
            pst.setString(4, ((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText());            
            pst.setBytes(5, person_image);
            

            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        Update_Table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Close();
        Products p = new Products();
        p.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Close();
        FoodsJFrame fd = new FoodsJFrame();
        fd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        try
        {
            String sql = "Select * from Product_food where ID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_proid.setText(add1);
                String add2 = rs.getString("Name");
                txt_name.setText(add2);
                Double add3 = rs.getDouble("Price");
                txt_price.setText(Double.toString(add3));
                Date add4 = rs.getDate("Date");
                txt_adddate.setDate(add4);
                byte[] imagedata = rs.getBytes("Image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
                lbl_img.setIcon(new ImageIcon(scaledImg));
                txt_imgpath.setText(filename);
               // byte[] add5 = rs.getBytes("Image");
                //format = new ImageIcon(add5);
                //lbl_img.setIcon(format);
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sql = "Select * from Product_food where Name=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_proid.setText(add1);
                String add2 = rs.getString("Name");
                txt_name.setText(add2);
                Double add3 = rs.getDouble("Price");
                txt_price.setText(Double.toString(add3));
                Date add4 = rs.getDate("Date");
                txt_adddate.setDate(add4);
                byte[] imagedata = rs.getBytes("Image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
                lbl_img.setIcon(new ImageIcon(scaledImg));
                txt_imgpath.setText(filename);
                //byte[] add5 = rs.getBytes("Image");
                //format = new ImageIcon(add5);
                //lbl_img.setIcon(format);
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void cmb_selectPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_selectPopupMenuWillBecomeInvisible
        //comboselect();

        String tmp = (String)cmb_select.getSelectedItem();
        String sql = "Select * from Product_food where Name=?";

        try
        {

            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_proid.setText(add1);
                String add2 = rs.getString("Name");
                txt_name.setText(add2);
                
                Double add3 = rs.getDouble("Price");
                txt_price.setText(Double.toString(add3));
                Date add4 = rs.getDate("Date");
                txt_adddate.setDate(add4);
                byte[] add5 = rs.getBytes("Image");
                format = new ImageIcon(add5);
                lbl_img.setIcon(format);
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmb_selectPopupMenuWillBecomeInvisible

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        /*try
        {
            PdfReader report = new PdfReader("Java Printing.pdf");
            PdfReader report2 = new PdfReader("Report.pdf");
            PdfCopyFields copy = new PdfCopyFields(new FileOutputStream("Joined Report.pdf"));
            copy.addDocument(report);
            copy.addDocument(report2);
            copy.close();
            JOptionPane.showMessageDialog(null, "Saved");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }*/

            String value1 = txt_proid.getText();
            String value2 = txt_name.getText();
            
            String value3 = txt_price.getText();
            String value4 = txt_adddate.getDateFormatString();
            byte[] value5 = lbl_img.getText().getBytes();
            

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //Lbl_Date.setText("Date : "   + day + "/" + (month + 1) + "/" + year);
        System.out.println("Current date : " + day + "/" + (month + 1) + "/" + year);

        try
        {

            Document document=new Document();
            //Document document=new Document(PageSize.A4.rotate()); //for landscape pdf format
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("REPORT.pdf"));

            document.open();
            PdfContentByte CB = writer.getDirectContent();
            BarcodeEAN codeEAN = new BarcodeEAN();
            codeEAN.setCode("1234567812345");
            Paragraph para = new Paragraph();

            document.add(new Paragraph("Barcode UDCA"));
            codeEAN.setCodeType(Barcode.UPCA);
            codeEAN.setCode("1234567890000");
            document.add(codeEAN.createImageWithBarcode(CB, BaseColor.BLACK, BaseColor.BLACK));
            document.add(para);

            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("Mighty-Chips-Italian-Tomato.jpg");
            document.add(new Paragraph("Image"));
            image.setRotationDegrees(45.0f);
            image.setAbsolutePosition(480, 300);
            document.add(image);

            document.add(new Paragraph("Hello World",FontFactory.getFont(FontFactory.TIMES_BOLD,18,com.itextpdf.text.Font.BOLD,BaseColor.RED)));
            document.add(new Paragraph(new java.util.Date().toString()));
            document.add(new Paragraph("-----------------------------------------------------------------------------------"));
            PdfPTable table=new PdfPTable(2);

            PdfPCell cell = new PdfPCell (new Paragraph ("Title"));
            cell.setColspan (8);
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GREEN);
            cell.setPadding (10.0f);
            table.addCell (cell);
            table.addCell("ID");
            table.addCell(value1);
            table.addCell("First Name");
            table.addCell(value2);
            table.addCell("Last Name");
            table.addCell(value3);
            table.addCell("Age");
            table.addCell(value4);

            document.add(table);

            com.itextpdf.text.List list = new com.itextpdf.text.List(true,20);
            list.add("First");
            list.add("Second");
            list.add("Third");
            list.add("Fourth");

            document.add(list);

            com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance("Chart.png");
            document.add(new Paragraph("Image"));
            document.add(image2);

            document.close();
            JOptionPane.showMessageDialog(null, "Saved");

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed

        txt_proid.setText(" ");
        txt_name.setText(" ");
        
        txt_price.setText(" ");
        txt_adddate.setDate(null);
        lbl_img.setIcon(null);
        
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try
        {
            String value1 = txt_proid.getText();
            String value2 = txt_name.getText();
            
            String value3 = txt_price.getText();
            String value4 = txt_adddate.getDateFormatString();
            byte[] value5 = lbl_img.getText().getBytes();
            

            //String sql = "Update Employee set ID='"+value1+"', FirstName='"+value2+"', Lastname='"+value3+"', Age='"+value4+"' where EmployeeId='"+value1+"' ";
            String sql = "Update Product_food set ID='"+value1+"',Name='"+value2+"',,Price='"+value3+"',Date='"+value4+"',Image='"+value5+"' where ID='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        Update_Table();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        //String sql = "Insert into Product_food (ID,Name,Category,Price,Date,Image) values (?,?,?,?,?,?)";
        try
        {
            String sql = "Insert into Product_food (ID,Name,Price,Date,Image) values (?,?,?,?,?)";
            pst=conn.prepareStatement(sql);

           
            pst.setString(1, txt_proid.getText());
            pst.setString(2, txt_name.getText());
            
            pst.setString(3, txt_price.getText());
            
            Date date1 = new Date();
            Date daysAgo = new DateTime(date1).minusDays(365).toDate();
            //String sDate1="2010-01-01";  
    //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
       String sDate2=((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText();
    Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2); 
       
       if(date2.before(daysAgo))
    {
        try
        {
        File file = new File("D:\\Software Engineering\\4th YEAR\\12th SEMESTER\\NetbeansProject\\expire01.mp3");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        try
        {
            Player player = new Player(bis);
            player.play();
            txt_adddate.setBackground(Color.red);
        JOptionPane.showMessageDialog(null, "This product's date is aleardy expired. So don't add this product.");
        }
        catch(JavaLayerException ex)
        {
            
        }
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        

        
    }
    else
    {
         pst.setString(4, ((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText());
         pst.setBytes(5, person_image);
         pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
    }
            
            
            //pst.setString(5, ((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText());
            //pst.setBytes(5, person_image);
            

            //pst.execute();
            //JOptionPane.showMessageDialog(null, "Saved");
        
            rs.close();
            pst.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        /*try{
            String sq = "Insert into Stock (ID,Name,Price,Date) values (?,?,?,?)";
            pst=conn.prepareStatement(sq);

            
            pst.setString(1, txt_proid.getText());
            pst.setString(2, txt_name.getText());
            
            pst.setString(3, txt_price.getText());
            
            String sDate1="2010-01-01";  
    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
       String sDate2=((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText();
    Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2); 
       
       if(date2.before(date1))
    {
        JOptionPane.showMessageDialog(null, "This product's date is aleardy expired. So don't store this product into your stock either.");
        txt_adddate.setBackground(Color.red);
    }
    else
    {
         pst.setString(4, ((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText());
         pst.setBytes(5, person_image);
         pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
    }
            //pst.setString(5, ((JTextField)txt_adddate.getDateEditor().getUiComponent()).getText());
            //pst.setBytes(5, person_image);
            

            //pst.execute();
            //JOptionPane.showMessageDialog(null, "Saved");
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }*/
        
        /*try
        {
            String sq = "select * from Stock where (ID) NOT IN (select ID from Product_food)";
            pst=conn.prepareStatement(sq);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                String add2 = rs.getString("Name");
                String add3 = rs.getString("Category");
                Double add4 = rs.getDouble("Price");
                String result = add3.replace("/", "");
                String s = "Insert into Product_food (Name,Category,Price,stockId) values ('"+add2+"','"+result+"','"+add4+"','"+add1+"')";
                pst=conn.prepareStatement(s);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Created: "+"Name: "+add2+"Category: "+result);
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }*/
        
        Update_Table();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            String sql = "Delete from Product_food where ID=?";
            try
            {
                pst=conn.prepareStatement(sql);

                pst.setString(1, txt_proid.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            Update_Table();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Report Printed");
        MessageFormat footer = new MessageFormat("Page(0,number,integer)");
        try
        {
            tbl_foods.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(java.awt.print.PrinterException e)
        {
            System.err.format("Cannot Print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Close();
        NewWindow nw = new NewWindow();
        nw.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Close();
        FoodsJFrame fd = new FoodsJFrame();
        fd.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try
        {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"D:\\Software Engineering\\4th YEAR\\11th SEMESTER\\Research_Project\\INVENTORYMANAGEMENTSYSTEMFORDEPARTMENTALSTORE.pdf");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menu_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_dateActionPerformed

    private void tbl_foodsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_foodsKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)
        {
            try
        {
            int raw = tbl_foods.getSelectedRow();
            String Table_Click = (tbl_foods.getModel().getValueAt(raw, 0).toString());
            String sql = "Select * from Product_food where ID='"+Table_Click+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_proid.setText(add1);
                String add2 = rs.getString("Name");
                txt_name.setText(add2);
                Double add3 = rs.getDouble("Price");
                txt_price.setText(Double.toString(add3));
                Date add4 = rs.getDate("Date");
                txt_adddate.setDate(add4);
                byte[] imagedata = rs.getBytes("Image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
                lbl_img.setIcon(new ImageIcon(scaledImg));
                txt_imgpath.setText(filename);

                //format = new ImageIcon(add5);
                //lbl_img.setIcon(format);
                
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_tbl_foodsKeyReleased

    private void tbl_foodsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_foodsMouseClicked

/*int i = jTable1.getSelectedRow();
        if(jTable1.getValueAt(i, 4) != null)
        {
        ImageIcon image1 = (ImageIcon)jTable1.getValueAt(i, 4);
        Image image2 = image1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight()
                 , Image.SCALE_SMOOTH);
        ImageIcon image3 = new ImageIcon(image2);
        jLabel1.setIcon(image3);
        }
        else{
            System.out.println("No Image");
        }*/

        int raw = tbl_foods.getSelectedRow();
        String Table_Click = (tbl_foods.getModel().getValueAt(raw, 0).toString());
        try
        {
            String sql = "Select Image from Product_food where ID='"+Table_Click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                byte[] imagedata = rs.getBytes("Image");
                /*format = new ImageIcon(imagedata);
                lbl_img.setIcon(format);*/
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
                lbl_img.setIcon(new ImageIcon(scaledImg));
                txt_imgpath.setText(filename);
                        /*ImageIcon imageIcon = new ImageIcon(imagedata);
        Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imag = new ImageIcon(img);
      lbl_img.setIcon(imag);*/
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            
            String sql = "Select * from Product_food where ID='"+Table_Click+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_proid.setText(add1);
                String add2 = rs.getString("Name");
                txt_name.setText(add2);
                Double add3 = rs.getDouble("Price");
                txt_price.setText(Double.toString(add3));
                Date add4 = rs.getDate("Date");
                txt_adddate.setDate(add4);
                byte[] imagedata = rs.getBytes("Image"); 
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
                lbl_img.setIcon(new ImageIcon(scaledImg));
                txt_imgpath.setText(filename);
                /*ImageIcon imageIcon = new ImageIcon(imagedata);
        Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imag = new ImageIcon(img);
      lbl_img.setIcon(imag);*/
        
                /*byte[] add5 = rs.getBytes("Image");
                format = new ImageIcon(add5);
                lbl_img.setIcon(format);*/
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbl_foodsMouseClicked
    
   /*public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bi;
}*/
   /*public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
    return bi;
    }*/
    
    /*private Image fitimage(Image img , int w , int h)
{
    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = resizedimage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(img, 0, 0,w,h,null);
    g2.dispose();
    return resizedimage;
}*/
    /*public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bi;
}*/
    public static BufferedImage createScaledImage(BufferedImage original, int newWidth, int newHeight) {
    BufferedImage scaledImg = new BufferedImage(newWidth, newHeight, original.getType());
    Graphics2D g = scaledImg.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawImage(original, 0, 0, newWidth, newHeight, null, null);
    g.dispose();
    return scaledImg;
}
    
    /*private Image ScaledImage(Image img, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
            Graphics2D g2 = resizedImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g2.drawImage(img, 0, 0, w, h, null);
            g2.dispose();
        
        return resizedImage;
    }*/
    
    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed

            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile(); //file
            //File f = chooser.getCurrentDirectory(); //folder
            filename = f.getAbsolutePath();
            
            try {
            BufferedImage img = ImageIO.read(new File(filename));
            BufferedImage scaledImg = createScaledImage(img, lbl_img.getWidth(), lbl_img.getHeight());
            lbl_img.setIcon(new ImageIcon(scaledImg));
            txt_imgpath.setText(filename);
            
                File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
            
            }
            }
            catch (IOException ex) {
            Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            /*try
                {
            byte[] imageBytes = new byte[1024];
BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
BufferedImage scaledImg = createScaledImage(image, lbl_img.getWidth(), lbl_img.getHeight());
lbl_img.setIcon(new ImageIcon(scaledImg));
            txt_imgpath.setText(filename);
            
            }
                catch(IOException ex)
                {
                    Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE,null,ex);
                }*/
            
        
            /*try
                {
                BufferedImage img = ImageIO.read(new File(filename));
            //int width = lbl_img.getWidth();
            //int height = lbl_img.getHeight();
            Image image = img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
            BufferedImage buffered = new BufferedImage(lbl_img.getWidth(), lbl_img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            buffered.getGraphics().drawImage(image, 0, 0 , null);
            
            ImageIcon imageIcon = new ImageIcon(buffered);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);
                    
                File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
                }
                
                }
                catch(IOException ex)
                {
                    Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE,null,ex);
                }*/
        
            /*ImageIcon imageIcon = new ImageIcon(filename); // load the image to a imageIcon
Image image = imageIcon.getImage(); // transform it 
Image newimg = image.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon = new ImageIcon(newimg);  // transform it back
 lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);*/
            
            /*try {
            BufferedImage img = ImageIO.read(new File(filename));
            BufferedImage scaledImg = createScaledImage(img, lbl_img.getWidth(), lbl_img.getHeight());
            lbl_img.setIcon(new ImageIcon(scaledImg));
            txt_imgpath.setText(filename);
            
                File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
            
            }
            }
            catch (IOException ex) {
            Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            /*try {
            
            BufferedImage img = ImageIO.read(new File(filename));
            int width = lbl_img.getWidth();
            int height = lbl_img.getHeight();
            Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage buffered = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            buffered.getGraphics().drawImage(image, 0, 0 , null);
            
            ImageIcon imageIcon = new ImageIcon(buffered);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);
            
            
            File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
                }*/
            
            
            /*try
            {
                File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
                
            }
                } catch (IOException ex) {
            Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            /* BufferedImage img = null;
            try {
            img = ImageIO.read(new File(filename));
            } catch (IOException e) {
            e.printStackTrace();
            }
            
            Image dimg = img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);*/
            
            /*BufferedImage img = null;
            try {
            img = ImageIO.read(new File(filename));
            } catch (IOException e) {
            e.printStackTrace();
            }
            
            BufferedImage dimg = (BufferedImage)img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);*/
            
            /*try {
            
            BufferedImage img = ImageIO.read(new File(filename));
            int width = lbl_img.getWidth();
            int height = lbl_img.getHeight();
            Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage buffered = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            buffered.getGraphics().drawImage(image, 0, 0 , null);
            
            ImageIcon imageIcon = new ImageIcon(buffered);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);
            
            
            File file  = new File(filename);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;)
                {
                bos.write(buf,0,readNum);
                }
                {
                person_image=bos.toByteArray();
                }*/
            /*BufferedImage img = null;
            try {
            img = ImageIO.read(new File(filename));
            } catch (IOException e) {
            e.printStackTrace();
            }
            Image toolkitImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            int width = lbl_img.getWidth();
            int height = lbl_img.getHeight();
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            //BufferedImage newImage = (BufferedImage) img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            Graphics g = newImage.getGraphics();
            g.drawImage(toolkitImage, 0, 0, null);
            g.dispose();
            //BufferedImage dimg = (BufferedImage) img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newImage);
            lbl_img.setIcon(imageIcon);
            txt_imgpath.setText(filename);*/
        /*} catch (IOException ex) {
            Logger.getLogger(FoodsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            
        
    }//GEN-LAST:event_btn_browseActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        Close();
        Mail mail=new Mail();
        mail.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //InputStream in;
        //AudioPlayer mgp = AudioPlayer.player;
        try
        {
            /*in = new FileInputStream(new File("D:\\Software Engineering\\4th YEAR\\12th SEMESTER\\NetbeansProject\\expire01.mp3"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);*/
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FoodsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_select;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JMenu menu_date;
    private javax.swing.JMenu menu_logout;
    private javax.swing.JMenu menu_time;
    private javax.swing.JTable tbl_foods;
    private com.toedter.calendar.JDateChooser txt_adddate;
    private javax.swing.JTextField txt_imgpath;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_proid;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

Timer timer;
private ImageIcon format = null;
String filename = null;
int s = 0;
byte[] person_image = null;
private String gender;
private String status;
}
