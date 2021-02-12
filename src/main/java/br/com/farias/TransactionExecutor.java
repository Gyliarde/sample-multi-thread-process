package br.com.farias;

import java.util.List;

public interface TransactionExecutor {

    /**
     * Executes a {@link List} of {@link Transaction} and returns its execution
     * summary, containing the number of transactions which were executed with
     * success and with error
     *
     * @param transactions
     * @return
     */
    ExecutionSummary execute(List<Transaction> transactions);
}
