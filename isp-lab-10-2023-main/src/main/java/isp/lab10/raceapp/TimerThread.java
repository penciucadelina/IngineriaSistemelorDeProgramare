package isp.lab10.raceapp;

class TimerThread extends Thread {
    private long time = 0;
    private boolean running = true;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (running) {
            try {
                Thread.sleep(10);
                time += 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        this.time = endTime - startTime;
    }

    public void stopTimer() {
        running = false;
    }

    public long getTime() {
        return time;
    }
}
