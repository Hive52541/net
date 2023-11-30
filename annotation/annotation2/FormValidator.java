package annotation2;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class FormValidator {

	public Set<FieldError> validate(Object target) throws Exception{
		Set<FieldError> errors = new HashSet<FieldError>();
		
		Class<?> clazz = target.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			FieldError error = checkMin(target, field);
			if (error != null) {
				errors.add(error);
			}
			error = checkMax(target, field);
			if (error != null) {
				errors.add(error);
			}
			error = checkNotBlank(target, field);
			if (error != null) {
				errors.add(error);
			}
		}
		
		return errors;
	}
	
	// 문자열의 최소 길이를 검증한다.
	private FieldError checkMin(Object target, Field field) throws Exception {
		String fieldName = field.getName();
		
		Min min = field.getDeclaredAnnotation(Min.class);
		if (min == null) {
			return null;
		}
		
		int length = min.length();
		
		field.setAccessible(true);
		String value = (String) field.get(target);
		if (value == null) {
			return null;
		}
		
		if (value.length() >= length) {
			return null;
		}
		
		return new FieldError(fieldName, min.message());		
	}
	
	private FieldError checkMax(Object target, Field field) throws Exception {
		String fieldName = field.getName();
		
		Max max = field.getDeclaredAnnotation(Max.class);
		if (max == null) {
			return null;
		}
		
		int length = max.length();
		
		field.setAccessible(true);
		String value = (String) field.get(target);
		if (value == null) {
			return null;
		}
		
		if (value.length() <= length) {
			return null;
		}
		
		return new FieldError(fieldName, max.message());	
	}
	private FieldError checkNotBlank(Object target, Field field) throws Exception {
		String fieldName = field.getName();
		
		NotBlank notBlank = field.getDeclaredAnnotation(NotBlank.class);
		if (notBlank == null) {
			return null;
		}
		
		field.setAccessible(true);
		String value = (String) field.get(target);
		if (value != null) {
			return null;
		}
		
		return new FieldError(fieldName, notBlank.message());	
	}
}
