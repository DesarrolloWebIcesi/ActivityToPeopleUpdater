/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 38555240
 */
@Entity
@Table(name = "STD_PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdPerson.findAll", query = "SELECT s FROM StdPerson s"),
    @NamedQuery(name = "StdPerson.findByIdOrganization", query = "SELECT s FROM StdPerson s WHERE s.stdPersonPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdPerson.findByStdIdPerson", query = "SELECT s FROM StdPerson s WHERE s.stdPersonPK.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "StdPerson.findByStdNFamName1", query = "SELECT s FROM StdPerson s WHERE s.stdNFamName1 = :stdNFamName1"),
    @NamedQuery(name = "StdPerson.findByStdNMaidenName", query = "SELECT s FROM StdPerson s WHERE s.stdNMaidenName = :stdNMaidenName"),
    @NamedQuery(name = "StdPerson.findByStdNFirstName", query = "SELECT s FROM StdPerson s WHERE s.stdNFirstName = :stdNFirstName"),
    @NamedQuery(name = "StdPerson.findByStdNUsualName", query = "SELECT s FROM StdPerson s WHERE s.stdNUsualName = :stdNUsualName"),
    @NamedQuery(name = "StdPerson.findByStdIdGender", query = "SELECT s FROM StdPerson s WHERE s.stdIdGender = :stdIdGender"),
    @NamedQuery(name = "StdPerson.findByStdIdSalutation", query = "SELECT s FROM StdPerson s WHERE s.stdIdSalutation = :stdIdSalutation"),
    @NamedQuery(name = "StdPerson.findByStdDtBirth", query = "SELECT s FROM StdPerson s WHERE s.stdDtBirth = :stdDtBirth"),
    @NamedQuery(name = "StdPerson.findByStdIdCountry", query = "SELECT s FROM StdPerson s WHERE s.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "StdPerson.findByStdIdGeoDiv", query = "SELECT s FROM StdPerson s WHERE s.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "StdPerson.findByStdIdSubGeoDiv", query = "SELECT s FROM StdPerson s WHERE s.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "StdPerson.findByStdComment", query = "SELECT s FROM StdPerson s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdPerson.findBySspIdPaisEmisor", query = "SELECT s FROM StdPerson s WHERE s.sspIdPaisEmisor = :sspIdPaisEmisor"),
    @NamedQuery(name = "StdPerson.findBySspPrimApellido", query = "SELECT s FROM StdPerson s WHERE s.sspPrimApellido = :sspPrimApellido"),
    @NamedQuery(name = "StdPerson.findByStdSsn", query = "SELECT s FROM StdPerson s WHERE s.stdSsn = :stdSsn"),
    @NamedQuery(name = "StdPerson.findByScoPhoto", query = "SELECT s FROM StdPerson s WHERE s.scoPhoto = :scoPhoto"),
    @NamedQuery(name = "StdPerson.findByScoHomePage", query = "SELECT s FROM StdPerson s WHERE s.scoHomePage = :scoHomePage"),
    @NamedQuery(name = "StdPerson.findBySspIdTpDoc", query = "SELECT s FROM StdPerson s WHERE s.sspIdTpDoc = :sspIdTpDoc"),
    @NamedQuery(name = "StdPerson.findBySfrNMaidenName", query = "SELECT s FROM StdPerson s WHERE s.sfrNMaidenName = :sfrNMaidenName"),
    @NamedQuery(name = "StdPerson.findBySfrNmBirthPlace", query = "SELECT s FROM StdPerson s WHERE s.sfrNmBirthPlace = :sfrNmBirthPlace"),
    @NamedQuery(name = "StdPerson.findByStdIdGeoPlace", query = "SELECT s FROM StdPerson s WHERE s.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "StdPerson.findByStdSsKey", query = "SELECT s FROM StdPerson s WHERE s.stdSsKey = :stdSsKey"),
    @NamedQuery(name = "StdPerson.findByStdSsNumber", query = "SELECT s FROM StdPerson s WHERE s.stdSsNumber = :stdSsNumber"),
    @NamedQuery(name = "StdPerson.findBySarNMarriedName", query = "SELECT s FROM StdPerson s WHERE s.sarNMarriedName = :sarNMarriedName"),
    @NamedQuery(name = "StdPerson.findBySbrIdRaca", query = "SELECT s FROM StdPerson s WHERE s.sbrIdRaca = :sbrIdRaca"),
    @NamedQuery(name = "StdPerson.findByScoPhotoInet", query = "SELECT s FROM StdPerson s WHERE s.scoPhotoInet = :scoPhotoInet"),
    @NamedQuery(name = "StdPerson.findBySgeIdAddName", query = "SELECT s FROM StdPerson s WHERE s.sgeIdAddName = :sgeIdAddName"),
    @NamedQuery(name = "StdPerson.findBySgeIdTitel", query = "SELECT s FROM StdPerson s WHERE s.sgeIdTitel = :sgeIdTitel"),
    @NamedQuery(name = "StdPerson.findBySgeIdVsw", query = "SELECT s FROM StdPerson s WHERE s.sgeIdVsw = :sgeIdVsw"),
    @NamedQuery(name = "StdPerson.findBySgeNNameCompl", query = "SELECT s FROM StdPerson s WHERE s.sgeNNameCompl = :sgeNNameCompl"),
    @NamedQuery(name = "StdPerson.findBySukMaidenName", query = "SELECT s FROM StdPerson s WHERE s.sukMaidenName = :sukMaidenName"),
    @NamedQuery(name = "StdPerson.findBySukOtherForename", query = "SELECT s FROM StdPerson s WHERE s.sukOtherForename = :sukOtherForename"),
    @NamedQuery(name = "StdPerson.findBySukPreviousSurna", query = "SELECT s FROM StdPerson s WHERE s.sukPreviousSurna = :sukPreviousSurna"),
    @NamedQuery(name = "StdPerson.findBySusDeathDate", query = "SELECT s FROM StdPerson s WHERE s.susDeathDate = :susDeathDate"),
    @NamedQuery(name = "StdPerson.findByScoSmoker", query = "SELECT s FROM StdPerson s WHERE s.scoSmoker = :scoSmoker"),
    @NamedQuery(name = "StdPerson.findByScoGbName", query = "SELECT s FROM StdPerson s WHERE s.scoGbName = :scoGbName"),
    @NamedQuery(name = "StdPerson.findByScoIdRegion", query = "SELECT s FROM StdPerson s WHERE s.scoIdRegion = :scoIdRegion"),
    @NamedQuery(name = "StdPerson.findBySarExpedido", query = "SELECT s FROM StdPerson s WHERE s.sarExpedido = :sarExpedido"),
    @NamedQuery(name = "StdPerson.findBySusVeteran", query = "SELECT s FROM StdPerson s WHERE s.susVeteran = :susVeteran"),
    @NamedQuery(name = "StdPerson.findBySusIdVetDisTy", query = "SELECT s FROM StdPerson s WHERE s.susIdVetDisTy = :susIdVetDisTy"),
    @NamedQuery(name = "StdPerson.findBySusIdVeteranWhe", query = "SELECT s FROM StdPerson s WHERE s.susIdVeteranWhe = :susIdVeteranWhe"),
    @NamedQuery(name = "StdPerson.findBySusIdEthnicity", query = "SELECT s FROM StdPerson s WHERE s.susIdEthnicity = :susIdEthnicity"),
    @NamedQuery(name = "StdPerson.findByScbDigVer", query = "SELECT s FROM StdPerson s WHERE s.scbDigVer = :scbDigVer"),
    @NamedQuery(name = "StdPerson.findByCcbProfesor", query = "SELECT s FROM StdPerson s WHERE s.ccbProfesor = :ccbProfesor"),
    @NamedQuery(name = "StdPerson.findByCcbPensionado", query = "SELECT s FROM StdPerson s WHERE s.ccbPensionado = :ccbPensionado"),
    @NamedQuery(name = "StdPerson.findByCcbFondoCesa", query = "SELECT s FROM StdPerson s WHERE s.ccbFondoCesa = :ccbFondoCesa"),
    @NamedQuery(name = "StdPerson.findByCcbFondoPensi", query = "SELECT s FROM StdPerson s WHERE s.ccbFondoPensi = :ccbFondoPensi"),
    @NamedQuery(name = "StdPerson.findByCcbEmpPromSal", query = "SELECT s FROM StdPerson s WHERE s.ccbEmpPromSal = :ccbEmpPromSal"),
    @NamedQuery(name = "StdPerson.findByCcbFPensionador", query = "SELECT s FROM StdPerson s WHERE s.ccbFPensionador = :ccbFPensionador"),
    @NamedQuery(name = "StdPerson.findByStdIdCountry1", query = "SELECT s FROM StdPerson s WHERE s.stdIdCountry1 = :stdIdCountry1"),
    @NamedQuery(name = "StdPerson.findByStdIdGeoDiv1", query = "SELECT s FROM StdPerson s WHERE s.stdIdGeoDiv1 = :stdIdGeoDiv1"),
    @NamedQuery(name = "StdPerson.findByStdIdSubGeo1", query = "SELECT s FROM StdPerson s WHERE s.stdIdSubGeo1 = :stdIdSubGeo1"),
    @NamedQuery(name = "StdPerson.findByStdIdGeoPlac1", query = "SELECT s FROM StdPerson s WHERE s.stdIdGeoPlac1 = :stdIdGeoPlac1"),
    @NamedQuery(name = "StdPerson.findByIdApprole", query = "SELECT s FROM StdPerson s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdPerson.findByIdSecuser", query = "SELECT s FROM StdPerson s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdPerson.findByDtLastUpdate", query = "SELECT s FROM StdPerson s WHERE s.dtLastUpdate = :dtLastUpdate")})

public class StdPerson implements Serializable {
    //String userName;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdPersonPK stdPersonPK;
    @Column(name = "STD_N_FAM_NAME_1")
    private String stdNFamName1;
    @Column(name = "STD_N_MAIDEN_NAME")
    private String stdNMaidenName;
    @Column(name = "STD_N_FIRST_NAME")
    private String stdNFirstName;
    @Column(name = "STD_N_USUAL_NAME")
    private String stdNUsualName;
    @Column(name = "STD_ID_GENDER")
    private String stdIdGender;
    @Column(name = "STD_ID_SALUTATION")
    private String stdIdSalutation;
    @Column(name = "STD_DT_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date stdDtBirth;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "SSP_ID_PAIS_EMISOR")
    private String sspIdPaisEmisor;
    @Column(name = "SSP_PRIM_APELLIDO")
    private String sspPrimApellido;
    @Column(name = "STD_SSN")
    private String stdSsn;
    @Column(name = "SCO_PHOTO")
    private String scoPhoto;
    @Column(name = "SCO_HOME_PAGE")
    private String scoHomePage;
    @Column(name = "SSP_ID_TP_DOC")
    private String sspIdTpDoc;
    @Column(name = "SFR_N_MAIDEN_NAME")
    private String sfrNMaidenName;
    @Column(name = "SFR_NM_BIRTH_PLACE")
    private String sfrNmBirthPlace;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "STD_SS_KEY")
    private String stdSsKey;
    @Column(name = "STD_SS_NUMBER")
    private String stdSsNumber;
    @Column(name = "SAR_N_MARRIED_NAME")
    private String sarNMarriedName;
    @Column(name = "SBR_ID_RACA")
    private String sbrIdRaca;
    @Column(name = "SCO_PHOTO_INET")
    private String scoPhotoInet;
    @Column(name = "SGE_ID_ADD_NAME")
    private String sgeIdAddName;
    @Column(name = "SGE_ID_TITEL")
    private String sgeIdTitel;
    @Column(name = "SGE_ID_VSW")
    private String sgeIdVsw;
    @Column(name = "SGE_N_NAME_COMPL")
    private String sgeNNameCompl;
    @Column(name = "SUK_MAIDEN_NAME")
    private String sukMaidenName;
    @Column(name = "SUK_OTHER_FORENAME")
    private String sukOtherForename;
    @Column(name = "SUK_PREVIOUS_SURNA")
    private String sukPreviousSurna;
    @Column(name = "SUS_DEATH_DATE")
    @Temporal(TemporalType.DATE)
    private Date susDeathDate;
    @Column(name = "SCO_SMOKER")
    private Short scoSmoker;
    @Column(name = "SCO_GB_NAME")
    private String scoGbName;
    @Column(name = "SCO_ID_REGION")
    private String scoIdRegion;
    @Column(name = "SAR_EXPEDIDO")
    private String sarExpedido;
    @Column(name = "SUS_VETERAN")
    private Short susVeteran;
    @Column(name = "SUS_ID_VET_DIS_TY")
    private String susIdVetDisTy;
    @Column(name = "SUS_ID_VETERAN_WHE")
    private String susIdVeteranWhe;
    @Column(name = "SUS_ID_ETHNICITY")
    private String susIdEthnicity;
    @Column(name = "SCB_DIG_VER")
    private String scbDigVer;
    @Column(name = "CCB_PROFESOR")
    private String ccbProfesor;
    @Column(name = "CCB_PENSIONADO")
    private String ccbPensionado;
    @Column(name = "CCB_FONDO_CESA")
    private String ccbFondoCesa;
    @Column(name = "CCB_FONDO_PENSI")
    private String ccbFondoPensi;
    @Column(name = "CCB_EMP_PROM_SAL")
    private String ccbEmpPromSal;
    @Column(name = "CCB_F_PENSIONADOR")
    private String ccbFPensionador;
    @Column(name = "STD_ID_COUNTRY1")
    private String stdIdCountry1;
    @Column(name = "STD_ID_GEO_DIV1")
    private String stdIdGeoDiv1;
    @Column(name = "STD_ID_SUB_GEO_1")
    private String stdIdSubGeo1;
    @Column(name = "STD_ID_GEO_PLAC1")
    private String stdIdGeoPlac1;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public StdPerson() {
    }

    public StdPerson(StdPersonPK stdPersonPK) {
        this.stdPersonPK = stdPersonPK;
       
    }

    public StdPerson(String idOrganization, String stdIdPerson) {
        this.stdPersonPK = new StdPersonPK(idOrganization, stdIdPerson);
    }

    public StdPersonPK getStdPersonPK() {
        return stdPersonPK;
    }

    public void setStdPersonPK(StdPersonPK stdPersonPK) {
        this.stdPersonPK = stdPersonPK;
    }

    public String getStdNFamName1() {
        return stdNFamName1;
    }

    public void setStdNFamName1(String stdNFamName1) {
        this.stdNFamName1 = stdNFamName1;
    }

    public String getStdNMaidenName() {
        return stdNMaidenName;
    }

    public void setStdNMaidenName(String stdNMaidenName) {
        this.stdNMaidenName = stdNMaidenName;
    }

    public String getStdNFirstName() {
        return stdNFirstName;
    }

    public void setStdNFirstName(String stdNFirstName) {
        this.stdNFirstName = stdNFirstName;
    }

    public String getStdNUsualName() {
        return stdNUsualName;
    }

    public void setStdNUsualName(String stdNUsualName) {
        this.stdNUsualName = stdNUsualName;
    }

    public String getStdIdGender() {
        return stdIdGender;
    }

    public void setStdIdGender(String stdIdGender) {
        this.stdIdGender = stdIdGender;
    }

    public String getStdIdSalutation() {
        return stdIdSalutation;
    }

    public void setStdIdSalutation(String stdIdSalutation) {
        this.stdIdSalutation = stdIdSalutation;
    }

    public Date getStdDtBirth() {
        return stdDtBirth;
    }

    public void setStdDtBirth(Date stdDtBirth) {
        this.stdDtBirth = stdDtBirth;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getStdIdGeoDiv() {
        return stdIdGeoDiv;
    }

    public void setStdIdGeoDiv(String stdIdGeoDiv) {
        this.stdIdGeoDiv = stdIdGeoDiv;
    }

    public String getStdIdSubGeoDiv() {
        return stdIdSubGeoDiv;
    }

    public void setStdIdSubGeoDiv(String stdIdSubGeoDiv) {
        this.stdIdSubGeoDiv = stdIdSubGeoDiv;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
    }

    public String getSspIdPaisEmisor() {
        return sspIdPaisEmisor;
    }

    public void setSspIdPaisEmisor(String sspIdPaisEmisor) {
        this.sspIdPaisEmisor = sspIdPaisEmisor;
    }

    public String getSspPrimApellido() {
        return sspPrimApellido;
    }

    public void setSspPrimApellido(String sspPrimApellido) {
        this.sspPrimApellido = sspPrimApellido;
    }

    public String getStdSsn() {
        return stdSsn;
    }

    public void setStdSsn(String stdSsn) {
        this.stdSsn = stdSsn;
    }

    public String getScoPhoto() {
        return scoPhoto;
    }

    public void setScoPhoto(String scoPhoto) {
        this.scoPhoto = scoPhoto;
    }

    public String getScoHomePage() {
        return scoHomePage;
    }

    public void setScoHomePage(String scoHomePage) {
        this.scoHomePage = scoHomePage;
    }

    public String getSspIdTpDoc() {
        return sspIdTpDoc;
    }

    public void setSspIdTpDoc(String sspIdTpDoc) {
        this.sspIdTpDoc = sspIdTpDoc;
    }

    public String getSfrNMaidenName() {
        return sfrNMaidenName;
    }

    public void setSfrNMaidenName(String sfrNMaidenName) {
        this.sfrNMaidenName = sfrNMaidenName;
    }

    public String getSfrNmBirthPlace() {
        return sfrNmBirthPlace;
    }

    public void setSfrNmBirthPlace(String sfrNmBirthPlace) {
        this.sfrNmBirthPlace = sfrNmBirthPlace;
    }

    public String getStdIdGeoPlace() {
        return stdIdGeoPlace;
    }

    public void setStdIdGeoPlace(String stdIdGeoPlace) {
        this.stdIdGeoPlace = stdIdGeoPlace;
    }

    public String getStdSsKey() {
        return stdSsKey;
    }

    public void setStdSsKey(String stdSsKey) {
        this.stdSsKey = stdSsKey;
    }

    public String getStdSsNumber() {
        return stdSsNumber;
    }

    public void setStdSsNumber(String stdSsNumber) {
        this.stdSsNumber = stdSsNumber;
    }

    public String getSarNMarriedName() {
        return sarNMarriedName;
    }

    public void setSarNMarriedName(String sarNMarriedName) {
        this.sarNMarriedName = sarNMarriedName;
    }

    public String getSbrIdRaca() {
        return sbrIdRaca;
    }

    public void setSbrIdRaca(String sbrIdRaca) {
        this.sbrIdRaca = sbrIdRaca;
    }

    public String getScoPhotoInet() {
        return scoPhotoInet;
    }

    public void setScoPhotoInet(String scoPhotoInet) {
        this.scoPhotoInet = scoPhotoInet;
    }

    public String getSgeIdAddName() {
        return sgeIdAddName;
    }

    public void setSgeIdAddName(String sgeIdAddName) {
        this.sgeIdAddName = sgeIdAddName;
    }

    public String getSgeIdTitel() {
        return sgeIdTitel;
    }

    public void setSgeIdTitel(String sgeIdTitel) {
        this.sgeIdTitel = sgeIdTitel;
    }

    public String getSgeIdVsw() {
        return sgeIdVsw;
    }

    public void setSgeIdVsw(String sgeIdVsw) {
        this.sgeIdVsw = sgeIdVsw;
    }

    public String getSgeNNameCompl() {
        return sgeNNameCompl;
    }

    public void setSgeNNameCompl(String sgeNNameCompl) {
        this.sgeNNameCompl = sgeNNameCompl;
    }

    public String getSukMaidenName() {
        return sukMaidenName;
    }

    public void setSukMaidenName(String sukMaidenName) {
        this.sukMaidenName = sukMaidenName;
    }

    public String getSukOtherForename() {
        return sukOtherForename;
    }

    public void setSukOtherForename(String sukOtherForename) {
        this.sukOtherForename = sukOtherForename;
    }

    public String getSukPreviousSurna() {
        return sukPreviousSurna;
    }

    public void setSukPreviousSurna(String sukPreviousSurna) {
        this.sukPreviousSurna = sukPreviousSurna;
    }

    public Date getSusDeathDate() {
        return susDeathDate;
    }

    public void setSusDeathDate(Date susDeathDate) {
        this.susDeathDate = susDeathDate;
    }

    public Short getScoSmoker() {
        return scoSmoker;
    }

    public void setScoSmoker(Short scoSmoker) {
        this.scoSmoker = scoSmoker;
    }

    public String getScoGbName() {
        return scoGbName;
    }

    public void setScoGbName(String scoGbName) {
        this.scoGbName = scoGbName;
    }

    public String getScoIdRegion() {
        return scoIdRegion;
    }

    public void setScoIdRegion(String scoIdRegion) {
        this.scoIdRegion = scoIdRegion;
    }

    public String getSarExpedido() {
        return sarExpedido;
    }

    public void setSarExpedido(String sarExpedido) {
        this.sarExpedido = sarExpedido;
    }

    public Short getSusVeteran() {
        return susVeteran;
    }

    public void setSusVeteran(Short susVeteran) {
        this.susVeteran = susVeteran;
    }

    public String getSusIdVetDisTy() {
        return susIdVetDisTy;
    }

    public void setSusIdVetDisTy(String susIdVetDisTy) {
        this.susIdVetDisTy = susIdVetDisTy;
    }

    public String getSusIdVeteranWhe() {
        return susIdVeteranWhe;
    }

    public void setSusIdVeteranWhe(String susIdVeteranWhe) {
        this.susIdVeteranWhe = susIdVeteranWhe;
    }

    public String getSusIdEthnicity() {
        return susIdEthnicity;
    }

    public void setSusIdEthnicity(String susIdEthnicity) {
        this.susIdEthnicity = susIdEthnicity;
    }

    public String getScbDigVer() {
        return scbDigVer;
    }

    public void setScbDigVer(String scbDigVer) {
        this.scbDigVer = scbDigVer;
    }

    public String getCcbProfesor() {
        return ccbProfesor;
    }

    public void setCcbProfesor(String ccbProfesor) {
        this.ccbProfesor = ccbProfesor;
    }

    public String getCcbPensionado() {
        return ccbPensionado;
    }

    public void setCcbPensionado(String ccbPensionado) {
        this.ccbPensionado = ccbPensionado;
    }

    public String getCcbFondoCesa() {
        return ccbFondoCesa;
    }

    public void setCcbFondoCesa(String ccbFondoCesa) {
        this.ccbFondoCesa = ccbFondoCesa;
    }

    public String getCcbFondoPensi() {
        return ccbFondoPensi;
    }

    public void setCcbFondoPensi(String ccbFondoPensi) {
        this.ccbFondoPensi = ccbFondoPensi;
    }

    public String getCcbEmpPromSal() {
        return ccbEmpPromSal;
    }

    public void setCcbEmpPromSal(String ccbEmpPromSal) {
        this.ccbEmpPromSal = ccbEmpPromSal;
    }

    public String getCcbFPensionador() {
        return ccbFPensionador;
    }

    public void setCcbFPensionador(String ccbFPensionador) {
        this.ccbFPensionador = ccbFPensionador;
    }

    public String getStdIdCountry1() {
        return stdIdCountry1;
    }

    public void setStdIdCountry1(String stdIdCountry1) {
        this.stdIdCountry1 = stdIdCountry1;
    }

    public String getStdIdGeoDiv1() {
        return stdIdGeoDiv1;
    }

    public void setStdIdGeoDiv1(String stdIdGeoDiv1) {
        this.stdIdGeoDiv1 = stdIdGeoDiv1;
    }

    public String getStdIdSubGeo1() {
        return stdIdSubGeo1;
    }

    public void setStdIdSubGeo1(String stdIdSubGeo1) {
        this.stdIdSubGeo1 = stdIdSubGeo1;
    }

    public String getStdIdGeoPlac1() {
        return stdIdGeoPlac1;
    }

    public void setStdIdGeoPlac1(String stdIdGeoPlac1) {
        this.stdIdGeoPlac1 = stdIdGeoPlac1;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdPersonPK != null ? stdPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdPerson)) {
            return false;
        }
        StdPerson other = (StdPerson) object;
        if ((this.stdPersonPK == null && other.stdPersonPK != null) || (this.stdPersonPK != null && !this.stdPersonPK.equals(other.stdPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdPerson[ stdPersonPK=" + stdPersonPK + " ]";
    }
    
   
  
}
