package io;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraphFileReaderTest {

    private GraphFileReader graphFileReader;

    @BeforeAll
    public void setUp(){
        graphFileReader = new GraphFileReader();
    }

    @Test
    void readNodesFromFile() {
        // given
        Path resourcePath = Paths.get("src","test","resources", "routes.txt");
        String fileName = resourcePath.toString();
        // when
        List result = graphFileReader.readNodesFromFile(fileName);
        // then
        assertThat(result).isNotEmpty();
    }
}