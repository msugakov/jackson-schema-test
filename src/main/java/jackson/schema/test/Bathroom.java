package jackson.schema.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@XmlRootElement(namespace = "http://this-namepace-it-is-not-present-also/")
public class Bathroom {
    @XmlAttribute
    private boolean hasHotWater;
}
