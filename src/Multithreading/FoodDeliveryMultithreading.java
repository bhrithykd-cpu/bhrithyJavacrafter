package Multithreading;

class FetchRestaurantDetails extends Thread {
    @Override
    public void run() {
        System.out.println("Fetching restaurant details...");
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Restaurant details fetched.");
    }
}

class FetchDriverAvailability extends Thread {
    @Override
    public void run() {
        System.out.println("Checking driver availability...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Driver availability checked.");
    }
}

class CalculateEstimatedDelivery extends Thread {
    @Override
    public void run() {
        System.out.println("Calculating estimated delivery time...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Estimated delivery time calculated.");
    }
}

public class FoodDeliveryMultithreading {
    public static void main(String[] args) {
        System.out.println("🛵 Starting order processing...\n");

        Thread restaurantThread = new FetchRestaurantDetails();
        Thread driverThread = new FetchDriverAvailability();
        Thread deliveryThread = new CalculateEstimatedDelivery();

        // Start all threads
        restaurantThread.start();
        driverThread.start();
        deliveryThread.start();

        // Wait for all threads to finish
        try {
            restaurantThread.join();
            driverThread.join();
            deliveryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n🎉 All tasks completed successfully!");
    }
}

