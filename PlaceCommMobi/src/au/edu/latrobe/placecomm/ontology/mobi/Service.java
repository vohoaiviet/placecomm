package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Service
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Service implements Concept, Introspectable {

   /**
* Protege name: serviceName
   */
   private List serviceName = new ArrayList();
   public void addServiceName(String elem) { 
     List oldList = this.serviceName;
     serviceName.add(elem);
   }
   public boolean removeServiceName(String elem) {
     List oldList = this.serviceName;
     boolean result = serviceName.remove(elem);
     return result;
   }
   public void clearAllServiceName() {
     List oldList = this.serviceName;
     serviceName.clear();
   }
   public Iterator getAllServiceName() {return serviceName.iterator(); }
   public List getServiceName() {return serviceName; }
   public void setServiceName(List l) {serviceName = l; }

   /**
* Protege name: serviceDescription
   */
   private List serviceDescription = new ArrayList();
   public void addServiceDescription(String elem) { 
     List oldList = this.serviceDescription;
     serviceDescription.add(elem);
   }
   public boolean removeServiceDescription(String elem) {
     List oldList = this.serviceDescription;
     boolean result = serviceDescription.remove(elem);
     return result;
   }
   public void clearAllServiceDescription() {
     List oldList = this.serviceDescription;
     serviceDescription.clear();
   }
   public Iterator getAllServiceDescription() {return serviceDescription.iterator(); }
   public List getServiceDescription() {return serviceDescription; }
   public void setServiceDescription(List l) {serviceDescription = l; }

   /**
* Protege name: serviceManagedBy
   */
   private List serviceManagedBy = new ArrayList();
   public void addServiceManagedBy(Agent elem) { 
     List oldList = this.serviceManagedBy;
     serviceManagedBy.add(elem);
   }
   public boolean removeServiceManagedBy(Agent elem) {
     List oldList = this.serviceManagedBy;
     boolean result = serviceManagedBy.remove(elem);
     return result;
   }
   public void clearAllServiceManagedBy() {
     List oldList = this.serviceManagedBy;
     serviceManagedBy.clear();
   }
   public Iterator getAllServiceManagedBy() {return serviceManagedBy.iterator(); }
   public List getServiceManagedBy() {return serviceManagedBy; }
   public void setServiceManagedBy(List l) {serviceManagedBy = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.SERVICE_SERVICENAME, (AbsTerm) onto.fromObject(getServiceName()));
      abs.set(PlacecommOntology.SERVICE_SERVICEDESCRIPTION, (AbsTerm) onto.fromObject(getServiceDescription()));
      abs.set(PlacecommOntology.SERVICE_SERVICEMANAGEDBY, (AbsTerm) onto.fromObject(getServiceManagedBy()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Service");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      serviceName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.SERVICE_SERVICENAME));
      serviceDescription = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.SERVICE_SERVICEDESCRIPTION));
      serviceManagedBy = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.SERVICE_SERVICEMANAGEDBY));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Service");
     }
   }

}
