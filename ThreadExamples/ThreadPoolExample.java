import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        
        System.out.println("Main Thread: Starting the thread pool...");
        // Create a pool of 3 workers
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is processing Task " + taskId);
                try {
                    // Simulate a task that takes 2 seconds
                    Thread.sleep(2000); 
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was forcefully interrupted!");
                }
                System.out.println(Thread.currentThread().getName() + " finished Task " + taskId);
            });
        }

        // 1. Stop accepting new tasks. (Non-blocking)
        System.out.println("Main Thread: Calling shutdown(). No new tasks accepted.");
        threadPool.shutdown(); 

        try {
            // 2. Wait for existing tasks to finish. (BLOCKING)
            // The Main thread goes to sleep here for up to 10 seconds.
            System.out.println("Main Thread: Waiting for workers to finish (awaitTermination)...");
            
            boolean finishedInTime = threadPool.awaitTermination(10, TimeUnit.SECONDS);

            if (finishedInTime) {
                System.out.println("Main Thread: All tasks completed successfully!");
            } else {
                // 3. Timeout reached! Tasks took too long.
                System.err.println("Main Thread: Timeout reached! Forcefully shutting down stuck tasks...");
                threadPool.shutdownNow(); // Sends an interrupt signal to all running threads
            }

        } catch (InterruptedException e) {
            // 4. If the Main thread itself is interrupted while waiting
            System.err.println("Main Thread: I was interrupted while waiting! Forcefully shutting down...");
            threadPool.shutdownNow();
            Thread.currentThread().interrupt(); // Preserve the interrupt status
        }

        System.out.println("Main Thread: Exiting program.");
    }
}
