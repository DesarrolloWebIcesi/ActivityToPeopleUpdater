/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.core;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.StdPersonJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdPerson;
import co.edu.icesi.activitytopeopleupdater.processors.*;
import co.edu.icesi.activitytopeopleupdater.util.DateFormats;
import co.edu.icesi.activitytopeopleupdater.webservice.services.ActivityInsightUsersService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author David Andrés Manzano Herrera - damanzano This application porpuse is
 * the PeopleNet proffesors data load from the ActivityInsight system bought by
 * the Econimics and Administratives Sciences Faculty.
 *
 * The data is extracted from ActivityInsight system through the webservices and
 * saved into PeopleNet system tables.
 */
public class ActivityToPeopleUpdater {

    private static Logger logger = Logger.getLogger(ActivityToPeopleUpdater.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NonexistentEntityException {
        // TODO code application logic here
        logger.info("Starting ActitvityToPeopleUpdater");
        List<Thread> threads = new ArrayList<>();
        List<Professor> professors = ActivityInsightUsersService.getProfessors();

        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            //if (professor.getUsername().equalsIgnoreCase("94378897")) {
            try {

                if (i > 0 && threads.get(i - 1) != null) {
                    threads.get(i - 1).join();
                }
                ProfessorThread professorThread = new ProfessorThread(professor);
                threads.add(i, professorThread);
                professorThread.start();
            } catch (InterruptedException ex) {
                logger.error("Join for" + threads.get(i).getName() + " interrupted", ex);
            }

            //}
        }

        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException ex) {
                logger.error("Join for" + threads.get(i).getName() + " interrupted", ex);
            }
        }

        logger.info("ActitvityToPeopleUpdater finished");
    }
}
