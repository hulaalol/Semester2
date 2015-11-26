package impl;

import interfaces.MemoryCardInterface;

public class MemoryCard implements MemoryCardInterface{
	
	private String value;
	private state currentState;
	public boolean locked;
	
	

	
	public MemoryCard(String value){
		this.value = value;
		locked = false;
		
	}
	
	
	public boolean equals(Object object){
		
		MemoryCard mem1;
		if(object instanceof MemoryCard){
			
			mem1 = (MemoryCard)object;
			
			if(mem1.value.equals(this.value)){
				return true;
			}else{
				return false;
			}

		}else{
			return false;
		}

	}
	
	public void setState(state currentState){
		this.currentState = currentState;
	}
	
	public state getState(){
		return this.currentState;
	}
	
	public String getValue(){
		return this.value;
	}
	
	@Override
	public String toString(){
		
		if(this.currentState==state.VISIBLE || this.currentState==state.SOLVED){
			return this.value;
		}else{
			return "*";
		}
		
	}

	
	
	
	
}
