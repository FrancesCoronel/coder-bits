class Timing {
    public static final int NUM_TIMINGS = 5;

    public static void main(String[] args) {
        // it is best to do the timing a few times because when Java can appear
        // "slower when it starts", so if you see slower results for the first
        // couple of timing runs, it is reasonable to discard them
        for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
            long startTime = System.nanoTime();

            // ... The code being timed ...
            // Replace this code with your own code:
            // begin code to replace:
            for (int i=0; i<123456789;i++)
                if (i%2 == 0) i++;     
            // end code to replace

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            // 1 second = 1000000000 (10^9) nanoseconds.
            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }
}

