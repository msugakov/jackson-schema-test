package jackson.schema.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SchemaSerializationTest {
    private final ObjectMapper xmlMapper = new XmlMapper().registerModule(new JaxbAnnotationModule());

    @Test
    void shouldSerializeWithXmlns() throws JsonProcessingException {
        var kitchen = new Kitchen(2);
        var bathroom = new Bathroom(false);
        var livingRoom = new LivingRoom("Cosy");
        var house = new House(kitchen, bathroom, livingRoom, "30");

        var result = xmlMapper.writeValueAsString(house);

        // `result` contains the following:
        assertThat(result).isEqualTo(
                "<House number=\"30\"><kitchen numberOfWindows=\"2\"/><bathroom hasHotWater=\"false\"/><wstxns1:livingRoom xmlns:wstxns1=\"http://this-namespace-will-be-present/\"><atmosphere>Cosy</atmosphere></wstxns1:livingRoom></House>"
        );

        assertThat(result).contains("http://this-namespace-will-be-present/"); // passes, the namespace is present
        assertThat(result).contains("http://this-namepace-should-be-present-but-it-is-not/"); // fails - absent
        assertThat(result).contains("http://this-namepace-it-is-not-present-also/"); // fails - absent
    }
}
