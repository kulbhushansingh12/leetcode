public class EvaluateExpression {
   /*Given an expression string using the "+" and "-" operators like "5+16-2", write a function to find the total.

   Sample input/output:
   calculate("6+9-12")  => 3

   firstNum -> 6
   operator->
   secondNum-->

   input : string
   output : int*/
   public int evaluate(String expression) {
      if (expression == null || expression.isEmpty())
         return 0;

      String firstNum = "";
      String secondNum = "";
      char operator = 0;
      int result =0 ;
      boolean isFirstNum = true;
      for (char ch: expression.toCharArray()) { 
		 if (ch == '+' || ch == '-') {	 
            if (isFirstNum == false) {
				System.out.println("firstNum"+firstNum+", secondNum"+secondNum);
               result = operate(Integer.parseInt(firstNum), Integer.parseInt(secondNum), operator);
               firstNum = String.valueOf(result);
               secondNum = "";
            } 
			isFirstNum = false;
            operator = ch;

         } else if (isFirstNum) {
            firstNum += ch;
         } else {
            secondNum += ch;
         }
      }
	  
      return "".equals(secondNum)? Integer.parseInt(firstNum): operate(Integer.parseInt(firstNum), Integer.parseInt(secondNum), operator);
   }

   private int operate(int num1, int num2, char operator) {
      switch (operator) {
         case '+':
            return num1 + num2;
         case '-':
            return num1 - num2;
         default:
            System.out.println("not supported");
      }
      return 0;
   }

   public static void main(String[] args) {
      EvaluateExpression evaluateExpression = new EvaluateExpression();
      System.out.println(evaluateExpression.evaluate("")); //0
      System.out.println(evaluateExpression.evaluate("6+9-12")); //3
      System.out.println(evaluateExpression.evaluate("15+34-2"));
	  System.out.println(evaluateExpression.evaluate("1+2-3+4-5+6-7"));
	  System.out.println(evaluateExpression.evaluate("100+200+300"));
	  System.out.println(evaluateExpression.evaluate("1-2-3-0"));
	  System.out.println(evaluateExpression.evaluate("255"));
	  
   }
}
