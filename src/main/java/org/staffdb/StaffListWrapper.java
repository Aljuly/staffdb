package org.staffdb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stafflist")
public class StaffListWrapper {

    /**
     * Вспомогательный класс для обёртывания списка адресатов.
     * Используется для сохранения списка адресатов в XML.
     *
     * @author Marco Jakob
     */
    private List staff;

    @XmlElement(name = "staff")
    public List getStaff() {
        return staff;
    }

    public void setPersons(List persons) {
        this.staff = persons;
    }
}
