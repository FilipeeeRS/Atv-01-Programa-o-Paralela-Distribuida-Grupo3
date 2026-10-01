class Misturadora extends Thread {
    private int[] a;
    private int[] b;
    private int[] resultado;

    public Misturadora(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        this.resultado = new int[this.a.length + this.b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < this.a.length && j < this.b.length) {
            if (this.a[i] <= this.b[j]) {
                this.resultado[k] = this.a[i];
                i++;
            } else {
                this.resultado[k] = this.b[j];
                j++;
            }
            k++;
        }
        while (i < this.a.length) {
            this.resultado[k] = this.a[i];
            i++;
            k++;
        }
        while (j < this.b.length) {
            this.resultado[k] = this.b[j];
            j++;
            k++;
        }
    }

    public int[] getResultado() {
        return this.resultado;
    }
}