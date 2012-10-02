/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;

/**
 *
 * @author 38555240
 */
public class DateFormats {

    private static Logger logger = Logger.getLogger(DateFormats.class);

    public DateFormats() {
    }

    public static String fechaActual() {

        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/YYYY");
        String fecha = sdf.format(date);

        return fecha;

    }
    /*
     * public String dateFormat(String pDate) throws ParseException {
     *
     * DateFormat outputFormat = new SimpleDateFormat("dd/MM/YYYY"); DateFormat
     * inputFormat = new SimpleDateFormat("yyyy-MM-dd");
     *
     *
     * Date date = inputFormat.parse(pDate); String outputText =
     * outputFormat.format(date);
     *
     *
     * return outputText;
     *
     * }
     */

    public static Date DeStringADate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            logger.error("Error parsing date", ex);
            return fechaDate;
        }
    }
    
    /** 
     * Converts a string date in dd/MM/yyyy pattern by example "01/January/2012" to a Date Object.
     * @return  A <code>Date</code> Object representing the date string given as parameter
     *          <code>Null</code> if the dateString param doesn´t fit the pattern.
     * @param dateString The string to parse.
     */
    public static Date fullStringToDate(String dateString){
        Locale.setDefault(Locale.ENGLISH);  
        try  
        {  
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy");  
            Date d = inputFormat.parse(dateString);
            return d;
        }  
        catch (ParseException e)  
        {  
            logger.error("Index: " + e.getErrorOffset(),e);  
        }  
        return null;
    }
}
