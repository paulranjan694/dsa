class Logger {
    private int timer;
    private Map<String, Integer> cache;
    public Logger() {
        timer=10;
        cache = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int nextPrint = cache.getOrDefault(message, 0);
        //System.out.println("msg -> "+message+" times -> "+timestamp+ " next ->"+nextPrint);
        boolean shouldPrint = false;
        if(nextPrint == 0){
            cache.put(message,timestamp+timer);
            shouldPrint=true;
        }else if(nextPrint <= timestamp){
            cache.put(message,timestamp+timer);
            shouldPrint=true;
        }

        return shouldPrint;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */