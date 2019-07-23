package basic;

public class TClass<T>{
	private T x;
	private T y;
	public void setX(T x){
		this.x = x;
	}	
	public void setY(T y){
		this.y = y;
	}
	public T getX(){
		return this.x;
	}
	public T getY(){
		return this.y;
	}

	public static void main(String[] args){
		TClass<Integer> a = new TClass<Integer>();
		a.setX(Integer.valueOf(args[0]));
		a.setY(Integer.valueOf(args[1]));
		System.out.println(a.getX());
		System.out.println(a.getY());

	}
}
