package annotation;

import java.lang.reflect.Field;

public class FormValidator {

  public boolean validate(Object target) throws Exception {
    boolean isValid = false;

    Class<?> clazz = target.getClass();
    Field[] field = clazz.getDeclaredFields();
    for (Field field : fields) {
        boolean checkMin(target,field);
        if (!result1) {
            isValid = false;
            break;
            
        }
        
    }

    return isValid;
  }

  private boolean checkMin(Object target, Field field) throws Exception {
    Min min = field.getDeclaredAnnotation(Min.class);
    if (min == null) {
      return true;
    }

    int minLength = min.value();
    field.setAccessible(true);
    String fieldValue = (String) field.get(target);

    if (fieldValue == null) {
      return false;
    }
    return false;
  }

  private boolean checkMax(Field field) throws Exception {}

  private boolean checkNotBlank(Field field) throws Exception {}
}
