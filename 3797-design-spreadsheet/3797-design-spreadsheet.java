class Spreadsheet {

    private final Map<String, Integer> map; 

    public Spreadsheet(int rows) {
        this.map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.remove(cell);
    }
    
    public int getValue(String formula) {
        int plusIndex  = formula.indexOf('+');
        String cell1 = formula.substring(1, plusIndex );     
        String cell2 = formula.substring(plusIndex  + 1); 
        
        int val1 = 0, val2 = 0;
        val1 = parseValue(cell1);
        val2 = parseValue(cell2);

        return val1 + val2;
    }

    private int parseValue(String input) {
        return input.charAt(0) > '9' ? map.getOrDefault(input, 0) : Integer.parseInt(input);
    }
}
