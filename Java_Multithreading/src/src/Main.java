import com.bounteous.file.processing.FileProcessingExecutor;

public class Main {
    public static void main(String[] args) {
        FileProcessingExecutor fileProcessingExecutor = new FileProcessingExecutor();
        fileProcessingExecutor.run("src/resources");
    }
}