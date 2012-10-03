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

    /** 
     * Constructor for a ProfessorThread Object
     * 
     * @param professor The professor who the thread will be run.
     */
    public ProfessorThread(Professor professor) {
        this.professor = professor;
        this.processors = new ArrayList<>();
    }
    
    /** 
     * Runs the bundle of processor for the professor of this thread
     */
    @Override
    public void run() {
        super.run();
        logger.info("Initiating processors' bundle for user " + this.professor.getUsername());

        //Runs Congrant Processor
        CongrantProcessor congrantProcessor = new CongrantProcessor(professor, "CONGRANT");
        congrantProcessor.run();
        processors.add(congrantProcessor);

        //Runs DSL Processor
        DSLProcessor dslProcessor = new DSLProcessor(professor, "DSL");
        dslProcessor.run();
        processors.add(dslProcessor);

        //Runs Adwarhonor Processor
        AwardhonorProcessor awarhonorProcessor = new AwardhonorProcessor(professor, "AWARDHONOR");
        awarhonorProcessor.run();
        processors.add(awarhonorProcessor);

        //Runs Present Processor
        PresentProcessor presentProcessor = new PresentProcessor(professor, "PRESENT");
        presentProcessor.run();
        processors.add(presentProcessor);

        //Runs NCTEACH Processor
        NCTeachProcesor ncteachProcessor = new NCTeachProcesor(professor, "NCTEACH");
        ncteachProcessor.run();
        processors.add(ncteachProcessor);

        //Runs EDUCATION Processor
        EducationProcessor educationProcessor = new EducationProcessor(professor, "EDUCATION");
        educationProcessor.run();
        processors.add(educationProcessor);

        //Runs FACDEV Processor
        FacdevProcessor facdevProcessor = new FacdevProcessor(professor, "FACDEV");
        facdevProcessor.run();
        processors.add(facdevProcessor);

        //Runs INTELLCON Processor
        IntellcontProcessor intellcontProcessor = new IntellcontProcessor(professor, "INTELLCONT");
        intellcontProcessor.run();
        processors.add(intellcontProcessor);

        //Runs CONSULT Processor
        ConsultProcessor consultProcessor = new ConsultProcessor(professor, "CONSULT");
        consultProcessor.run();
        processors.add(consultProcessor);

        //Runs PASTHIST Processor
        PasthistProcessor pasthistProcessor = new PasthistProcessor(professor, "PASTHIST");
        pasthistProcessor.run();
        processors.add(pasthistProcessor);

        associationProcessors();

        logger.info("Processors' bundle for user " + this.professor.getUsername() + " finished");
    }

    /** 
     * Runs the processor associated with the Associations table in PeopleNet system
     */
    private void associationProcessors() {
        AbstractProcessor runningProcessor = null;

        //Runs MEMBER Processor
        MemberProcesor memberProcesor = new MemberProcesor(professor, "MEMBER");
        memberProcesor.run();
        processors.add(memberProcesor);
        runningProcessor = memberProcesor;

        //Runs SERVICE_DEPARTMENT Processor
        ServiceDepartmentProcessor serviceDepartmentProcessor = new ServiceDepartmentProcessor(professor, "SERVICE_DEPARTMENT");
        serviceDepartmentProcessor.run();
        processors.add(serviceDepartmentProcessor);
        runningProcessor = serviceDepartmentProcessor;

        //Runs SERVICE_COLLEGE Processor
        ServiceCollegeProcessor serviceCollegeProcessor = new ServiceCollegeProcessor(professor, "SERVICE_COLLEGE");
        serviceCollegeProcessor.run();
        processors.add(serviceCollegeProcessor);
        runningProcessor = serviceCollegeProcessor;

        //Runs SERVICE_UNIVERSITY Processor
        ServiceUniversityProcessor serviceUniversityProcessor = new ServiceUniversityProcessor(professor, "SERVICE_UNIVERSITY");
        serviceUniversityProcessor.run();
        processors.add(serviceUniversityProcessor);
        runningProcessor = serviceUniversityProcessor;

        //Runs SERVICE_PUBLIC Processor
        ServicePublicProcessor servicePublicProcessor = new ServicePublicProcessor(professor, "SERVICE_PUBLIC");
        servicePublicProcessor.run();
        processors.add(servicePublicProcessor);
        runningProcessor = servicePublicProcessor;

        //Runs SERVICE_PROFESSIONAL Processor
        ServiceProfessionalProcessor serviceProfessionalProcessor = new ServiceProfessionalProcessor(professor, "SERVICE_PROFESSIONAL");
        serviceProfessionalProcessor.run();
        processors.add(serviceProfessionalProcessor);
        runningProcessor = serviceProfessionalProcessor;

        //Runs EXTERNAL_PARTNERSHIPS Processor
        ExternalPartnershipsProcessor externalPartnershipsProcessor = new ExternalPartnershipsProcessor(professor, "EXTERNAL_PARTNERSHIPS");
        externalPartnershipsProcessor.run();
        processors.add(externalPartnershipsProcessor);
        runningProcessor = externalPartnershipsProcessor;
    }
}
