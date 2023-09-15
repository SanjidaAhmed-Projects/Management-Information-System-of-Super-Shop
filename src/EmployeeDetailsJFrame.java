
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static jdk.nashorn.internal.runtime.regexp.joni.constants.TokenType.INTERVAL;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import org.bytedeco.javacpp.opencv_highgui;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import org.bytedeco.javacpp.opencv_videoio;
import org.bytedeco.javacpp.opencv_videoio.CvCapture;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
public class EmployeeDetailsJFrame extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs = null;
    PreparedStatement pst=null;
    public EmployeeDetailsJFrame() {
        initComponents();
        conn=JavaConnector.ConnectorDb();
        Update_Table();
        Fill_Combo();
        CurrentDate();
        
    }
//String imgpath=null;
    public void Close()
    {
        //WindowEvent winClosingEvent = new WindowEvent( this, WindowEvent.WINDOW_CLOSING );
        //Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
        this.setVisible(false);
        this.dispose();
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
    private void Update_Table()
    {
        try
        {
            String sql="Select * from Employee";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tbl_empdetails.setModel(DbUtils.resultSetToTableModel(rs));
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
    
     private void Fill_Combo()
    {
        try
        {
            String sql="Select * from Employee";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
            String Name=rs.getString("FirstName");
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
     
     /*private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_report = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_hire = new com.toedter.calendar.JDateChooser();
        txt_salary = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_peradd = new javax.swing.JTextField();
        txt_empid = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_title = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        txt_desig = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_contactno = new javax.swing.JTextField();
        txt_date = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_preadd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_dept = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        rdobtn_male = new javax.swing.JRadioButton();
        rdobtn_female = new javax.swing.JRadioButton();
        chckbox_active = new javax.swing.JCheckBox();
        chckbox_retired = new javax.swing.JCheckBox();
        cmb_select = new javax.swing.JComboBox<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl_image = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        image_path = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_empdetails = new javax.swing.JTable();
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
        jMenu3 = new javax.swing.JMenu();
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
                .addContainerGap(22, Short.MAX_VALUE))
        );

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Present Address:");

        txt_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salaryActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Job Title:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Contact no:");

        txt_peradd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_peraddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Last Name:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Date Hired:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Password:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("First Name:");

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Designation:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Status:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Permanent Address:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("E-mail:");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("User Name:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Department:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Employee ID:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Date of Birth:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Gender:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Basic Salary:");

        buttonGroup1.add(rdobtn_male);
        rdobtn_male.setText("Male");
        rdobtn_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtn_maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdobtn_female);
        rdobtn_female.setText("Female");
        rdobtn_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtn_femaleActionPerformed(evt);
            }
        });

        buttonGroup2.add(chckbox_active);
        chckbox_active.setText("Active");
        chckbox_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbox_activeActionPerformed(evt);
            }
        });

        buttonGroup2.add(chckbox_retired);
        chckbox_retired.setText("Retired");
        chckbox_retired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbox_retiredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(55, 55, 55)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdobtn_male)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_contactno, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addComponent(txt_preadd)
                                        .addComponent(txt_peradd)
                                        .addComponent(txt_email)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rdobtn_female)))
                .addGap(32, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_desig)
                            .addComponent(txt_dept)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(chckbox_active)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chckbox_retired)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password)
                            .addComponent(txt_username)
                            .addComponent(txt_title)
                            .addComponent(txt_salary))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdobtn_female)
                            .addComponent(rdobtn_male)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(txt_desig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(chckbox_active)
                            .addComponent(chckbox_retired))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_hire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addComponent(txt_contactno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_peradd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txt_salary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17))
                                            .addComponent(txt_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18))
                                    .addComponent(txt_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_preadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jDesktopPane1.setLayer(lbl_image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton8.setText("Attach");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Capture");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        tbl_empdetails.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_empdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empdetailsMouseClicked(evt);
            }
        });
        tbl_empdetails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_empdetailsKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_empdetails);

        jScrollPane1.setViewportView(jScrollPane2);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

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
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
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
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

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
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Next-icon.png"))); // NOI18N
        jMenuItem9.setText("Next");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        menu_date.setText("Date");
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

        jMenu3.setForeground(new java.awt.Color(204, 0, 0));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apps-session-logout-icon.png"))); // NOI18N
        jMenu3.setText("Logout");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_select, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addComponent(image_path))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton8))
                        .addGap(32, 32, 32)
                        .addComponent(image_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1066, 945));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salaryActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_peraddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_peraddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_peraddActionPerformed

    private void rdobtn_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtn_maleActionPerformed
        gender="Male";
    }//GEN-LAST:event_rdobtn_maleActionPerformed

    private void rdobtn_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtn_femaleActionPerformed
        gender="Female";
    }//GEN-LAST:event_rdobtn_femaleActionPerformed

    private void chckbox_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbox_activeActionPerformed
        status="Active";
    }//GEN-LAST:event_chckbox_activeActionPerformed

    private void chckbox_retiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbox_retiredActionPerformed
        status="Retired";
    }//GEN-LAST:event_chckbox_retiredActionPerformed
    
    public static BufferedImage createScaledImage(BufferedImage original, int newWidth, int newHeight) {
    BufferedImage scaledImg = new BufferedImage(newWidth, newHeight, original.getType());
    Graphics2D g = scaledImg.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawImage(original, 0, 0, newWidth, newHeight, null, null);
    g.dispose();
    return scaledImg;
}
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile(); //file
        //File f = chooser.getCurrentDirectory(); //folder
        filename = f.getAbsolutePath();
        
        try {
            BufferedImage img = ImageIO.read(new File(filename));
            BufferedImage scaledImg = createScaledImage(img, lbl_image.getWidth(), lbl_image.getHeight());
            lbl_image.setIcon(new ImageIcon(scaledImg));
            image_path.setText(filename);
            
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
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String sql = "Insert into Employee (ID,FirstName,LastName,DateOfBirth,Gender,Email,ContactNo,PresentAddress,PermanentAddress,Department,Designation,Status,DateHired,BasicSalary,JobTitle,UserName,Password,Image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, txt_empid.getText());
            pst.setString(2, txt_fname.getText());
            pst.setString(3, txt_lname.getText());
            pst.setString(4, ((JTextField)txt_date.getDateEditor().getUiComponent()).getText());
            pst.setString(5, gender);
            pst.setString(6, txt_email.getText());
            pst.setString(7, txt_contactno.getText());
            pst.setString(8, txt_preadd.getText());
            pst.setString(9, txt_peradd.getText());
            pst.setString(10, txt_dept.getText());
            pst.setString(11, txt_desig.getText());
            pst.setString(12, status);
            pst.setString(13, ((JTextField)txt_hire.getDateEditor().getUiComponent()).getText());
            pst.setString(14, txt_salary.getText());
            pst.setString(15, txt_title.getText());
            pst.setString(16, txt_username.getText());
            pst.setString(17, txt_password.getText());
            pst.setBytes(18, person_image);
         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
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
        Update_Table();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       // if(imgpath == null){
        
        try
        {
            String value1 = txt_empid.getText();
            String value2 = txt_fname.getText();
            String value3 = txt_lname.getText();
            String value4 = txt_date.getDateFormatString();
            //String value5 = 
            String value6 = txt_email.getText();
            String value7 = txt_contactno.getText();
            String value8 = txt_preadd.getText();
            String value9 = txt_peradd.getText();
            String value10 = txt_dept.getText();
            String value11 = txt_desig.getText();
            //String value12 =
            String value13 = txt_hire.getDateFormatString();
            String value14 = txt_salary.getText();
            String value15 = txt_title.getText();
            String value16 = txt_username.getText();
            String value17 = txt_password.getText();
            byte[] value18 = lbl_image.getText().getBytes();

            //String sql = "Update Employee set ID='"+value1+"', FirstName='"+value2+"', Lastname='"+value3+"', Age='"+value4+"' where EmployeeId='"+value1+"' ";
            String sql = "Update Employee set ID='"+value1+"',FirstName='"+value2+"',LastName='"+value3+"',DateOfBirth='"+value4+"',Email='"+value6+"',ContactNo='"+value7+"',PresentAddress='"+value8+"',PermanentAddress='"+value9+"',Department='"+value10+"',Designation='"+value11+"',DateHired='"+value13+"',BasicSalary='"+value14+"',JobTitle='"+value15+"',UserName='"+value16+"',Password='"+value17+"',Image='"+value18+"' where ID='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
               // conn.close();
            }
            catch(Exception e)
            {
                
            }
        }
       /* }
        else{
            try{
                InputStream img = new FileInputStream(new File(imgpath));
                String value1 = txt_empid.getText();
            String value2 = txt_fname.getText();
            String value3 = txt_lname.getText();
            String value4 = txt_date.getDateFormatString();
            //String value5 = 
            String value6 = txt_email.getText();
            String value7 = txt_contactno.getText();
            String value8 = txt_preadd.getText();
            String value9 = txt_peradd.getText();
            String value10 = txt_dept.getText();
            String value11 = txt_desig.getText();
            //String value12 =
            String value13 = txt_hire.getDateFormatString();
            String value14 = txt_salary.getText();
            String value15 = txt_title.getText();
            String value16 = txt_username.getText();
            String value17 = txt_password.getText();
            byte[] value18 = lbl_image.getText().getBytes();

            //String sql = "Update Employee set ID='"+value1+"', FirstName='"+value2+"', Lastname='"+value3+"', Age='"+value4+"' where EmployeeId='"+value1+"' ";
            String sql = "Update Employee set ID='"+value1+"',FirstName='"+value2+"',LastName='"+value3+"',DateOfBirth='"+value4+"',Email='"+value6+"',ContactNo='"+value7+"',PresentAddress='"+value8+"',PermanentAddress='"+value9+"',Department='"+value10+"',Designation='"+value11+"',DateHired='"+value13+"',BasicSalary='"+value14+"',JobTitle='"+value15+"',UserName='"+value16+"',Password='"+value17+"',Image='"+value18+"' where ID='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }*/
        
        Update_Table();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
        String sql = "Delete from Employee where ID=?";
        try
        {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, txt_empid.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
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
               // conn.close();
            }
            catch(Exception e)
            {
                
            }
        }
        Update_Table();
        }
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void cmb_selectPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_selectPopupMenuWillBecomeInvisible
        //comboselect();
        
        String tmp = (String)cmb_select.getSelectedItem();
        String sql = "Select * from Employee where FirstName=?";
        
        try
        {
            
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs=pst.executeQuery();
            if(rs.next())
            {
                                String add1 = rs.getString("ID");
                                txt_empid.setText(add1);
                                String add2 = rs.getString("FirstName");
                                txt_fname.setText(add2);
                                String add3 = rs.getString("LastName");
                                txt_lname.setText(add3);
                                Date add4 = rs.getDate("DateOfBirth");
                                txt_date.setDate(add4);
                                 //String add5 = rs.getString("Gender");
                                 
                                 String add6 = rs.getString("Email");
                                 txt_email.setText(add6);
                                 String add7 = rs.getString("ContactNo");
                                 txt_contactno.setText(add7);
                                 String add8 = rs.getString("PresentAddress");
                                 txt_preadd.setText(add8);
                                 String add9 = rs.getString("PermanentAddress");
                                 txt_peradd.setText(add9);
                                 String add10 = rs.getString("Department");
                                 txt_dept.setText(add10);
                                 String add11 = rs.getString("Designation");
                                 txt_desig.setText(add11);
                                 //String add12 = rs.getString("Status");
                                 
                                 Date add13 = rs.getDate("DateHired");
                                 txt_hire.setDate(add13);
                                 Double add14 = rs.getDouble("BasicSalary");
                                 txt_salary.setText(Double.toString(add14));
                                 String add15 = rs.getString("JobTitle");
                                 txt_title.setText(add15);
                                 String add16 = rs.getString("UserName");
                                 txt_username.setText(add16);
                                 String add17 = rs.getString("Password");
                                 txt_password.setText(add17);
                                 byte[] add18 = rs.getBytes("Image");
                                format = new ImageIcon(add18);
                                lbl_image.setIcon(format);
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
    }//GEN-LAST:event_cmb_selectPopupMenuWillBecomeInvisible

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
                                
                                 txt_empid.setText(" ");       
                                 txt_fname.setText(" ");                                
                                 txt_lname.setText(" ");                               
                                 txt_date.setDate(null);                               
                                 //rdobtn_male.setText(" ");
                                 //rdobtn_female.setText(" ");
                                 txt_email.setText(" ");                                
                                 txt_contactno.setText(" ");                                
                                 txt_preadd.setText(" ");                                
                                 txt_peradd.setText(" ");                                
                                 txt_dept.setText(" ");                                
                                 txt_desig.setText(" ");                                
                                 //chckbox_active.setText(" ");
                                 //chckbox_retired.setText(" ");                                 
                                 txt_hire.setDate(null);                                
                                 txt_salary.setText(" ");                                 
                                 txt_title.setText(" ");                                
                                 txt_username.setText(" ");                                
                                 txt_password.setText(" ");                               
                                 lbl_image.setIcon(null);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        try
        {
            String sql = "Select * from Employee where ID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_empid.setText(add1);
                String add2 = rs.getString("FirstName");
                txt_fname.setText(add2);
                String add3 = rs.getString("LastName");
                txt_lname.setText(add3);
                Date add4 = rs.getDate("DateOfBirth");
                txt_date.setDate(add4);
                //String add5 = rs.getString("Gender");

                String add6 = rs.getString("Email");
                txt_email.setText(add6);
                String add7 = rs.getString("ContactNo");
                txt_contactno.setText(add7);
                String add8 = rs.getString("PresentAddress");
                txt_preadd.setText(add8);
                String add9 = rs.getString("PermanentAddress");
                txt_peradd.setText(add9);
                String add10 = rs.getString("Department");
                txt_dept.setText(add10);
                String add11 = rs.getString("Designation");
                txt_desig.setText(add11);
                //String add12 = rs.getString("Status");

                Date add13 = rs.getDate("DateHired");
                txt_hire.setDate(add13);
                Double add14 = rs.getDouble("BasicSalary");
                txt_salary.setText(Double.toString(add14));
                String add15 = rs.getString("JobTitle");
                txt_title.setText(add15);
                String add16 = rs.getString("UserName");
                txt_username.setText(add16);
                String add17 = rs.getString("Password");
                txt_password.setText(add17);
                byte[] imagedata = rs.getBytes("Image");
                                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
BufferedImage scaledImg = createScaledImage(image, lbl_image.getWidth(), lbl_image.getHeight());
lbl_image.setIcon(new ImageIcon(scaledImg));
image_path.setText(filename);
                //byte[] add18 = rs.getBytes("Image");
                //format = new ImageIcon(add18);
                //lbl_image.setIcon(format);
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
        try
        {
            String sql = "Select * from Employee where FirstName=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_empid.setText(add1);
                String add2 = rs.getString("FirstName");
                txt_fname.setText(add2);
                String add3 = rs.getString("LastName");
                txt_lname.setText(add3);
                Date add4 = rs.getDate("DateOfBirth");
                txt_date.setDate(add4);
                //String add5 = rs.getString("Gender");

                String add6 = rs.getString("Email");
                txt_email.setText(add6);
                String add7 = rs.getString("ContactNo");
                txt_contactno.setText(add7);
                String add8 = rs.getString("PresentAddress");
                txt_preadd.setText(add8);
                String add9 = rs.getString("PermanentAddress");
                txt_peradd.setText(add9);
                String add10 = rs.getString("Department");
                txt_dept.setText(add10);
                String add11 = rs.getString("Designation");
                txt_desig.setText(add11);
                //String add12 = rs.getString("Status");

                Date add13 = rs.getDate("DateHired");
                txt_hire.setDate(add13);
                Double add14 = rs.getDouble("BasicSalary");
                txt_salary.setText(Double.toString(add14));
                String add15 = rs.getString("JobTitle");
                txt_title.setText(add15);
                String add16 = rs.getString("UserName");
                txt_username.setText(add16);
                String add17 = rs.getString("Password");
                txt_password.setText(add17);
                byte[] imagedata = rs.getBytes("Image");
                                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
BufferedImage scaledImg = createScaledImage(image, lbl_image.getWidth(), lbl_image.getHeight());
lbl_image.setIcon(new ImageIcon(scaledImg));
image_path.setText(filename);
                //byte[] add18 = rs.getBytes("Image");
                //format = new ImageIcon(add18);
                //lbl_image.setIcon(format);
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
        try
        {
            String sql = "Select * from Employee where LastName=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_empid.setText(add1);
                String add2 = rs.getString("FirstName");
                txt_fname.setText(add2);
                String add3 = rs.getString("LastName");
                txt_lname.setText(add3);
                Date add4 = rs.getDate("DateOfBirth");
                txt_date.setDate(add4);
                //String add5 = rs.getString("Gender");

                String add6 = rs.getString("Email");
                txt_email.setText(add6);
                String add7 = rs.getString("ContactNo");
                txt_contactno.setText(add7);
                String add8 = rs.getString("PresentAddress");
                txt_preadd.setText(add8);
                String add9 = rs.getString("PermanentAddress");
                txt_peradd.setText(add9);
                String add10 = rs.getString("Department");
                txt_dept.setText(add10);
                String add11 = rs.getString("Designation");
                txt_desig.setText(add11);
                //String add12 = rs.getString("Status");

                Date add13 = rs.getDate("DateHired");
                txt_hire.setDate(add13);
                Double add14 = rs.getDouble("BasicSalary");
                txt_salary.setText(Double.toString(add14));
                String add15 = rs.getString("JobTitle");
                txt_title.setText(add15);
                String add16 = rs.getString("UserName");
                txt_username.setText(add16);
                String add17 = rs.getString("Password");
                txt_password.setText(add17);
                byte[] add18 = rs.getBytes("Image");
                format = new ImageIcon(add18);
                lbl_image.setIcon(format);
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
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        String sql = "Insert into Employee (ID,FirstName,LastName,DateOfBirth,Gender,Email,ContactNo,PresentAddress,PermanentAddress,Department,Designation,Status,DateHired,BasicSalary,JobTitle,UserName,Password,Image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, txt_empid.getText());
            pst.setString(2, txt_fname.getText());
            pst.setString(3, txt_lname.getText());
            pst.setString(4, ((JTextField)txt_date.getDateEditor().getUiComponent()).getText());
            pst.setString(5, gender);
            pst.setString(6, txt_email.getText());
            pst.setString(7, txt_contactno.getText());
            pst.setString(8, txt_preadd.getText());
            pst.setString(9, txt_peradd.getText());
            pst.setString(10, txt_dept.getText());
            pst.setString(11, txt_desig.getText());
            pst.setString(12, status);
            pst.setString(13, ((JTextField)txt_hire.getDateEditor().getUiComponent()).getText());
            pst.setString(14, txt_salary.getText());
            pst.setString(15, txt_title.getText());
            pst.setString(16, txt_username.getText());
            pst.setString(17, txt_password.getText());
            pst.setBytes(18, person_image);
         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
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
        Update_Table();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Close();
        NewWindow nw = new NewWindow();
        nw.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Close();
        EmployeeDetailsJFrame empdetails=new EmployeeDetailsJFrame();
        empdetails.setVisible(true);
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

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Report Printed");
        MessageFormat footer = new MessageFormat("Page(0,number,integer)");
        try
        {
            tbl_empdetails.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(java.awt.print.PrinterException e)
        {
            System.err.format("Cannot Print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Close();
        LogInJFrame login=new LogInJFrame();
        login.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Close();
        NewWindow nw = new NewWindow();
        nw.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String sql = "Insert into Employee (ID,FirstName,LastName,DateOfBirth,Gender,Email,ContactNo,PresentAddress,PermanentAddress,Department,Designation,Status,DateHired,BasicSalary,JobTitle,UserName,Password,Image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, txt_empid.getText());
            pst.setString(2, txt_fname.getText());
            pst.setString(3, txt_lname.getText());
            pst.setString(4, ((JTextField)txt_date.getDateEditor().getUiComponent()).getText());
            pst.setString(5, gender);
            pst.setString(6, txt_email.getText());
            pst.setString(7, txt_contactno.getText());
            pst.setString(8, txt_preadd.getText());
            pst.setString(9, txt_peradd.getText());
            pst.setString(10, txt_dept.getText());
            pst.setString(11, txt_desig.getText());
            pst.setString(12, status);
            pst.setString(13, ((JTextField)txt_hire.getDateEditor().getUiComponent()).getText());
            pst.setString(14, txt_salary.getText());
            pst.setString(15, txt_title.getText());
            pst.setString(16, txt_username.getText());
            pst.setString(17, txt_password.getText());
            pst.setBytes(18, person_image);
         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
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
        Update_Table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        Close();
        AdministratorLogin ad=new AdministratorLogin();
        ad.setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Close();
        EmpJFrame emp=new EmpJFrame();
        emp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Close();
        EmployeeDetailsJFrame empdetails=new EmployeeDetailsJFrame();
        empdetails.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
        
        
            String value1 = txt_empid.getText();
            String value2 = txt_fname.getText();
            String value3 = txt_lname.getText();
            String value4 = txt_date.getDateFormatString();
            //String value5 = 
            String value6 = txt_email.getText();
            String value7 = txt_contactno.getText();
            String value8 = txt_preadd.getText();
            String value9 = txt_peradd.getText();
            String value10 = txt_dept.getText();
            String value11 = txt_desig.getText();
            //String value12 =
            String value13 = txt_hire.getDateFormatString();
            String value14 = txt_salary.getText();
            String value15 = txt_title.getText();
            String value16 = txt_username.getText();
            String value17 = txt_password.getText();
            byte[] value18 = lbl_image.getText().getBytes();
        
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //Lbl_Date.setText("Date : "   + day + "/" + (month + 1) + "/" + year);
        //System.out.println("Current date : " + day + "/" + (month + 1) + "/" + year);

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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sql = "Insert into Employee (ID,FirstName,LastName,DateOfBirth,Gender,Email,ContactNo,PresentAddress,PermanentAddress,Department,Designation,Status,DateHired,BasicSalary,JobTitle,UserName,Password,Image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, txt_empid.getText());
            pst.setString(2, txt_fname.getText());
            pst.setString(3, txt_lname.getText());
            pst.setString(4, ((JTextField)txt_date.getDateEditor().getUiComponent()).getText());
            pst.setString(5, gender);
            pst.setString(6, txt_email.getText());
            pst.setString(7, txt_contactno.getText());
            pst.setString(8, txt_preadd.getText());
            pst.setString(9, txt_peradd.getText());
            pst.setString(10, txt_dept.getText());
            pst.setString(11, txt_desig.getText());
            pst.setString(12, status);
            pst.setString(13, ((JTextField)txt_hire.getDateEditor().getUiComponent()).getText());
            pst.setString(14, txt_salary.getText());
            pst.setString(15, txt_title.getText());
            pst.setString(16, txt_username.getText());
            pst.setString(17, txt_password.getText());
            pst.setBytes(18, person_image);
         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
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
        Update_Table();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Close();
        EmpJFrame emp=new EmpJFrame();
        emp.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed
 
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       final int INTERVAL = 0;
    CanvasFrame canvas = new CanvasFrame("Web Cam");
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try
        {
            //OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);  
       grabber.start();  
       
       //opencv_core.IplImage grabbedImage = grabber.grab();

//FrameGrabber grabber = FrameGrabber.createDefault(0);
            //grabber.start();
            OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

            //IplImage img = grabber.grab();
            IplImage img = converter.convert(grabber.grab());
            if(img!=null)
            {
                org.bytedeco.javacv.Frame frame = grabber.grab();

                img = converter.convert(frame);

                //the grabbed frame will be flipped, re-flip to make it right
                cvFlip(img, img, 1);
                cvSaveImage("capture.jpeg",img);
                canvas.showImage(converter.convert(img));

                Thread.sleep(INTERVAL);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        Close();
        Mail mail=new Mail();
        mail.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void tbl_empdetailsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_empdetailsKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)
        {
            try
            {
                int raw = tbl_empdetails.getSelectedRow();
                String Table_Click = (tbl_empdetails.getModel().getValueAt(raw, 0).toString());
                String sql = "Select * from Employee where ID='"+Table_Click+"' ";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String add1 = rs.getString("ID");
                    txt_empid.setText(add1);
                    String add2 = rs.getString("FirstName");
                    txt_fname.setText(add2);
                    String add3 = rs.getString("LastName");
                    txt_lname.setText(add3);
                    Date add4 = rs.getDate("DateOfBirth");
                    txt_date.setDate(add4);
                    //String add5 = rs.getString("Gender");

                    String add6 = rs.getString("Email");
                    txt_email.setText(add6);
                    String add7 = rs.getString("ContactNo");
                    txt_contactno.setText(add7);
                    String add8 = rs.getString("PresentAddress");
                    txt_preadd.setText(add8);
                    String add9 = rs.getString("PermanentAddress");
                    txt_peradd.setText(add9);
                    String add10 = rs.getString("Department");
                    txt_dept.setText(add10);
                    String add11 = rs.getString("Designation");
                    txt_desig.setText(add11);
                    //String add12 = rs.getString("Status");

                    Date add13 = rs.getDate("DateHired");
                    txt_hire.setDate(add13);
                    Double add14 = rs.getDouble("BasicSalary");
                    txt_salary.setText(Double.toString(add14));
                    String add15 = rs.getString("JobTitle");
                    txt_title.setText(add15);
                    String add16 = rs.getString("UserName");
                    txt_username.setText(add16);
                    String add17 = rs.getString("Password");
                    txt_password.setText(add17);
                    byte[] imagedata = rs.getBytes("Image");
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                    BufferedImage scaledImg = createScaledImage(image, lbl_image.getWidth(), lbl_image.getHeight());
                    lbl_image.setIcon(new ImageIcon(scaledImg));
                    image_path.setText(filename);

                    //format = new ImageIcon(add18);
                    //lbl_image.setIcon(format);

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
                    // conn.close();
                }
                catch(Exception e)
                {

                }
            }
        }
    }//GEN-LAST:event_tbl_empdetailsKeyReleased

    private void tbl_empdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empdetailsMouseClicked
        int raw = tbl_empdetails.getSelectedRow();
        String Table_Click = (tbl_empdetails.getModel().getValueAt(raw, 0).toString());
        try
        {
            String sql = "Select Image from Employee where ID='"+Table_Click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                byte[] imagedata = rs.getBytes("Image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_image.getWidth(), lbl_image.getHeight());
                lbl_image.setIcon(new ImageIcon(scaledImg));
                image_path.setText(filename);
                //format = new ImageIcon(imagedata);
                //lbl_image.setIcon(format);

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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

        try
        {

            String sql = "Select * from Employee where ID='"+Table_Click+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("ID");
                txt_empid.setText(add1);
                String add2 = rs.getString("FirstName");
                txt_fname.setText(add2);
                String add3 = rs.getString("LastName");
                txt_lname.setText(add3);
                Date add4 = rs.getDate("DateOfBirth");
                txt_date.setDate(add4);
                //String add5 = rs.getString("Gender");

                String add6 = rs.getString("Email");
                txt_email.setText(add6);
                String add7 = rs.getString("ContactNo");
                txt_contactno.setText(add7);
                String add8 = rs.getString("PresentAddress");
                txt_preadd.setText(add8);
                String add9 = rs.getString("PermanentAddress");
                txt_peradd.setText(add9);
                String add10 = rs.getString("Department");
                txt_dept.setText(add10);
                String add11 = rs.getString("Designation");
                txt_desig.setText(add11);
                //String add12 = rs.getString("Status");

                Date add13 = rs.getDate("DateHired");
                txt_hire.setDate(add13);
                Double add14 = rs.getDouble("BasicSalary");
                txt_salary.setText(Double.toString(add14));
                String add15 = rs.getString("JobTitle");
                txt_title.setText(add15);
                String add16 = rs.getString("UserName");
                txt_username.setText(add16);
                String add17 = rs.getString("Password");
                txt_password.setText(add17);
                byte[] imagedata = rs.getBytes("Image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagedata));
                BufferedImage scaledImg = createScaledImage(image, lbl_image.getWidth(), lbl_image.getHeight());
                lbl_image.setIcon(new ImageIcon(scaledImg));
                image_path.setText(filename);
                //format = new ImageIcon(add18);
                //lbl_image.setIcon(format);

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
    
    }//GEN-LAST:event_tbl_empdetailsMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeDetailsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetailsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetailsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetailsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDetailsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chckbox_active;
    private javax.swing.JCheckBox chckbox_retired;
    private javax.swing.JComboBox<String> cmb_select;
    private javax.swing.JTextField image_path;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JMenu menu_date;
    private javax.swing.JMenu menu_time;
    private javax.swing.JRadioButton rdobtn_female;
    private javax.swing.JRadioButton rdobtn_male;
    private javax.swing.JTable tbl_empdetails;
    private javax.swing.JTextField txt_contactno;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_dept;
    private javax.swing.JTextField txt_desig;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_empid;
    private javax.swing.JTextField txt_fname;
    private com.toedter.calendar.JDateChooser txt_hire;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_peradd;
    private javax.swing.JTextField txt_preadd;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_title;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
Timer timer;
private ImageIcon format = null;
String filename = null;
int s = 0;
byte[] person_image = null;
private String gender;
private String status;
}
