/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

/*
 * ContextRulesLearning.java
 *
 * Created on 27/12/2009, 8:25:36 PM
 */

package pbvcrules;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import jess.*;
/**
 *
 * @author Tuan Nguyen
 */
public class ContextRulesLearning extends javax.swing.JDialog {

    /** Creates new form ContextRulesLearning */
    public ContextRulesLearning(java.awt.Frame parent, boolean modal) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSpeedList = new javax.swing.JList();
        btnGetData = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taFacts = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taParseRule = new javax.swing.JTextArea();
        btnParseRule = new javax.swing.JButton();
        btnExecuteRule = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        taResult = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        tfSpeed = new javax.swing.JTextField();
        btnAddFacts = new javax.swing.JButton();
        btnAverageSpeed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        lstSpeedList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "95.36", "98.78", "80.00", "90.00", "85.56", "72.36", "76.90", "99.99", "85.90", "101.23" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstSpeedList.setName("lstSpeedList"); // NOI18N
        jScrollPane1.setViewportView(lstSpeedList);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(placecommframework.PlaceCommFrameworkApp.class).getContext().getResourceMap(ContextRulesLearning.class);
        btnGetData.setText(resourceMap.getString("btnGetData.text")); // NOI18N
        btnGetData.setName("btnGetData"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        taFacts.setColumns(20);
        taFacts.setRows(5);
        taFacts.setName("taFacts"); // NOI18N
        jScrollPane2.setViewportView(taFacts);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        taParseRule.setColumns(20);
        taParseRule.setRows(5);
        taParseRule.setName("taParseRule"); // NOI18N
        jScrollPane3.setViewportView(taParseRule);

        btnParseRule.setText(resourceMap.getString("btnParseRule.text")); // NOI18N
        btnParseRule.setName("btnParseRule"); // NOI18N
        btnParseRule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParseRuleMouseClicked(evt);
            }
        });

        btnExecuteRule.setText(resourceMap.getString("btnExecuteRule.text")); // NOI18N
        btnExecuteRule.setName("btnExecuteRule"); // NOI18N
        btnExecuteRule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExecuteRuleMouseClicked(evt);
            }
        });

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        taResult.setColumns(20);
        taResult.setRows(5);
        taResult.setName("taResult"); // NOI18N
        jScrollPane4.setViewportView(taResult);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        btnClear.setText(resourceMap.getString("btnClear.text")); // NOI18N
        btnClear.setName("btnClear"); // NOI18N

        tfSpeed.setText(resourceMap.getString("tfSpeed.text")); // NOI18N
        tfSpeed.setName("tfSpeed"); // NOI18N

        btnAddFacts.setText(resourceMap.getString("btnAddFacts.text")); // NOI18N
        btnAddFacts.setName("btnAddFacts"); // NOI18N
        btnAddFacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddFactsMouseClicked(evt);
            }
        });

        btnAverageSpeed.setText(resourceMap.getString("btnAverageSpeed.text")); // NOI18N
        btnAverageSpeed.setName("btnAverageSpeed"); // NOI18N
        btnAverageSpeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAverageSpeedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnParseRule)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExecuteRule)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnClear))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGetData)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAverageSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddFacts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetData)
                    .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddFacts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAverageSpeed))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnParseRule)
                            .addComponent(btnExecuteRule)
                            .addComponent(btnClear))))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecuteRuleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExecuteRuleMouseClicked
        // TODO add your handling code here:
        String sRule=taParseRule.getText();
        Rete engine = new Rete();
        try {
            engine.eval(sRule);
            engine.eval("(run)");
            Value sumValue = engine.fetch("SUM");
            int sum = sumValue.intValue(engine.getGlobalContext());
            taResult.setText("Result is: " + sum);

        } catch (JessException ex) {
            Logger.getLogger(ContextRulesLearning.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        String sRule=taParseRule.getText();
        Rete engine = new Rete();
        int iSize=lstSpeedList.getComponentCount();
        String sFact="";
        String temp="(assert (numbers 3 4))\n";
        taParseRule.append(temp);
        String sAddRule="(defrule add-numbers " +
                           "(numbers ?n1 ?n2)\n" +
                           "=>\n" +
                           "(store SUM (+ ?n1 ?n2)))\n";
        taParseRule.append(sAddRule);
        try {
            engine.eval(temp);
            engine.eval(sAddRule);
            engine.eval("(run)");
            Value sumValue = engine.fetch("SUM");
            int sum = sumValue.intValue(engine.getGlobalContext());
            taResult.setText("Result is: " + sum);
            
        } catch (JessException ex) {
            Logger.getLogger(ContextRulesLearning.class.getName()).log(Level.SEVERE, null, ex);
        }
        */

        //for (int i=0; i<iSize; i++){
          //taFacts.insert(sFact, 0);
          //temp="()";          temp="";
        //}

    }//GEN-LAST:event_btnExecuteRuleMouseClicked

    private void btnAddFactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFactsMouseClicked
        // TODO add your handling code here:
        

        ListModel lModel =lstSpeedList.getModel();
        int iLength= lModel.getSize();
        System.out.println("List size= "+iLength);
        for (int i=0; i< iLength; i++) {
            System.out.println(lModel.getElementAt(i).toString());

            //System.out.println(lstSpeedList.getComponent(i).toString());
        }
    }//GEN-LAST:event_btnAddFactsMouseClicked

    private void btnAverageSpeedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAverageSpeedMouseClicked
        // TODO add your handling code here:
        ListModel lModel =lstSpeedList.getModel();
        int iLength= lModel.getSize();
        System.out.println("List size= "+iLength);
        double dAverage=0;
        for (int i=0; i< iLength; i++) {
            String sTemp=lModel.getElementAt(i).toString();
            //System.out.println("Line ["+i+"]:"+ sTemp);
            sTemp.trim();
            if (! sTemp.isEmpty()){
            double dValue=Double.valueOf(sTemp);
            try {
               dAverage += dValue;
            }catch(Exception e){
                System.out.println("Parse string error");
            }
            }            
        }
        System.out.println("Total "+dAverage);
        double dAvg=dAverage/iLength;
        taResult.setText(Double.toString(dAvg));
    }//GEN-LAST:event_btnAverageSpeedMouseClicked

    private void btnParseRuleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParseRuleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnParseRuleMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContextRulesLearning dialog = new ContextRulesLearning(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFacts;
    private javax.swing.JButton btnAverageSpeed;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExecuteRule;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnParseRule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList lstSpeedList;
    private javax.swing.JTextArea taFacts;
    private javax.swing.JTextArea taParseRule;
    private javax.swing.JTextArea taResult;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

}