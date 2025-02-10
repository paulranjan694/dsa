class Logger {
    Map<String, Integer> map;
    int timeLimit;

    public Logger() {
        timeLimit = 10;
	    map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //System.out.println("1......"+message+"...."+map);
        if(map.containsKey(message)){
		  int prevReqTime = map.get(message);
		  if(prevReqTime+timeLimit <= timestamp){
		    map.put(message,timestamp);
		    return true;
		  }else{
		    return false;
		  }
		}
        //System.out.println(message+"...."+map);
		map.put(message,timestamp);
		return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */