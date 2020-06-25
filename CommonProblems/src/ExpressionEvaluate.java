import java.util.Stack;


public class ExpressionEvaluate {
	public static void main(String[] args){
		String expression = "5 * (101+2*6)";
		System.out.println("Output of the expression is : " + evaluateExpression(expression));
		
	}
	
	private static int evaluateExpression(String expression){
		int answer = 0;
		
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		
		if(expression != null){
			System.out.println("Expresssion length " + expression.length());
			for(int i=0; i<expression.length(); i++){
				if(expression.charAt(i) == ' '){
					continue;
				}else if(expression.charAt(i) >= '0' && expression.charAt(i) < '9'){
					StringBuffer sbuff = new StringBuffer();
					while(i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
						sbuff.append(expression.charAt(i++));
					}
					values.push(Integer.parseInt(sbuff.toString()));
					i--;
				}
				else if(expression.charAt(i) == '('){
					operator.push(expression.charAt(i));
				}
				else if(expression.charAt(i) == ')'){
					while(operator.peek() != '('){
						values.push(applyOperator(operator.pop(), values.pop(), values.pop()));
					}
					operator.pop();
				}
				
				else if(expression.charAt(i) == '+' || expression.charAt(i) == '-'
						|| expression.charAt(i) == '*' || expression.charAt(i) == '/'){
					while(!operator.isEmpty() && hasPrecedance(expression.charAt(i), operator.peek())){
						values.push(applyOperator(operator.pop(), values.pop(), values.pop()));
					}
					operator.push(expression.charAt(i));
				}
			}
			while(!operator.isEmpty()){
				values.push(applyOperator(operator.pop(), values.pop(), values.pop()));
			}
			
			return values.pop();
		}else{
			System.out.println("Empty string ");
			answer = 0;
		}
		
		return answer;
	}
	
	private static boolean hasPrecedance(char operator1, char operator2){
		if(operator2 == '(' || operator2 == ')'){
			return false;
		}
		if( (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-') ){
			return false;
		}else{
			return true;
		}
	}
	
	private static int applyOperator(char operator, int a, int b){
		switch (operator) {
			case '+':{
				return a+b;
			}
			case '-':{
				return a-b;
			}
			case '*':{
				return a*b;
			}
			case '/':{
				if(a == 0){
					throw new UnsupportedOperationException("cannot divide by zero");
				}
				return b/a;
			}
		}
		return 0;
	}
}
