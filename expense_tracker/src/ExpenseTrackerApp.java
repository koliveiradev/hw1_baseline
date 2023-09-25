import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    final InputValidation validator = new InputValidation();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel, validator);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      String amount = view.getAmountField();
      String category = view.getCategoryField();

      validator.validateValue(amount);
      validator.validateCategory(category);

      if (validator.isValid()) {
        // Create transaction object
        Transaction t = new Transaction(Double.parseDouble(amount), category);
        // Call controller to add transaction
        view.addTransaction(t);
      } else {
        view.refreshErrorPanel();
      }

    });

  }

}