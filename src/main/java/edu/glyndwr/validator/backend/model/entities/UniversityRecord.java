package edu.glyndwr.validator.backend.model.entities;

import lombok.Data;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Data
public class UniversityRecord {

    private String studentID;
    private String computingModuleCode;
    private String plasCochCampusRoomNumber;
    private String wGUemailAddress;
    private String uKPostcode;

    public UniversityRecord() {

    }

    public UniversityRecord(String studentID, String computingModuleCode, String plasCochCampusRoomNumber, String wGUemailAddress, String uKPostcode) {
        this.studentID = studentID;
        this.computingModuleCode = computingModuleCode;
        this.plasCochCampusRoomNumber = plasCochCampusRoomNumber;
        this.wGUemailAddress = wGUemailAddress;
        this.uKPostcode = uKPostcode;
    }
}
