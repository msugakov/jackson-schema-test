package jackson.schema.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class House implements Facility {
    private Kitchen kitchen;

    private Bathroom bathroom;

    @XmlElement(namespace = "http://this-namespace-will-be-present/")
    private LivingRoom livingRoom;

    @XmlAttribute
    private String number;
}
