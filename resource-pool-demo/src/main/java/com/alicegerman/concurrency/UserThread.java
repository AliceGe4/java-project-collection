package com.alicegerman.concurrency;

public class UserThread extends Thread {
    private ResourcePool pool;

    public UserThread(ResourcePool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        Resource resource = pool.getResource();

        System.out.println("Resource id: " + resource.getId());

        resource.use();

        pool.returnResource(resource);
    }
}
