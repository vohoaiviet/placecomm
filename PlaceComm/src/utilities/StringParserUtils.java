/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package utilities;

import java.util.*;

/**
 *
 * @author Tuan Nguyen
 */
public class StringParserUtils {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {

        //I have this string
        String UIComponentList="Form@mainForm#FunnyService;TextField@username#UserName;From@mainForm2#FunnyService2;TextField@username2#UserName2;Form@mainForm#FunnyService;TextField@username#UserName;Form@mainForm2#FunnyService2;TextField2@username2#UserName2;";
        // Because the string utilities not widely supported in J2ME
        boolean stop = false;
        int iLen=UIComponentList.length();
        String sTemp=UIComponentList;
        int iCountLoop=0;
        do {
        int iType           = sTemp.indexOf("@");
        int iComponentName  = sTemp.indexOf("#");
        int iComponentLabel = sTemp.indexOf(";");

        String sType = sTemp.substring(0,iType);
        System.out.print("Type:"+ sType +"; ");

        String sTypeName = sTemp.substring(iType+1,iComponentName);
        System.out.print("   Type name:"+ sTypeName +"; ");

        String sComponentLabel  = sTemp.substring(iComponentName+1,iComponentLabel);
        System.out.print("   Component Label:"+ sComponentLabel +"; " );

        System.out.println("\n");
        
        sTemp=sTemp.substring(iComponentLabel+1,sTemp.length());
        iCountLoop++;

        if (sTemp.length()<3) stop = true;
        else System.out.println("sTemp "+iCountLoop+" = "+sTemp);
        } while (! stop );


    
    }
}
