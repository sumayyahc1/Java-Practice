public class Matrix {

    private int[][] values;
    private int order;

    public Matrix(int order, int[][] values) {
        this.order = order;
        this.values = values;
    }

    public Matrix multiply(Matrix m) {
        int newValues[][] = new int[order][order];

        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                for(int k = 0; k < order; k++) {
                    newValues[i][j] += this.values[i][k] * m.values[k][j];
                }
            }
        }

        Matrix product = new Matrix(this.order, newValues);

        return product;
    }
    
    public String toString() {
        String matrixString = "";
        for (int[] row: this.values) {
            for(int val: row){
                matrixString += val + " ";
            }
            matrixString += "\n";
        }

        return matrixString;
    }
}
