/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package knowledgebase;

import edu.stanford.smi.protege.util.Disposable;
import edu.stanford.smi.protegex.owl.*;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.event.*;
import edu.stanford.smi.protegex.owl.ui.*;
import edu.stanford.smi.protegex.owl.ui.icons.*;
import edu.stanford.smi.protegex.owl.ui.widget.OWLUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.*;

/**
 *
 * @author Tuan Nguyen
 */
public class ListPanel extends JPanel implements Disposable {
        private OWLNamedClass destinationClass;
        private JList list;
        private DefaultListModel listModel;

        private ModelListener modelListener = new ModelAdapter() {
            public void individualCreated(RDFResource resource) {
                if (resource.hasRDFType(destinationClass, true)) {
                    handleDestinationAdded(resource);
                }
            }
        };

        private OWLModel owlModel;

        ListPanel(OWLNamedClass activityClass) {
            this.destinationClass = activityClass;
            this.owlModel = activityClass.getOWLModel();

            owlModel.addModelListener(modelListener);

            listModel = new DefaultListModel();
            for (Iterator it = activityClass.getInstances(true).iterator(); it.hasNext();) {
                OWLIndividual individual = (OWLIndividual) it.next();
                listModel.addElement(individual);
            }
            list = new JList(listModel);

            // Make sure list entries show up nicely with icons
            list.setCellRenderer(new ResourceRenderer());

            // Wrap the list together with a button bar
            OWLLabeledComponent lc = new OWLLabeledComponent("Destinations", new JScrollPane(list));
            lc.addHeaderButton(new AbstractAction("Add Destination...",
                    OWLIcons.getAddIcon(OWLIcons.RDF_INDIVIDUAL)) {
                public void actionPerformed(ActionEvent e) {
                    addDestination();
                }

            
            });

            // Add everything into the JPanel
            setLayout(new BorderLayout());
            add(BorderLayout.CENTER, lc);
        }

        private void addDestination() {
            OWLNamedClass newType = OWLUI.pickOWLNamedClass(owlModel,
                    Collections.singleton(destinationClass), "Select type of new Destination");
            if (newType != null) {
                String name = JOptionPane.showInputDialog(
                        "Enter name of new " + newType.getBrowserText());
                if (name != null) {
                    newType.createOWLIndividual(name);
                }
            }
        }

        public void dispose() {
            owlModel.removeModelListener(modelListener);
        }

        private void handleDestinationAdded(RDFResource destination) {
            listModel.addElement(destination);
            list.setSelectedValue(destination, true);
        }
    }