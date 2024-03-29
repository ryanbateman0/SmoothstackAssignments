package com.ss.dayfour.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
	
	private static int MAX_SIZE = 5;
	private static Queue<Integer> bufferArray = new LinkedList<> ();
	private static int THREAD_RUN_COUNT = 20;
	
	ProducerConsumer() {}
	
	public static void main(String[]  args) {
		Producer p = new Producer(bufferArray);
		Consumer c = new Consumer(bufferArray);
		
		p.start();
		c.start();
	}

	private static class Producer extends Thread {
		private Queue<Integer> arr;
		
		Producer(Queue<Integer> arr) {
			this.arr = arr;
		}
		
		@Override
		public void run() {
			int threadRunCount = 0;
			System.out.println("Building queue");
			while (threadRunCount < THREAD_RUN_COUNT) {
				synchronized (arr) {
					if (arr.size() == MAX_SIZE) {
						try {
							arr.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Building queue");
					}
					threadRunCount++;
					Random rand = new Random();
					int toBeQueued = rand.nextInt();
					System.out.println(toBeQueued);
					arr.add(new Integer(toBeQueued));
					arr.notifyAll();
				}
			}
			
		}
	}
	
	private static class Consumer extends Thread {
		private Queue<Integer> arr;
		
		Consumer (Queue<Integer> arr) {
			this.arr = arr;
		}
		
		@Override
		public void run() {
			int threadRunCount = 0;
			while (threadRunCount < THREAD_RUN_COUNT) {
				synchronized (arr) {
					if (arr.size() == 0) {
						try {
							arr.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Removing queue");
					}
					threadRunCount++;
					System.out.println(arr.remove());
					arr.notifyAll();
				}
			}
		}
	}
}
