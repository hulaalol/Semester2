package ex.hdmBook;


public class driver {

	
	
	
	public static void main(String[] args) {
		
		MemberManager hdmbook = new MemberManager();
		
		
		
		
		hdmbook.members.put(1, new Member ("Franz","Müller"));
		hdmbook.members.put(2, new Member("Hans","Peter"));
		hdmbook.members.put(3, new Member("Bilbo","Beutlin"));
		hdmbook.addMember(4, new Member("Karla","Kolumna"));
		hdmbook.addMember(5, new Member("Benjamin","Blümchen"));
		hdmbook.addMember(6, new Member("Benjamin","Bloomchen"));
		hdmbook.addMember(7, new Member("Benjamin","Zimmermann"));
		hdmbook.addMember(8, new Member("Bernhard","Mäsuerich"));
		hdmbook.addMember(9, new Member("Biene","Maja"));
		
		
		hdmbook.showAllMembers();
		System.out.println("\n");
		
		for(int i=8; i>0; i--){
			hdmbook.members.get(5).addFriend(hdmbook.members.get(i));
		}
		hdmbook.members.get(5).printFriends();
		
		System.out.println("\n");
		
		hdmbook.linkFriends(hdmbook.members.get(7), hdmbook.members.get(9));
		hdmbook.members.get(7).printFriends();
		
		
		System.out.println("\n");
		
		hdmbook.printSearchArray(hdmbook.searchMember("eter"));
		
		
		System.out.println("\n");
		
		hdmbook.printSearchArray(hdmbook.searchMember("ben"));
		
		
		System.out.println("\n");
		hdmbook.deleteMember(hdmbook.members.get(4));
		hdmbook.showAllMembers();
	
		
		
		
		
	}
}
