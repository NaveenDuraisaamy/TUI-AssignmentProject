package reuseable;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Readers {

    public static LoginData getLoginData() {
        ObjectMapper mapper = new ObjectMapper();
        LoginData data = null;
        try {
            data = mapper.readValue(new File("C:\\Users\\naveen.d\\Documents\\TUI\\TUI\\src\\test\\resources\\testdata.json"), LoginData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
