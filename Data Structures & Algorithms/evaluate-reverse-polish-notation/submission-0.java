class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            // Number
            if (!tokens[i].equals("+") &&
                !tokens[i].equals("-") &&
                !tokens[i].equals("*") &&
                !tokens[i].equals("/")) {

                st.push(Integer.parseInt(tokens[i]));
            }

            // Operator
            else {
                int b = st.pop();
                int a = st.pop();

                int result = 0;

                switch (tokens[i]) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                st.push(result);
            }
        }

        return st.pop();
    }
}