package annotation2;

import java.util.Set;

public class App2 {

	public static void main(String[] args) throws Exception {
		UserForm user = new UserForm(null, "hong", "zxcv");
		
		FormValidator validator = new FormValidator();
		Set<FieldError> errors = validator.validate(user);
		if (!errors.isEmpty()) {
			System.out.println("유효성 체크를 통과하지 못하였음");
			System.out.println(errors);
		} else {
			System.out.println("유효성 체크를 통과하지 못하였음");
		}
	}
}
