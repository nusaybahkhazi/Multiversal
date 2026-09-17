import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;

public class robotConfigReader {
    public void initConfig() {
        YAMLMapper mapper = new YAMLMapper();
        try {
            // Read YAML file and map it to UserSettings class
            RobotConfig config = mapper.readValue(new File("robotConfig.yml"), RobotConfig.class);
            return
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
