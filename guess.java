import java.util.*;

/*class guess extends start{

public static void main(String[] as){


//guess g1 = new guess();

//g1.now();
}
}
*/
class guess extends sps2{
	
public void now(){	

System.out.println("\t\t\t----------GUESS THE NUMBER GAME----------");
System.out.println("\n\t I AM GUESSING A NUMBER BETWEEN 0 TO 9, CAN YOU GUESS IT RIGHT ???");
	
start s1 = new start();	
for(int i = 1; i<=10; i++){
s1.comp();
s1.user();
s1.result();

}
}
}





class sps2{
int rand1 ,u, ptr = 1 ;	
public void comp(){

 rand1 = (int)(Math.random()*10);
 //System.out.println(rand1);

}

public void user(){
	
Scanner sc =  new Scanner(System.in);
System.out.print("\nTAKE A GUESS -->> ");
u = sc.nextInt();
}
public void result(){
	if(rand1 == u){
	System.out.println("\nYou Guessed It Right !!!!!!!!!");
	System.out.println("You took "+ptr+" guesses");
	ptr = 1;
	}
	else{
		System.out.println("\nOOPS!! You Missed It Try Again");
		ptr++;
//System.out.println(i);
	}
}
}