package backend.components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAIClient {
    public static String callopenAI(String input) {
        try {
            String pythonScript = "python3";
            String scriptPath = ".\\src\\main\\java\\backend\\CallGPT.py";

            String[] command = {pythonScript, scriptPath, input};

            Process process = new ProcessBuilder(command).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return output.toString();
            } else {
                throw new IOException("Python script execution failed with exit code " + exitCode);
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
