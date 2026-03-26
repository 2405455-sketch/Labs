package Lab7;

class CheckArgument extends Exception {
    private String detail;

    CheckArgument(String msg) {
        detail = msg;
    }

    public String toString() {
        return "CheckArgument";
    }
}

class ArgumentCheck {

    public static void main(String args[]) {

        if (args.length < 4) {
            try {
                throw new CheckArgument("Less than four arguments");
            } catch (CheckArgument e) {
                System.out.println("Exception occurred - " + e);
            }
        } else {

            int sum = 0;

            for (int i = 0; i < 4; i++) {
                int num = Integer.parseInt(args[i]);
                sum += num * num;
            }

            System.out.println("Output : " + sum);
        }
    }
}