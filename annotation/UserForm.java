package annotation;

public class UserForm {

  @NotBlank
  private String name;

  @NotBlank
  @Min(value = 5)
  private String id;

  @NotBlank
  @Min(value = 8)
  @Max(value = 16)
  private String password;

  public UserForm(String name, String id, String password) {
    this.name = name;
    this.id = id;
    this.password = password;
  }
}
