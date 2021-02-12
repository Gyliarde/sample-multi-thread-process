package br.com.farias;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Transaction {

    private final Long id;
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    public Transaction(Long id) {
        this.id = id;
    }

    /**
     * Returns a boolean indicating if the transaction was processed
     * successfully
     *
     * @return
     */
    public boolean process() {
        // waits 5 milliseconds(simulates a slow task, such as accessing a remote system)
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // error every 10 transactions
        boolean success = id % 10 != 0;
        logger.debug("Transaction processed: " + id + "; Result: " + success);
        return success;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + "]";
    }
}
