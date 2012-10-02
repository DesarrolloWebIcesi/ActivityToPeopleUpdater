/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.core;

import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.processors.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Execute the bundles of Processors for a professor
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class ProfessorThread extends Thread {

    private Professor professor;
    private List<AbstractProcessor> processors;
    private static final Logger logger = Logger.getLogger(ProfessorThread.class);

    public ProfessorThread(Professor professor) {
        this.professor = professor;
        this.processors = new ArrayList<>();
    }

    @Override
    public void run() {
        super.run();
        logger.info("Initiating processors' bundle for user " + this.professor.getUsername());

        //Runs Congrant Processor
        CongrantProcessor congrantProcessor = new CongrantProcessor(professor, "CONGRANT");
        congrantProcessor.start();
        processors.add(congrantProcessor);

        //Runs DSL Processor
        DSLProcessor dslProcessor = new DSLProcessor(professor, "DSL");
        dslProcessor.start();
        processors.add(dslProcessor);

        //Runs Adwarhonor Processor
        AwardhonorProcessor awarhonorProcessor = new AwardhonorProcessor(professor, "AWARDHONOR");
        awarhonorProcessor.start();
        processors.add(awarhonorProcessor);

        //Runs Present Processor
        PresentProcessor presentProcessor = new PresentProcessor(professor, "PRESENT");
        presentProcessor.start();
        processors.add(presentProcessor);

        //Runs NCTEACH Processor
        NCTeachProcesor ncteachProcessor = new NCTeachProcesor(professor, "NCTEACH");
        ncteachProcessor.start();
        processors.add(ncteachProcessor);

        //Runs EDUCATION Processor
        EducationProcessor educationProcessor = new EducationProcessor(professor, "EDUCATION");
        educationProcessor.start();
        processors.add(educationProcessor);

        //Runs FACDEV Processor
        FacdevProcessor facdevProcessor = new FacdevProcessor(professor, "FACDEV");
        facdevProcessor.start();
        processors.add(facdevProcessor);

        //Runs INTELLCON Processor
        IntellcontProcessor intellcontProcessor = new IntellcontProcessor(professor, "INTELLCONT");
        intellcontProcessor.start();
        processors.add(intellcontProcessor);

        //Runs CONSULT Processor
        ConsultProcessor consultProcessor = new ConsultProcessor(professor, "CONSULT");
        consultProcessor.start();
        processors.add(consultProcessor);

        //Runs PASTHIST Processor
        PasthistProcessor pasthistProcessor = new PasthistProcessor(professor, "PASTHIST");
        pasthistProcessor.start();
        processors.add(pasthistProcessor);
        
        associationProcessors();

        for (int i = 0; i < processors.size(); i++) {
            try {
                processors.get(i).join();
            } catch (InterruptedException ex) {
                logger.error("Join for" + processors.get(i).getName() + " interrupted", ex);
            }
        }

        logger.info("Processors' bundle for user " + this.professor.getUsername() + " finished");
    }

    private void associationProcessors() {
        AbstractProcessor runningProcessor = null;
        try {
            //Runs MEMBER Processor
            MemberProcesor memberProcesor = new MemberProcesor(professor, "MEMBER");
            memberProcesor.start();
            processors.add(memberProcesor);
            runningProcessor=memberProcesor;
            runningProcessor.join();

            //Runs SERVICE_DEPARTMENT Processor
            ServiceDepartmentProcessor serviceDepartmentProcessor = new ServiceDepartmentProcessor(professor, "SERVICE_DEPARTMENT");
            serviceDepartmentProcessor.start();
            processors.add(serviceDepartmentProcessor);
            runningProcessor=serviceDepartmentProcessor;
            runningProcessor.join();

            //Runs SERVICE_COLLEGE Processor
            ServiceCollegeProcessor serviceCollegeProcessor = new ServiceCollegeProcessor(professor, "SERVICE_COLLEGE");
            serviceCollegeProcessor.start();
            processors.add(serviceCollegeProcessor);
            runningProcessor=serviceCollegeProcessor;
            runningProcessor.join();

            //Runs SERVICE_UNIVERSITY Processor
            ServiceUniversityProcessor serviceUniversityProcessor = new ServiceUniversityProcessor(professor, "SERVICE_UNIVERSITY");
            serviceUniversityProcessor.start();
            processors.add(serviceUniversityProcessor);
            runningProcessor=serviceUniversityProcessor;
            runningProcessor.join();

            //Runs SERVICE_PUBLIC Processor
            ServicePublicProcessor servicePublicProcessor = new ServicePublicProcessor(professor, "SERVICE_PUBLIC");
            servicePublicProcessor.start();
            processors.add(servicePublicProcessor);
            runningProcessor=servicePublicProcessor;
            runningProcessor.join();

            //Runs SERVICE_PROFESSIONAL Processor
            ServiceProfessionalProcessor serviceProfessionalProcessor = new ServiceProfessionalProcessor(professor, "SERVICE_PROFESSIONAL");
            serviceProfessionalProcessor.start();
            processors.add(serviceProfessionalProcessor);
            runningProcessor=serviceProfessionalProcessor;
            runningProcessor.join();

            //Runs EXTERNAL_PARTNERSHIPS Processor
            ExternalPartnershipsProcessor externalPartnershipsProcessor = new ExternalPartnershipsProcessor(professor, "EXTERNAL_PARTNERSHIPS");
            externalPartnershipsProcessor.start();
            processors.add(externalPartnershipsProcessor);
            runningProcessor=externalPartnershipsProcessor;
            runningProcessor.join();

        } catch (InterruptedException ex) {

            logger.error("Join for" + runningProcessor.getName() + " interrupted", ex);
        }

    }
}
