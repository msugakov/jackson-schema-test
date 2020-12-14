package jackson.schema.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://this-namepace-should-be-present-but-it-is-not/")
public interface Facility {
}
