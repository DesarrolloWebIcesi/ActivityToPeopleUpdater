/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author David Andrés Manzano Herrera
 */
public abstract class AbstractProcessor {

    protected static Logger abstracLogger = Logger.getLogger(AbstractProcessor.class);
    protected Professor professor;
    protected Document xmlDocument;
    protected NodeList entities;
    protected String entitie;
    protected final String ORGANIZATION_CODE = "0000";

    public AbstractProcessor(Professor professor, String entitie) {
        this.professor = professor;
        this.xmlDocument = this.professor.getSchemaDocument();
        this.entitie = entitie;
        if (this.xmlDocument != null) {
            this.entities = getEntities();
        }
    }

    protected abstract void runProcesor();
    
    public void run() {
        abstracLogger.info("Starting " + this.entitie + " processor for user " + professor.getUsername());
        int entitiesLength = 0;
        int trynumbers = 1;
        do {
            try {
                entitiesLength = this.entities.getLength();
                
                if (this.entities != null && entitiesLength > 0) {
                    abstracLogger.info(this.entities.getLength() + " " + this.entitie + " entities found for user " + professor.getUsername());
                    runProcesor();
                    trynumbers=5;
                } else {                    
                    abstracLogger.info("There is not " + this.entitie + " Entities for " + this.professor.getUsername() + " in ActivityInsight system");
                    trynumbers=5;
                }
            } catch (NullPointerException ex) {
                abstracLogger.error("Error getting the number of " + this.entitie + " records", ex);
                trynumbers++;
                if(trynumbers<4){
                    abstracLogger.info("Starting " + this.entitie + " processor for user " + professor.getUsername()+" try "+trynumbers);
                }else{
                    abstracLogger.info(this.entitie + " processor for user " + professor.getUsername()+" ignored");
                }
                
            }
        } while (trynumbers < 4);

        abstracLogger.info(this.entitie + " processor for user " + professor.getUsername() + " finished");
    }

    private NodeList getEntities() {
        return this.xmlDocument.getElementsByTagName(this.entitie);
    }
}
