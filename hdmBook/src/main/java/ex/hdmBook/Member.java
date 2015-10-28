package ex.hdmBook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * A simple http://logging.apache.org/log4j/2.x demo,
 *  see file log4j2.xml for configuration options.
 * 
 */
public class Member implements Comparable{
	
	public String firstName;
	public String lastName;
	public Set<Member> friends = new HashSet();
	
	
    private static Logger log = LogManager.getLogger(Member.class);

    /**
     * @param args Unused
     */
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        log.debug("With respect to logging you may want to configure file ");
        log.debug("'src/main/resources/log4j2.xml' to suit your needs.");
        log.debug("This config file 'log4j2.xml' will result in 'A1.log'");
        log.debug("file containing logging output as well.");
    }
    
    public Member(String firstname, String lastname){
    	this.firstName = firstname;
    	this.lastName = lastname;
    }
    
    public void addFriend(Member friend){
    	
    	if(!(friend.equals(this))){
    		this.friends.add(friend);
        	friend.friends.add(this);
    	}else{
    		System.out.println("ERROR: You can't be friends with yourself!");
    	}
    	
    }
    
    public void deleteFriend(Member friend){
    	this.friends.remove(friend);
    }
    
    public void printFriends(){
    	
    	for(Member friend : friends){
    		System.out.println(friend.firstName+" "+friend.lastName);
    	}
    }
    
    public void setFirstName(String firstname){
    	this.firstName = firstname;
    }
    
    public String getFirstName(){
    	return this.firstName;
    }
    
    public void setLastName(String lastname){
    	this.lastName = lastname;
    }
    
    public String getLastName(){
    	return this.lastName;
    }
    
    public void setFriendlist(Set<Member> friendlist){
    	this.friends = friendlist;
    }
    
    public Set<Member> getFriendlist(){
    	return this.friends;
    }
    
    public Member[] getFriendsArray(){
    	return (Member[]) this.friends.toArray();
    }
    
    
    public void setFriendsArray(Member[] friends){
    	this.friends.clear();
    	
    	for(Member friend: friends){
    		this.friends.add(friend);
    	}
    	
    	
    	
    }

	@Override
	public int compareTo(Object o) {
		
		Member memberO = (Member)o;
		
		if(this.firstName.equals(memberO.firstName) && this.lastName.equals(memberO.lastName) && this.friends.equals(memberO.friends)){
			return 0;
		}else if(this.firstName.charAt(0)<memberO.firstName.charAt(0)){
			return 1;
		}else if(this.firstName.charAt(0)==memberO.firstName.charAt(0) && this.lastName.charAt(0)<memberO.lastName.charAt(0)){
			return 1;
		}else{
			return -1;
		}

	}
    
    
    
    
}
	