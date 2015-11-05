package interfaces;


public interface MemoryCardInterface {
	
	public enum state{
		VISIBLE,
		SOLVED,
		UNSOLVED;
	}
	
	
	boolean equals(Object o);
	
	state getState();
	
	String getValue();
	
	void setState(state state);
	
	String toString();
	
	

}
