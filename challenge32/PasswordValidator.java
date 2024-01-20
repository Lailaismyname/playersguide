public class PasswordValidator{
	private String password;
	public PasswordValidator(String password){
		this.password = password;
	}
	public boolean isPasswordValid(){
		boolean isCorrectLength = false;
		if(password.length() > 4 || password.length() > 13){
			isCorrectLength = true;
		}
		else{
			isCorrectLength =  false;
		}
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasAmpersand = false;
		boolean hasCapitalT = false;
		boolean hasNumber = false;
		for (char ch: password.toCharArray()){
			if(Character.isUpperCase(ch)){
				hasUpperCase = true;
			}
			if(Character.isLowerCase(ch)){
				hasLowerCase = true;
			}
			if(ch == 'T'){
				hasCapitalT = true;
			}
			if(ch == '&'){
				hasAmpersand = true;
			}
			if(Character.isDigit(ch)){
				hasNumber = true;
			}
		}
		
		// check if all password requirements are met
		if(isCorrectLength && hasLowerCase && hasUpperCase && !hasCapitalT && !hasAmpersand && hasNumber){
			return true;
		}else{
			return false;
		}
	}
}
