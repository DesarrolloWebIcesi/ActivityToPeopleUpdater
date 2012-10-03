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

    /** 
     * AbstractProcessor Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public AbstractProcessor(Professor professor, String entitie) {
        this.professor = professor;
        this.xmlDocument = this.professor.getSchemaDocument();
        this.entitie = entitie;
        if (this.xmlDocument != null) {
            this.entities = getEntities();
        }
    }
    
    /** Actually do the task of the processor */
    protected abstract void runProcesor();

    /** Validates atributes and call runProcesor() method*/
    public void run() {
        abstracLogger.info("Starting " + this.entitie + " processor for user " + professor.getUsername());
        int entitiesLength = 0;
        int trynumbers = 1;
        do {
            boolean error = false;
            try {
                entitiesLength = this.entities.getLength();
            } catch (NullPointerException ex) {
                error=true;
                abstracLogger.error("Error getting the number of " + this.entitie + " records", ex);
                trynumbers++;
                if (trynumbers < 4) {
                    abstracLogger.info("Starting " + this.entitie + " processor for user " + professor.getUsername() + " try " + trynumbers);
                } else {
                    abstracLogger.info(this.entitie + " processor for user " + professor.getUsername() + " ignored");
                }

            }
            if (!error) {
                if (this.entities != null && entitiesLength > 0) {
                    abstracLogger.info(this.entities.getLength() + " " + this.entitie + " entities found for user " + professor.getUsername());
                    runProcesor();
                    trynumbers = 5;
                } else {
                    abstracLogger.info("There is not " + this.entitie + " Entities for " + this.professor.getUsername() + " in ActivityInsight system");
                    trynumbers = 5;
                }
            }

        } while (trynumbers < 4);

        abstracLogger.info(this.entitie + " processor for user " + professor.getUsername() + " finished");
    }

    /** Get the list of node that match the processor's entity class */
    private NodeList getEntities() {
        return this.xmlDocument.getElementsByTagName(this.entitie);
    }
}
