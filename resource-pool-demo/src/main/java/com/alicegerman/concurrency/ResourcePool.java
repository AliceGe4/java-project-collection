package com.alicegerman.concurrency;

public class ResourcePool {
	private Resource[] id_pool;
	private int[] use_pool;
	private int count;
	
	public ResourcePool(int n) {
		use_pool = new int[n];
		id_pool = new Resource[n];
		count = n;
		for(int i = 0; i< use_pool.length; i++) {
			id_pool[i] = new Resource(i + 1);
		}
	}
	public synchronized Resource getResource() {
		while(count == 0) {
			try {
				wait();
			}catch(InterruptedException e) {
				//skip
			}
		}
		for(int i = 0; i<id_pool.length; i++) {
			if(id_pool[i] != null) {
				use_pool[i]++;
				Resource temp = id_pool[i];
				id_pool[i] = null;
				count--;
				return temp;
			}
		}
		return null; //Should never reach here
	}
	public synchronized void returnResource(Resource d) {
		int temp = d.getId();
		id_pool[temp-1] = d;
		count++;
		notifyAll();
	}
	public synchronized int getUseCount(int loc) {
		return use_pool[loc-1];
	}
	
	
}
