package HomeWork17;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Convertor {
    public static void main(String[] args) throws IOException {
        String inputFilePath = args[0];

        ObjectMapper mapperForJson = new ObjectMapper(new JsonFactory());
        ObjectMapper mapperForYaml = new ObjectMapper(new YAMLFactory());

        if (inputFilePath.substring(inputFilePath.lastIndexOf(".")).equals(".json")){
            File jsonFile = new File(inputFilePath);

            if (!jsonFile.exists()){
                System.out.println("File does not exist");
                System.exit(-1);
            }else if (jsonFile.isDirectory()){
                System.out.println("This is directory, not file");
                System.exit(-1);
            }

            String yamlFileName = inputFilePath.replace(".json", ".yaml");
            File jsonToYamlFile = new File(yamlFileName);

            Person personFromJson = mapperForJson.readValue(jsonFile, Person.class);

            mapperForYaml.writeValue(jsonToYamlFile, personFromJson);
        }else if (inputFilePath.substring(inputFilePath.lastIndexOf(".")).equals(".yaml")){
            File yamlFile = new File(inputFilePath);

            if (!yamlFile.exists()){
                System.out.println("File does not exist");
                System.exit(-1);
            }else if (yamlFile.isDirectory()){
                System.out.println("This is directory, not file");
                System.exit(-1);
            }

            String jsonFileName = inputFilePath.replace(".yaml", ".json");
            File yamlToJsonFile = new File(jsonFileName);

            Person personFromYaml = mapperForYaml.readValue(yamlFile, Person.class);

            mapperForJson.writeValue(yamlToJsonFile, personFromYaml);
        }else System.out.println("Error! Incorrect file path!");
    }
}
