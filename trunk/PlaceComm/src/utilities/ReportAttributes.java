/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author ATuan
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;


import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

class ReportAttributes extends HTMLEditorKit.ParserCallback {

  public CarWatchUtilities toParent;
  public boolean bOneCar=false;
  ReportAttributes(CarWatchUtilities parent,boolean bOneCar){
      this.toParent=parent;
      this.bOneCar=bOneCar;
  }
  public void addVehicleID(String sVehicleID){
      toParent.addCarToCarlist(sVehicleID);
  }
  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
    this.listAttributes(attributes);
    System.out.println("HTML tag="+tag.toString());
  }

  private void listAttributes(AttributeSet attributes) {
    Enumeration e = attributes.getAttributeNames();
    while (e.hasMoreElements()) {
      Object name = e.nextElement();
      Object value = attributes.getAttribute(name);
      String sVehicleID="vehicle.aspx?Number=";

      if (!attributes.containsAttribute(name.toString(), value)) {
        //System.out.println("containsAttribute() fails");
      }
      if (!attributes.isDefined(name.toString())) {
        //System.out.println("isDefined() fails");
      }
      System.out.println(name + "=" + value);
      if (!bOneCar){
      if ((name.toString().contains("href"))&&(value.toString().contains("vehicle.aspx"))){
      addVehicleID(name + "=" + value);
      }
      }else {
      System.out.println(name + ":" + value);
      toParent.SetCarDetails(name+":"+value);
      }
      
    }
  }

  public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
    this.listAttributes(attributes);
  }


}

class ParserGetter extends HTMLEditorKit {
  public HTMLEditorKit.Parser getParser() {
    return super.getParser();
  }
}