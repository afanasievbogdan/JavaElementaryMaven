package HomeWork17;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Convertor {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите абсолютный путь к json или yaml фалу");
        System.out.println("Например один из этих :\n" +
                "C:\\\\Users\\\\MSI\\\\IdeaProjects\\\\JavaElementaryMaven\\\\src\\\\main\\\\java\\\\HomeWork17\\\\data.json\n" +
                "C:\\\\Users\\\\MSI\\\\IdeaProjects\\\\JavaElementaryMaven\\\\src\\\\main\\\\java\\\\HomeWork17\\\\data.yaml");
        String inputFilePath = scanner.nextLine();

        ObjectMapper mapperForJson = new ObjectMapper(new JsonFactory());
        ObjectMapper mapperForYaml = new ObjectMapper(new YAMLFactory());

        if (inputFilePath.substring(inputFilePath.lastIndexOf(".")).equals(".json")){
            File jsonFile = new File(inputFilePath);

            String yamlFileName = inputFilePath.replace(".json", ".yaml");
            File jsonToYamlFile = new File(yamlFileName);

            Person personFromJson = mapperForJson.readValue(jsonFile, Person.class);

            mapperForYaml.writeValue(jsonToYamlFile, personFromJson);
        }else if (inputFilePath.substring(inputFilePath.lastIndexOf(".")).equals(".yaml")){
            File yamlFile = new File(inputFilePath);
            String jsonFileName = inputFilePath.replace(".yaml", ".json");
            File yamlToJsonFile = new File(jsonFileName);

            Person personFromYaml = mapperForYaml.readValue(yamlFile, Person.class);

            mapperForJson.writeValue(yamlToJsonFile, personFromYaml);
        }else System.out.println("Error! Incorrect file path!");
    }
}

                /* FOR TESTS */

//        jsonFile C:\\Users\\MSI\\IdeaProjects\\JavaElementaryMaven\\src\\main\\java\\HomeWork17\\data.json

//        yamlFile C:\\Users\\MSI\\IdeaProjects\\JavaElementaryMaven\\src\\main\\java\\HomeWork17\\data.yaml

                /* FOR TESTS */
