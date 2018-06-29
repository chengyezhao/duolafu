package com.shoumipay.service.impl;

import org.springframework.stereotype.Service;

@Service
public class IdGenerator {

    private static final int MACHINE_ID_BITS = 10;  // machine id length
    private static final int SEQUENCE_BITS = 12;    // sequence length

    private static final int MAX_MACHINE_ID = 1024; // 2^10
    private static final int MAX_SEQUENCE = 4096;   // 2^12

    private long lastTimestamp; // last timestamp
    private long lastSequence;  // last 12 bits sequence

    private final long machineId; // 10 bits machine id (could be data-center id + worker id)
    private final long epoch;     // customized epoch

    /**
     * Create a new IdGenerator.
     *
     * @param machineId Unique machine id from 0 ~ 1023
     */
    public IdGenerator(long machineId) {
        this(machineId, 0);
    }

    /**
     * Create a new IdGenerator.
     *
     * @param machineId Unique machine id from 0 ~ 1023
     * @param epoch Epoch (in millisecond) from 0 ~ current timestamp
     */
    public IdGenerator(long machineId, long epoch) {
        // validation
        if (machineId < 0 || machineId >= MAX_MACHINE_ID) {
            throw new IllegalArgumentException(
                    String.format("machine id can't be greater or equal than %d or less than 0",
                            MAX_MACHINE_ID));
        }
        if (epoch >= System.currentTimeMillis()) {
            throw new IllegalArgumentException("epoch can't be greater than current timestamp");
        }

        this.machineId = machineId;
        this.epoch = epoch;
    }

    public long getMachineId() {
        return machineId;
    }

    public long getEpoch() {
        return epoch;
    }

    /**
     * Generate the next (new) unique id. This is a synchronized method, max blocking time is 1ms.
     *
     * @return Id
     */
    public synchronized long nextId() {
        long currentTimestamp = System.currentTimeMillis();
        long currentSequence;

        // validation
        if (currentTimestamp < this.lastTimestamp) {
            throw new IllegalStateException(String
                    .format("clock is moving backwards. Rejecting requests until %d.", this.lastTimestamp));
        }

        if (currentTimestamp == this.lastTimestamp) {
            // stay in the same timestamp, add to the sequence
            currentSequence = this.lastSequence + 1;
            if (currentSequence >= MAX_SEQUENCE) {
                // max sequence reached, wait till next millisecond
                currentSequence = 0;
                currentTimestamp = tilNextMillis(this.lastTimestamp);
            }
        } else {  // currentTimestamp > this.lastTimestamp
            // start a new sequence for a new timestamp
            currentSequence = 0;
        }

        this.lastTimestamp = currentTimestamp;
        this.lastSequence = currentSequence;

        return currentTimestamp << MACHINE_ID_BITS << SEQUENCE_BITS
                | this.machineId << SEQUENCE_BITS
                | currentSequence;
    }

    // Wai till next millisecond
    private long tilNextMillis(long lastTimestamp) {
        long currentTimestamp = System.currentTimeMillis();
        while (currentTimestamp <= lastTimestamp) {
            currentTimestamp = System.currentTimeMillis();
        }
        return currentTimestamp;
    }

    @Override
    public String toString() {
        return "IdGenerator{" +
                "lastTimestamp=" + this.lastTimestamp +
                ", lastSequence=" + this.lastSequence +
                ", machineId=" + this.machineId +
                ", epoch=" + this.epoch +
                '}';
    }
}