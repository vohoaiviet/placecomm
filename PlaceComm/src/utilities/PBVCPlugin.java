/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PBVCPlugin.java
 *
 * Created on 20/07/2010, 7:03:48 PM
 */

package utilities;
import com.hp.hpl.jena.ontology.OntModel;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import java.net.URI;
import java.util.*;
import java.util.logging.*;
import java.io.*;

import java.net.*;



import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.dom4j.*;
import org.dom4j.io.*;


import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.arp.impl.Location;

import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protege.model.*;
import edu.stanford.smi.protege.widget.*;
import edu.stanford.smi.protege.resource.*;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protege.model.KnowledgeBaseFactory;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import javax.swing.table.DefaultTableModel;
import jess.*;


/**
 *
 * @author ATuan
 */
public class PBVCPlugin extends javax.swing.JDialog {

    private Project prj;
    private KnowledgeBase kb;
    private OWLModel owlModel;
    private String sLine;
    private String sPrjBase;
    private String sPrjFile;
    private String sProjectFullPath;

    private String sDataSetFilename;
    private long lNumberOfWillBeGenerated=0;
    private long lNumberOfInstance =0;
    private long lStep=0;
    private long lNumOfLines=0;
    private long lLoadedTime = 0;
    private static Logger theLogger =
	 Logger.getLogger(PBVCPlugin.class.getName());

    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;
    private String sURI="http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#";
    private List queryList=new ArrayList();

    PBVCPluginQueryThread qThread=null;
    boolean bWait=true;
    boolean bGUI=true;

    /** Creates new form PBVCPlugin */
    public PBVCPlugin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ConnectKnowledgeBaseBtn = new javax.swing.JButton();
        SparqlBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SparqlTxtArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JessRuleArea = new javax.swing.JTextArea();
        JessTestBtn = new javax.swing.JButton();
        EvaluateJessRule = new javax.swing.JButton();
        JessStringTF = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        DurationTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ProjectNameTF = new javax.swing.JTextField();
        BriefInfoBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LoggingAreaTA = new javax.swing.JTextArea();
        CountInstancesBtn = new javax.swing.JButton();
        ClassNameTF = new javax.swing.JTextField();
        QueriesCmb = new javax.swing.JComboBox();
        LoadQueriesBtn = new javax.swing.JButton();
        RunThisQueryBtn = new javax.swing.JButton();
        RunAllQueriesBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        SPARQL2JessBtn = new javax.swing.JButton();
        ClearQueriesBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(placecommframework.PlaceCommFrameworkApp.class).getContext().getResourceMap(PBVCPlugin.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setIconImage(null);
        setName("Form"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        ConnectKnowledgeBaseBtn.setText(resourceMap.getString("ConnectKnowledgeBaseBtn.text")); // NOI18N
        ConnectKnowledgeBaseBtn.setName("ConnectKnowledgeBaseBtn"); // NOI18N
        ConnectKnowledgeBaseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectKnowledgeBaseBtnMouseClicked(evt);
            }
        });

        SparqlBtn.setText(resourceMap.getString("SparqlBtn.text")); // NOI18N
        SparqlBtn.setName("SparqlBtn"); // NOI18N
        SparqlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SparqlBtnMouseClicked(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        SparqlTxtArea.setColumns(20);
        SparqlTxtArea.setRows(5);
        SparqlTxtArea.setText(resourceMap.getString("SparqlTxtArea.text")); // NOI18N
        SparqlTxtArea.setName("SparqlTxtArea"); // NOI18N
        jScrollPane1.setViewportView(SparqlTxtArea);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        JessRuleArea.setColumns(20);
        JessRuleArea.setRows(5);
        JessRuleArea.setText(resourceMap.getString("JessRuleArea.text")); // NOI18N
        JessRuleArea.setName("JessRuleArea"); // NOI18N
        jScrollPane3.setViewportView(JessRuleArea);

        JessTestBtn.setText(resourceMap.getString("JessTestBtn.text")); // NOI18N
        JessTestBtn.setName("JessTestBtn"); // NOI18N
        JessTestBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JessTestBtnMouseClicked(evt);
            }
        });

        EvaluateJessRule.setText(resourceMap.getString("EvaluateJessRule.text")); // NOI18N
        EvaluateJessRule.setName("EvaluateJessRule"); // NOI18N
        EvaluateJessRule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvaluateJessRuleMouseClicked(evt);
            }
        });

        JessStringTF.setName("JessStringTF"); // NOI18N

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N

        jTextField4.setText(resourceMap.getString("jTextField4.text")); // NOI18N
        jTextField4.setName("jTextField4"); // NOI18N

        jPasswordField1.setText(resourceMap.getString("jPasswordField1.text")); // NOI18N
        jPasswordField1.setName("jPasswordField1"); // NOI18N

        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        DurationTF.setText(resourceMap.getString("DurationTF.text")); // NOI18N
        DurationTF.setName("DurationTF"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        ProjectNameTF.setText(resourceMap.getString("ProjectNameTF.text")); // NOI18N
        ProjectNameTF.setName("ProjectNameTF"); // NOI18N

        BriefInfoBtn.setText(resourceMap.getString("BriefInfoBtn.text")); // NOI18N
        BriefInfoBtn.setName("BriefInfoBtn"); // NOI18N
        BriefInfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BriefInfoBtnMouseClicked(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        LoggingAreaTA.setColumns(20);
        LoggingAreaTA.setRows(5);
        LoggingAreaTA.setName("LoggingAreaTA"); // NOI18N
        jScrollPane2.setViewportView(LoggingAreaTA);

        CountInstancesBtn.setText(resourceMap.getString("CountInstancesBtn.text")); // NOI18N
        CountInstancesBtn.setName("CountInstancesBtn"); // NOI18N
        CountInstancesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CountInstancesBtnMouseClicked(evt);
            }
        });

        ClassNameTF.setText(resourceMap.getString("ClassNameTF.text")); // NOI18N
        ClassNameTF.setName("ClassNameTF"); // NOI18N

        QueriesCmb.setName("QueriesCmb"); // NOI18N
        QueriesCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                QueriesCmbItemStateChanged(evt);
            }
        });

        LoadQueriesBtn.setText(resourceMap.getString("LoadQueriesBtn.text")); // NOI18N
        LoadQueriesBtn.setName("LoadQueriesBtn"); // NOI18N
        LoadQueriesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadQueriesBtnMouseClicked(evt);
            }
        });

        RunThisQueryBtn.setText(resourceMap.getString("RunThisQueryBtn.text")); // NOI18N
        RunThisQueryBtn.setName("RunThisQueryBtn"); // NOI18N
        RunThisQueryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunThisQueryBtnMouseClicked(evt);
            }
        });

        RunAllQueriesBtn.setText(resourceMap.getString("RunAllQueriesBtn.text")); // NOI18N
        RunAllQueriesBtn.setName("RunAllQueriesBtn"); // NOI18N
        RunAllQueriesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunAllQueriesBtnMouseClicked(evt);
            }
        });

        ExitBtn.setText(resourceMap.getString("ExitBtn.text")); // NOI18N
        ExitBtn.setName("ExitBtn"); // NOI18N
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
        });

        SPARQL2JessBtn.setText(resourceMap.getString("SPARQL2JessBtn.text")); // NOI18N
        SPARQL2JessBtn.setName("SPARQL2JessBtn"); // NOI18N

        ClearQueriesBtn.setText(resourceMap.getString("ClearQueriesBtn.text")); // NOI18N
        ClearQueriesBtn.setName("ClearQueriesBtn"); // NOI18N
        ClearQueriesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearQueriesBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(ExitBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(JessTestBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EvaluateJessRule)
                        .addGap(26, 26, 26)
                        .addComponent(JessStringTF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DurationTF, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProjectNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(ConnectKnowledgeBaseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BriefInfoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CountInstancesBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(SPARQL2JessBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SparqlBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClearQueriesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LoadQueriesBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QueriesCmb, 0, 185, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RunThisQueryBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RunAllQueriesBtn))
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ProjectNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConnectKnowledgeBaseBtn)
                    .addComponent(BriefInfoBtn)
                    .addComponent(CountInstancesBtn)
                    .addComponent(ClassNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QueriesCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadQueriesBtn)
                    .addComponent(RunThisQueryBtn)
                    .addComponent(RunAllQueriesBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SparqlBtn)
                    .addComponent(jCheckBox1)
                    .addComponent(SPARQL2JessBtn)
                    .addComponent(ClearQueriesBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JessTestBtn)
                    .addComponent(EvaluateJessRule)
                    .addComponent(JessStringTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DurationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(ExitBtn)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectKnowledgeBaseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectKnowledgeBaseBtnMouseClicked

    String sPrjFile =  ProjectNameTF.getText().trim();
     String sLocationURI=sURI+"Location";

        Collection errors = new ArrayList();
        Date d1=new Date();
        long l1=d1.getTime();
        prj = Project.loadProjectFromFile(sPrjFile,errors);
        owlModel =(OWLModel)prj.getKnowledgeBase();

        kb  = prj.getKnowledgeBase();
        URI uri = prj.getActiveRootURI();

        Collection colNumberOfInstance=kb.getInstances();
        lNumberOfInstance =colNumberOfInstance.size();
        
        Date d2=new Date();
        long l2=d2.getTime();
        lLoadedTime = (l2-l1);

        theLogger.info("Connected to MySQL in "+lLoadedTime +" ms");
        theLogger.info("KB has "+lNumberOfInstance+" instances");
         
        LoggingAreaTA.append("Project has "+lNumberOfInstance+" in total\n");
        LoggingAreaTA.append("Project is loaded in "+lLoadedTime+" ms\n");


    }//GEN-LAST:event_ConnectKnowledgeBaseBtnMouseClicked

    private void SparqlBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SparqlBtnMouseClicked


}//GEN-LAST:event_SparqlBtnMouseClicked

    private void JessTestBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JessTestBtnMouseClicked
       
    }//GEN-LAST:event_JessTestBtnMouseClicked

    private void BriefInfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BriefInfoBtnMouseClicked
        // TODO add your handling code here:
        Collection colNumberOfInstance=kb.getInstances();
        long lNumberOfInstance =colNumberOfInstance.size();
        LoggingAreaTA.append("Project has "+lNumberOfInstance+" in total");
        LoggingAreaTA.append("Project is loaded in "+lLoadedTime+" ms");


    }//GEN-LAST:event_BriefInfoBtnMouseClicked

    private void CountInstancesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountInstancesBtnMouseClicked
        // TODO add your handling code here:
        LoggingAreaTA.append("Total: "+ Long.toString(InstancesCount()) + " instances");
    }//GEN-LAST:event_CountInstancesBtnMouseClicked

    private void LoadQueriesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadQueriesBtnMouseClicked
        // Algorithm
        /*
         * Goto queries' directory and load all queryfile.query to Combobox
         * Change local directory to repository diretory
         * List all file there
         * Try to load all file and add to combobox
         *
         *
         */
        String sQueryRepositoryPath="/home/natuan/Documents/OntologyMysql/QueriesRepository/";
        File dir = new File(sQueryRepositoryPath);
        String[] children = dir.list();
        if (children == null) {
            // Either dir does not exist or is not a directory
        } else {
            System.out.println("list files");
            for (int i=0; i<children.length; i++) {
                // Get filename of file or directory
                String filename = children[i];
                String sContent = ReadWholeFileToString(sQueryRepositoryPath+filename) ;
                queryList.add(sContent);
                QueriesCmb.addItem(filename);                
                SparqlTxtArea.setText(sContent);
             //   System.out.println(filename);
            }
            QueriesCmb.setSelectedIndex(children.length-1);
        }
    }//GEN-LAST:event_LoadQueriesBtnMouseClicked

    private void RunThisQueryBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RunThisQueryBtnMouseClicked
        // TODO add your handling code here:
        qThread = new PBVCPluginQueryThread(this,QueriesCmb.getSelectedItem().toString(),
                SparqlTxtArea.getText(),owlModel);
        Thread qthr = new Thread (qThread);
        qthr.start();

        RunThisQueryBtn.setEnabled(false);


    }//GEN-LAST:event_RunThisQueryBtnMouseClicked

    public void loggingMessagesUpdate(String str){
        if (bGUI) {
        LoggingAreaTA.append(str+"\n");
        }else {
            System.out.println (str);
        }
    }
    
    private void RunAllQueriesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RunAllQueriesBtnMouseClicked
        // TODO add your handling code here:

            qThread = new PBVCPluginQueryThread(this, "", queryList,owlModel);
            Thread qthr = new Thread (qThread);
            qthr.start();


        
    }//GEN-LAST:event_RunAllQueriesBtnMouseClicked

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void QueriesCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_QueriesCmbItemStateChanged
        // TODO add your handling code here:
        int iQueryNumber = QueriesCmb.getSelectedIndex();
        SparqlTxtArea.setText(queryList.get(iQueryNumber).toString());

    }//GEN-LAST:event_QueriesCmbItemStateChanged

    private void EvaluateJessRuleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluateJessRuleMouseClicked

        // Evaluate the jess rule.
        // Engine is created, now passing rules to the engine:
        String sRule = JessRuleArea.getText();
        String sResult = qThread.EvaluateJessRule(sRule);
        LoggingAreaTA.append(sResult+"\n");


    }//GEN-LAST:event_EvaluateJessRuleMouseClicked

    private void ClearQueriesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearQueriesBtnMouseClicked
        // TODO add your handling code here:

        
    }//GEN-LAST:event_ClearQueriesBtnMouseClicked

     private long InstancesCount(){

        String sIname=ClassNameTF.getText().trim();
        long lNumberOfInstance = 0;
        if (sIname.length()>0){
            String sClassName=ClassNameTF.getText();
            try{
                Cls cls=kb.getCls(sClassName);
                Collection colInstances=kb.getInstances(cls);
                lNumberOfInstance =  colInstances.size();
            }catch(Exception e){
                theLogger.severe("Class not found");
            }

        }else {
            try{
                Collection colInstances=kb.getInstances();
                lNumberOfInstance =colInstances.size();
            }catch(Exception e){
                theLogger.severe("Class not found");
            }

        }
        return lNumberOfInstance;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        boolean bGUIpara=true;

        // Parse parameter:
        int iSize = args.length;
        // PBVCPlugin -gui=false -K=/somewhere/c1.pprj -Q=/somewhere/QueriesRepositories
        //
        for (int i=0; i<iSize ;i++){

        }

        
        if (bGUIpara){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PBVCPlugin dialog = new PBVCPlugin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        }else {
            // Using command line
            /*
             */
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BriefInfoBtn;
    private javax.swing.JTextField ClassNameTF;
    private javax.swing.JButton ClearQueriesBtn;
    private javax.swing.JButton ConnectKnowledgeBaseBtn;
    private javax.swing.JButton CountInstancesBtn;
    private javax.swing.JTextField DurationTF;
    private javax.swing.JButton EvaluateJessRule;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JTextArea JessRuleArea;
    private javax.swing.JTextField JessStringTF;
    private javax.swing.JButton JessTestBtn;
    private javax.swing.JButton LoadQueriesBtn;
    private javax.swing.JTextArea LoggingAreaTA;
    private javax.swing.JTextField ProjectNameTF;
    private javax.swing.JComboBox QueriesCmb;
    private javax.swing.JButton RunAllQueriesBtn;
    private javax.swing.JButton RunThisQueryBtn;
    private javax.swing.JButton SPARQL2JessBtn;
    private javax.swing.JButton SparqlBtn;
    private javax.swing.JTextArea SparqlTxtArea;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private String ReadWholeFileToString(String filename) {

        File file = new File(filename);
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null)
            {
                contents.append(text)
                    .append(System.getProperty(
                        "line.separator"));
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        // show file contents here
        return contents.toString();
    }

    public void updateSPARQLResult(QueryResults results) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void enableRunThisSPARQLButton() {
        RunThisQueryBtn.setEnabled(true);
    }

}
