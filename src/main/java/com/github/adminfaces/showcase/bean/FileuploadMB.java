package com.github.adminfaces.showcase.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFiles;

@Model
public class FileuploadMB {

    private UploadedFiles file;

    public UploadedFiles getFile() {
        return file;
    }

    public void setFile(UploadedFiles file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded. Size (KB): "+event.getFile().getSize()/1024f);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
