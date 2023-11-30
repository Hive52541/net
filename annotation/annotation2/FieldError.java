package annotation2;

public class FieldError {

	private String name;
	private String message;
	
	public FieldError(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldError [name=" + name + ", message=" + message + "]";
	}
	
}
