/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import org.w3c.dom.Document;



/**
 *
 * @author 1130619373
 */
public class Professor {
    private String username;
    private String dmuId;
    private String firstName;
    private String lastName;
    private String peopleId;
    private String detailsServiceUrl;
    private String schemasServiceUrl;
    private Document schemaDocument;

    public String getDetailsServiceUrl() {
        return detailsServiceUrl;
    }

    public void setDetailsServiceUrl(String detailsServiceUrl) {
        this.detailsServiceUrl = detailsServiceUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchemasServiceUrl() {
        return schemasServiceUrl;
    }

    public void setSchemasServiceUrl(String schemasServiceUrl) {
        this.schemasServiceUrl = schemasServiceUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public synchronized Document getSchemaDocument() {
        return schemaDocument;
    }

    public void setSchemaDocument(Document schemaDocument) {
        this.schemaDocument = schemaDocument;
    }

    public String getDmuId() {
        return dmuId;
    }

    public void setDmuId(String dmuId) {
        this.dmuId = dmuId;
    }
    
}
