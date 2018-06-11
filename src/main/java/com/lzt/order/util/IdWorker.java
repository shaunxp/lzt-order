package com.lzt.order.util;

public class IdWorker {

	private long workerId;
	private long datacenterId;
	private long sequence = 0L;

	private static long twepoch = 1288834974657L;

	private static long workerIdBits = 5L;
	private static long datacenterIdBits = 5L;
	private static long maxWorkerId = -1L ^ (-1L << (int) workerIdBits);
	private static long maxDatacenterId = -1L ^ (-1L << (int) datacenterIdBits);
	private static long sequenceBits = 12L;

	private long workerIdShift = sequenceBits;
	private long datacenterIdShift = sequenceBits + workerIdBits;
	private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
	private long sequenceMask = -1L ^ (-1L << (int) sequenceBits);

	private long lastTimestamp = -1L;
	private static Object syncRoot = new Object();

	public IdWorker(long workerId, long datacenterId) throws Exception {

		// sanity check for workerId
		if (workerId > maxWorkerId || workerId < 0) {
			// throw new Exception(String.format("worker Id can't be greater
			// than %d or less than 0", maxWorkerId));
			throw new Exception("system error");
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			// throw new Exception(String.format("datacenter Id can't be greater
			// than %d or less than 0", maxDatacenterId));
			throw new Exception("system error");
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	public long nextId() throws Exception {
		synchronized (syncRoot) {
			long timestamp = timeGen();

			if (timestamp < lastTimestamp) {
				throw new Exception("system error");
			}

			if (lastTimestamp == timestamp) {
				sequence = (sequence + 1) & sequenceMask;
				if (sequence == 0) {
					timestamp = tilNextMillis(lastTimestamp);
				}
			} else {
				sequence = 0L;
			}

			lastTimestamp = timestamp;

			return ((timestamp - twepoch) << (int) timestampLeftShift) | (datacenterId << (int) datacenterIdShift)
					| (workerId << (int) workerIdShift) | sequence;
		}
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return System.currentTimeMillis();
		// return (long) (DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0,
		// DateTimeKind.Utc)).TotalMilliseconds;
	}
	
	
	
	public static void main(String args[]) throws Exception{
		IdWorker idWorker = new IdWorker(1, 1);
		long id = idWorker.nextId();
		System.out.println(id);
		
	}

}
