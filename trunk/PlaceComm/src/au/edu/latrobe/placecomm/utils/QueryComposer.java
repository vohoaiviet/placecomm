/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

/*
 * QueryComposer.java
 *
 * Created on 10/12/2009, 12:08:27 PM
 */

package au.edu.latrobe.placecomm.utils;

import au.edu.latrobe.placecomm.utils.*;

/**
 *
 * @author Tuan Nguyen
 */
public class QueryComposer extends javax.swing.JDialog {

    /** Creates new form QueryComposer */
    public QueryComposer(java.awt.Frame parent, boolean modal) {
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
        taQueryPreview = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbPredefinedQueries = new javax.swing.JComboBox();
        tfQueryParameter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfMyselfID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfTimestamp1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfTimestamp2 = new javax.swing.JTextField();
        btGetTime = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        taQueryPreview.setColumns(20);
        taQueryPreview.setRows(5);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(QueryComposer.class);
        taQueryPreview.setText(resourceMap.getString("taQueryPreview.text")); // NOI18N
        taQueryPreview.setName("taQueryPreview"); // NOI18N
        jScrollPane1.setViewportView(taQueryPreview);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        cbPredefinedQueries.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Where are my friends?", "Where are my devices? ", "Who is/are this person friend(s)?", "Who owns this device?", "Where has this person been? ", "What have you been upto? ", "What is on TV tonight? ", "Which devices belong to?" }));
        cbPredefinedQueries.setName("cbPredefinedQueries"); // NOI18N

        tfQueryParameter.setText(resourceMap.getString("tfQueryParameter.text")); // NOI18N
        tfQueryParameter.setName("tfQueryParameter"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        tfMyselfID.setText(resourceMap.getString("tfMyselfID.text")); // NOI18N
        tfMyselfID.setName("tfMyselfID"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        tfTimestamp1.setText(resourceMap.getString("tfTimestamp1.text")); // NOI18N
        tfTimestamp1.setName("tfTimestamp1"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        tfTimestamp2.setText(resourceMap.getString("tfTimestamp2.text")); // NOI18N
        tfTimestamp2.setName("tfTimestamp2"); // NOI18N

        btGetTime.setLabel(resourceMap.getString("btGetTime.label")); // NOI18N
        btGetTime.setName("btGetTime"); // NOI18N
        btGetTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btGetTimeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMyselfID, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPredefinedQueries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfQueryParameter, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTimestamp1)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTimestamp2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel5)
                    .addComponent(tfMyselfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPredefinedQueries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQueryParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTimestamp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btGetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTimestamp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String ComposeQuery(int iQuery,String parameter, String timestamp1, String timestamp2){
        

        String sQuery="";

        switch (iQuery){
            case 0:
                sQuery="Where are my friends";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 1:
                sQuery="Where are my devices";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 2: String query3= "Who is this person friend";
                sQuery="PREFIX plc:<http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/place.owl#> \n" +
                        "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> \n" +
                        "PREFIX swrl:<http://www.w3.org/2003/11/swrl#> \n" +
                        "PREFIX protege:<http://protege.stanford.edu/plugins/owl/protege#> \n" +
                        "PREFIX foaf:<http://xmlns.com/foaf/0.1/> \n" +
                        "PREFIX dev:<http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/device.owl#> \n" +
                        "PREFIX xsp:<http://www.owl-ontologies.com/2005/08/07/xsp.owl#> \n" +
                        "PREFIX swrlb:<http://www.w3.org/2003/11/swrlb#> \n" +
                        "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> \n" +
                        "PREFIX owl:<http://www.w3.org/2002/07/owl#> \n " +
                        "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
                        "select   ?whoIs"+parameter+"Friends where { \n" +
                        "  ?whoIs"+parameter+"Friends rdf:type  foaf:Person. \n" +
                        "  ?whoIs"+parameter+"Friends foaf:friendOf ?name. \n" +
                        "  ?name foaf:name ?nnn. \n" +
                        "  FILTER (?nnn = \""+parameter+"\"^^xsd:string)}";
                 System.out.println("iQuery: "+iQuery);
                 System.out.println("sQuery: "+sQuery);
                 break;
            case 3:
                sQuery="Who owns this device";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 4:
                sQuery="Where has this person been";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 5:
                sQuery="What have you been upto";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 6:
                sQuery="What is on TV tonight";
                System.out.println("iQuery: "+iQuery);
                System.out.println("sQuery: "+sQuery);
                break;
            case 7:
                sQuery="PREFIX plc:<http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/place.owl#> \n" +
                        "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> \n" +
                        "PREFIX swrl:<http://www.w3.org/2003/11/swrl#> \n" +
                        "PREFIX protege:<http://protege.stanford.edu/plugins/owl/protege#> \n" +
                        "PREFIX foaf:<http://xmlns.com/foaf/0.1/> \n" +
                        "PREFIX dev:<http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/device.owl#> \n" +
                        "PREFIX xsp:<http://www.owl-ontologies.com/2005/08/07/xsp.owl#> \n" +
                        "PREFIX swrlb:<http://www.w3.org/2003/11/swrlb#> \n" +
                        "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> \n" +
                        "PREFIX owl:<http://www.w3.org/2002/07/owl#> \n" +
                        "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
                        "PREFIX pbvc:<http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/pbvc.owl#> \n" +
                        "select ?device  where { \n" +
                        "  ?device pbvc:devHasOwner ?owner. \n" +
                        "  ?owner foaf:name ?nnn . \n" +
                        "  FILTER (?nnn = \""+parameter+"\"^^xsd:string) }";
                 System.out.println("iQuery: "+iQuery);
                 System.out.println("sQuery: "+sQuery);
                 break;
            default: sQuery="";
            System.out.println("iQuery: "+iQuery);
            System.out.println("sQuery: "+sQuery);
        }
        return sQuery;

    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int iQuery = cbPredefinedQueries.getSelectedIndex();
        String sQuery=ComposeQuery(iQuery,tfQueryParameter.getText(), "", "");
        taQueryPreview.setText(sQuery);
        System.out.println("iQuery: "+iQuery);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btGetTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGetTimeMouseClicked
        // TODO add your handling code here:
        DateTimeConversion timetool=new DateTimeConversion();
        tfTimestamp1.setText(timetool.getCurrentDateTime());
        tfTimestamp2.setText(timetool.getCurrentDateTime());
        

    }//GEN-LAST:event_btGetTimeMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QueryComposer dialog = new QueryComposer(new javax.swing.JFrame(), true);
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
    private java.awt.Button btGetTime;
    private javax.swing.JComboBox cbPredefinedQueries;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taQueryPreview;
    private javax.swing.JTextField tfMyselfID;
    private javax.swing.JTextField tfQueryParameter;
    private javax.swing.JTextField tfTimestamp1;
    private javax.swing.JTextField tfTimestamp2;
    // End of variables declaration//GEN-END:variables

}
