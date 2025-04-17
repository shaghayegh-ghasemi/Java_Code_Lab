import com.bounteous.file.processing.FileProcessingExecutor;
import com.bounteous.priority.TaskManager;

public class Main {
    public static void main(String[] args) {

        // Assignment 1
//        System.out.println("Concurrent File Processing: ");
//        FileProcessingExecutor fileProcessingExecutor = new FileProcessingExecutor();
//        fileProcessingExecutor.run("src/resources");

        // Assignment 2
        System.out.println("Producer-Consumer with Priority and Backpressure: ");
        TaskManager taskManager = new TaskManager(8, 2, 3, 5);
        try {
            taskManager.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}