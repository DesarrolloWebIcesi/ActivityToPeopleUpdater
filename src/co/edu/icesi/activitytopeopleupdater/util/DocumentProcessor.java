/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utilities for XML document processing.
 * 
 * @author David Andrés Manzano Herrera
 */
public class DocumentProcessor {
    /** 
     * Get the text value of a tag in a Element node
     * 
     * @param sTag The searched tag
     * @param eElement The element in which search
     * 
     * @return  The node value of the searched tag,
     *          <code>null</code> if the searched tag does not exist or has en empty value.
     */
    public static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag);
        if(nlList!=null && nlList.getLength() > 0)
        {
            nlList = nlList.item(0).getChildNodes();
            //this condition must be checked because of empty and selfclosed tags by example <tag></tag> and <tag/>
            if(nlList!=null && nlList.getLength() > 0){
                Node nValue = (Node) nlList.item(0);
                if(nValue!=null){
                    return nValue.getNodeValue();
                }
            }
        }
        return null;               
  }
}
