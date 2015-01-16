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
 * Parsing dates utils
 *
 * @author Blanca Gomez - bogomez
 */
public class DateFormats {

    private static Logger logger = Logger.getLogger(DateFormats.class);

    public DateFormats() {
    }

    /** 
     * Returns the actual date in dd/MM/YYYY format
     * 
     * @return A string representing the actual date in dd/MM/YYYY format
     */
    public static String fechaActual() {

        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/YYYY");
        String fecha = sdf.format(date);

        return fecha;

    }
    
    /** 
     * Create a Date object from an input string in dd/MM/YYYY format
     * 
     * @param fecha An input string in dd/MM/YYYY format
     * @return Date object representing the date passed in param
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
     * Converts a string date in dd/MMM/yyyy pattern by example "01/January/2012" to a Date Object.
     * Converts a string date in dd/MM/yyyy pattern by example "01/01/2012" to a Date Object.
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
            logger.error("Error parsing date "+dateString +" with format dd/MMM/yyyy, it will try with format: dd/MM/yyyy");
            SimpleDateFormat formatoAlterno = new SimpleDateFormat("dd/MM/yyyy");
            String strFecha = dateString;
            Date fechaDate;
            try{
            fechaDate = formatoAlterno.parse(strFecha);
            return fechaDate;
            }catch(ParseException ex){
                logger.error("Error parsing date in second try " + ex.getErrorOffset(), ex);
            }
        }  
        return null;
    }
}
