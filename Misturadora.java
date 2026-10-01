class Misturadora extends Thread {
    private final int[] a, b;
    private int[] resultado;

    public Misturadora(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    
    public void run() {
        resultado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultado[k++] = a[i++];
            } else {
                resultado[k++] = b[j++];
            }
        }

        while (i < a.length) {
            resultado[k++] = a[i++];
        }

        while (j < b.length) {
            resultado[k++] = b[j++];
        }
    }
