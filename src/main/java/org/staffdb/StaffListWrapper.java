package org.staffdb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stafflist")
public class StaffListWrapper {

    /**
     * Вспомогательный класс для обёртывания списка адресатов.
     * Используется для сохранения списка адресатов в XML.
     *
     * @author Marco Jakob
     */
    private List<StaffEntity> staff;

    @XmlElement(name = "staff")
    public List<StaffEntity> getStaff() {
        if(staff == null) {
            staff = new ArrayList<>();
        }
        return staff;
    }

    public void setPersons(List<StaffEntity> persons) {
        this.staff = persons;
    }
}
