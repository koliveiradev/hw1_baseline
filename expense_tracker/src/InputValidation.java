
public class InputValidation {
    InputValidation() {

    }

    private String amountError = "";
    private String categoryError = "";

    public boolean isValid() {
        return amountError.isEmpty() && categoryError.isEmpty();
    }

    public String getAmountError() {
        return amountError;
    }

    public String getCategoryError() {
        return categoryError;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void validateValue(String text) {
        amountError = computeValueError(text);
    }

    private String computeValueError(String text) {

        if (isNumeric(text)) {
            double value = Double.parseDouble(text);
            if (value <= 0) {
                return "Number must be greater than 0";
            } else if (value >= 1000) {
                return "Number must be less than 1000";
            } else {
                return "";
            }
        }
        return "Please enter a valid number";

    }

    public void validateCategory(String text) {
        categoryError = computeCategoryError(text);
    }

    private String computeCategoryError(String text) {
        String[] categories = { "food", "travel", "bills", "entertainment", "other" };
        if (text.isEmpty()) {
            return "Please enter a category";
        } else {
            for (String category : categories) {
                if (text.toLowerCase().equals(category)) {
                    return "";
                }
            }
        }
        return "Please enter a valid category";
    }
}
