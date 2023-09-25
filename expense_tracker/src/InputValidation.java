
public class InputValidation {

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

    public String getValueError(String text) {

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

    public String validateCategory(String text) {
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
