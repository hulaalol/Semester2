package ex.hdmBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberManager {

	Map<Integer, Member> members = new HashMap();

	
	public void addMember(Integer id, Member member){
		members.put(id, member);
	}
	
	public void deleteMember(Member member){
		members.remove(member);
	}
	
	public Member[] searchMember(String search){
		
		List<Member> results = new ArrayList();
	
		search = search.toLowerCase();
		
		for(Member member : members.values()){
			
			if(member.firstName.toLowerCase().contains(search) || member.lastName.toLowerCase().contains(search)){
				results.add(member);
				
			}
		}
		
		int size = results.size();
		
		Member[] resultArray = new Member[size];
		
		for(int i=0; i<size; i++){
			resultArray[i]=results.get(i);
		}
		
		return resultArray;
		
	}
	
	public void printSearchArray(Member[] members){
		
		int count = members.length;
		
		for(Member member : members){
			System.out.println("Found match nr.:"+count+" "+member.firstName+" "+member.lastName);
			count--;
		}
		
	}
	
	
	public void linkFriends(Member a, Member b){
		a.friends.add(b);
		b.friends.add(a);
	}
	
	public void showAllMembers(){
		
		for(Member member : members.values()){
			
			System.out.println(member.firstName+" "+member.lastName);
			
		}
		
	}

}
