import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;

public class ExpenseTrackerTest {

    private ExpenseTrackerView view;
    private ExpenseTrackerApp app;
    private InputValidation validation;

    @Before
    public void setup() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Serial");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Category");
        tableModel.addColumn("Date");
        view = new ExpenseTrackerView(tableModel);
        validation = new InputValidation();
        app = new ExpenseTrackerApp();
    }

    @Test
    public void testAddTransaction() {
        // Create a new transaction
        double amount = 100.0;
        String category = "Food";
        Transaction transaction = new Transaction(amount, category);

        // Add the transaction to the view
        view.addTransaction(transaction);

        // Get the transactions from the view
        java.util.List<Transaction> transactions = view.getTransactions();

        // Verify that the transaction was added
        assertEquals(1, transactions.size());
        assertEquals(amount, transactions.get(0).getAmount(), 0.001);
        assertEquals(category, transactions.get(0).getCategory());
    }

    @Test
    public void testAmountValidation() {

        String amount = "skldj";
        validation.validateValue(amount);
        assertEquals("Please enter a valid number", validation.getAmountError());
        String amount2 = "10000";
        validation.validateValue(amount2);
        assertEquals("Number must be less than 1000", validation.getAmountError());
    }

    @Test
    public void testCategoryValidation() {

        String category = "skldj";
        validation.validateCategory(category);
        assertEquals("Please enter a valid category", validation.getCategoryError());

    }
}