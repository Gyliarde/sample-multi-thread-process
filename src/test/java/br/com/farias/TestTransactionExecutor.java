package br.com.farias;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestTransactionExecutor {

    private final Logger logger = LoggerFactory.getLogger(TestTransactionExecutor.class);


    @Test
    public void testSequential() {
        doTest(new TransactionExecutorSequential());
    }

    @Test
    public void testParallel() {
        doTest(new TransactionExecutorParallel());
    }


    private void doTest(TransactionExecutor transactionExecutor) {
        logger.debug("--------------");
        List<Transaction> transactions = getListOfTransactions();
        logger.debug("Executing transactions using " + transactionExecutor.getClass().getSimpleName());


        ExecutionSummary summary = transactionExecutor.execute(transactions);
        logger.debug("Transactions executed successfully");

        System.out.println("Number ok: " + summary.getNumberOfOk() );
        System.out.println("Number error: " + summary.getNumberOfError() );

        assertEquals(90, summary.getNumberOfOk());
        assertEquals(10, summary.getNumberOfError());
    }

    private List<Transaction> getListOfTransactions() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        for (int i = 1; i <= 100; i++) {
            transactions.add(new Transaction(Long.valueOf(i)));
        }
        return transactions;
    }
}
