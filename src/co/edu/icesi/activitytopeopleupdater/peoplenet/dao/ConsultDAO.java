/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsult;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import java.util.Calendar;
import java.util.Date;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author 38555240
 */
public class ConsultDAO {
 
    private M4ccbCvConsult oConsultModelo;
    private M4ccbCvConsultJpaController oConsultCotrol;
    public ConsultDAO() {
    }
    
    
    public void guardarConsult(String pDesc, String pComp, Date pStart_Start, Date pStart_End, String pOrg,String pType,String pNumhours_Yearl,String pTypeother, Date pDtLastUpdate) throws PreexistingEntityException, Exception
    {
        oConsultModelo = new M4ccbCvConsult();
        
        oConsultModelo.setCcbActDes(pDesc);
        oConsultModelo.setCcbCompensado(pComp);
        oConsultModelo.setCcbDtStart(pStart_Start);
        oConsultModelo.setCcbDtEnd(pStart_End);
        oConsultModelo.setCcbEmpOrg(pOrg);
        oConsultModelo.setCcbIdConsultoria(this.idFormat(pType));
        oConsultModelo.setCcbNumHoras(pNumhours_Yearl);
        oConsultModelo.setCcbOtroTip(pTypeother);
        
        //DD/MM/YYYY 
        
        oConsultModelo.setDtLastUpdate(pDtLastUpdate);
        oConsultCotrol.create(oConsultModelo);
    
    }
    
    public String idFormat(String idConsults)
    {
      String pCodSalida;
        switch (idConsults) {

            case "Academic":
                pCodSalida = "CT_01";
                break;
            case "For Profit Organization":
                pCodSalida ="CT_02";
                break;
            case "Government":
                pCodSalida = "CT_03";
                break;
            case "Litigation":
                pCodSalida = "CT_04";
                break;
            
            case "Non-Governmental Organization (NGO)":
                pCodSalida = "CT_05";
                break;
                case "Other":
                pCodSalida = "CT_99";
                break;
                      
            default:
                pCodSalida = "CT_99";
                break;
        }
        
        return pCodSalida;
    }


    public String IdAmbito(String pIdAmbito)
    {
        String pCodSalida;
        switch (pIdAmbito) {

            case "Academic":
                pCodSalida = "CT_01";
                break;
            case "For Profit Organization":
                pCodSalida ="CT_02";
                break;
            case "Government":
                pCodSalida = "CT_03";
                break;
            case "Litigation":
                pCodSalida = "CT_04";
                break;
            
            case "Non-Governmental Organization (NGO)":
                pCodSalida = "CT_05";
                break;
                case "Other":
                pCodSalida = "CT_99";
                break;
                      
            default:
                pCodSalida = "CT_99";
                break;
        }
        
        return pCodSalida;
    
    
    }
    
   
    
}
