package resources.exam.izpit.io.writer;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class WriterImpl implements Writer {
    @Override
    public void writeFile(String source, String fileName) {
        try {
            String mainPath = System.getProperty("user.dir") + "/src/main/resources";
            FileWriter writer = new FileWriter(new File(mainPath + fileName));
            writer.write(source);
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
