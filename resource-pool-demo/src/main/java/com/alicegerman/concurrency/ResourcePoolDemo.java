package com.alicegerman.concurrency;

public class ResourcePoolDemo {
	public static void main(String[] args) {
	    ResourcePool pool = new ResourcePool(3);

	    UserThread[] threads = new UserThread[10];

	    for (int i = 0; i < threads.length; i++) {
	        threads[i] = new UserThread(pool);
	        threads[i].start();
	    }
	    for (int i = 0; i < threads.length; i++) {
	    	try {
	    		threads[i].join();
	    	}catch(InterruptedException e) {
	    		
	    	}
	    }
	    for (int id = 1; id <= 3; id++) {
	        System.out.println(
	            "Resource " + id + " was used "
	            + pool.getUseCount(id) + " times"
	        );
	    }
	}
}
