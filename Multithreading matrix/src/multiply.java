 public class multiply extends Main implements Runnable {
    private final int i;

    public multiply(int i) {
        this.i = i;
    }

    //Set member values to 1
    @Override
    public void run() {

        int il_elementow = (m * p);
        int il_operacji = il_elementow / ilosc_watkow;
        int resz_operacji = il_elementow % ilosc_watkow;

        int start_op, end_op;

        if (nr_watk == 0) {
            start_op = il_operacji * nr_watk;
            end_op = (il_operacji * (nr_watk + 1)) + resz_operacji;
        }
        else {
            start_op = il_operacji * nr_watk + resz_operacji;
            end_op = (il_operacji * (nr_watk + 1)) + resz_operacji;
        }


        for (int op = start_op; op < end_op; op++) {
            int row = op % m;
            int col = op / m;

            int s = 0;

            for (int i = 0; i < m; i++) {
                int e1 = A.get(row).get(i);
                int e2 = B.get(i).get(col);
                s += e1 * e2;

            }
            C.get(row).set(col,s);
        }
    }

}
