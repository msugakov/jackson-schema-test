package jackson.schema.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;

@Data
@AllArgsConstructor
public class Kitchen implements Facility {
    @XmlAttribute
    private int numberOfWindows;
}
