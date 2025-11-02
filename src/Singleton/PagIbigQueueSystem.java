package Singleton;

public class PagIbigQueueSystem {
    private static PagIbigQueueSystem instance;
    private int currentQueueNumber = 1;
    private int[] deskServingNumbers = new int[3];
    private int nextDeskToServe = 0;

    private PagIbigQueueSystem() {}

    public static synchronized PagIbigQueueSystem getInstance() {
        if (instance == null) {
            instance = new PagIbigQueueSystem();
        }
        return instance;
    }

    public synchronized String getNextQueueNumberFormatted() {
        int queueNum = currentQueueNumber++;
        deskServingNumbers[nextDeskToServe] = queueNum;
        String assignedDesk = "Desk " + (nextDeskToServe + 1);
        nextDeskToServe = (nextDeskToServe + 1) % 3;
        return String.format("Your queue number: A%03d (%s)", queueNum, assignedDesk);
    }

    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public synchronized void resetQueueNumber(int newNumber) {
        currentQueueNumber = newNumber;
        for (int i = 0; i < deskServingNumbers.length; i++) {
            deskServingNumbers[i] = newNumber - 1;
        }
        nextDeskToServe = 0;
    }

    public synchronized String getCurrentQueueNumberFormatted() {
        return String.format("A%03d", currentQueueNumber);
    }

    public synchronized String resetQueueNumberFormatted(int newNumber) {
        resetQueueNumber(newNumber);
        return String.format("Queue reset to A%03d", newNumber);
    }

    public synchronized String getDeskServingNumberFormatted(int deskIndex) {
        if (deskIndex >= 0 && deskIndex < 3) {
            return String.format("A%03d", deskServingNumbers[deskIndex]);
        }
        return "Invalid Desk";
    }
}
