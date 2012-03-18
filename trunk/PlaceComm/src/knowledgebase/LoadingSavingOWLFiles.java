/*
 * LoadingSavingOWLFiles.java
 *
 * Created on 24 July 2008, 12:05
 */

package knowledgebase;

import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  tuannguyen
 */
public class LoadingSavingOWLFiles extends javax.swing.JFrame {

    /** Creates new form LoadingSavingOWLFiles */
    public LoadingSavingOWLFiles() {
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

        LoadBtn = new java.awt.Button();
        ExitBtn = new java.awt.Button();
        DisplayTxt = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoadBtn.setLabel("Load");
        LoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadBtnActionPerformed(evt);
            }
        });

        ExitBtn.setLabel("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DisplayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DisplayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void LoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadBtnActionPerformed
    // TODO add your handling code here:
    String uri = "http://www.tuannguyen.mobi/ontologies/pbvc/placeNew.owl";
    String fileName = "c:\\temp\\NewPlaceNew.owl";
    Collection errors = new ArrayList();
    
    OWLNamedClass destinationClass=null;
    DisplayTxt.setText("Loading OWL file...");
    System.out.println("Loading OWL file...");
        try {
        //JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);            
        
        DisplayTxt.setText("createJenaOWLModelFromURI("+uri+") OK! ");
        System.out.println("createJenaOWLModelFromURI("+uri+") OK! ");
        } catch (Exception ex) {
            Logger.getLogger(LoadingSavingOWLFiles.class.getName()).log(Level.SEVERE, null, ex);
            DisplayTxt.setText("createJenaOWLModelFromURI("+uri+") Failed! ");
            System.out.println("createJenaOWLModelFromURI("+uri+") Failed! ");
        }
        /*
        try{
        destinationClass = owlModel.getOWLNamedClass("place");    
        DisplayTxt.setText("getOWLNamedClass(place) OK! ");
        System.out.println("getOWLNamedClass(place) OK! ");
        } catch (Exception ex) {
            Logger.getLogger(LoadingSavingOWLFiles.class.getName()).log(Level.SEVERE, null, ex);
            DisplayTxt.setText("getOWLNamedClass(place) Failed !");
            System.out.println("getOWLNamedClass(place) Failed !");
            
        }        
    
        owlModel.save(new File(fileName).toURI(), FileUtils.langXMLAbbrev, errors);
        */
    DisplayTxt.setText("File saved with " + errors.size() + " errors.");
    //System.out.println("File saved with " + errors.size() + " errors.");
    

}//GEN-LAST:event_LoadBtnActionPerformed

private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
// TODO add your handling code here:
    System.exit(0);
}//GEN-LAST:event_ExitBtnActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadingSavingOWLFiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea DisplayTxt;
    private java.awt.Button ExitBtn;
    private java.awt.Button LoadBtn;
    // End of variables declaration//GEN-END:variables

}