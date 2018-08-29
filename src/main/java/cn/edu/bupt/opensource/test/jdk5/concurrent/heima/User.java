package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

/**
 * <p>Title: ExchangerTest</p>
 * <p>Description: Exchanger测试 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:04</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class User implements Cloneable{

	private String name;

	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof User)) {
			return false;	
		}
		User user = (User)obj;
		// if(this.name==user.name && this.age==user.age)
		if(this.name.equals(user.name) && this.age==user.age) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return name.hashCode() + age;
	}
	
	public String toString() {
		return "{name:'" + name + "',age:" + age + "}";
	}

	public Object clone()  {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {}
		return object;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

} 
