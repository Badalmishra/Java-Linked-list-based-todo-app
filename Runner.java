// Java code for Linked List implementation 

import java.util.*; 
import java.io.IOException;
class Todo{
	String body;
	int status;
	Todo(String body){
		this.body = body;
		this.status = 1;
	}
	public void printTodo(int index) {
		System.out.println(index+" "+this.body+" status "+this.status);
	}
	public void toggleStatus(){
		this.status = (this.status==1)?0:1;
	}
}
public class Runner 
{ 	
	
	static void showAll(LinkedList list){
		System.out.println("======================================");
		for (int i = 0; i < list.size(); i++) {
			Todo element = (Todo) list.get(i);
			element.printTodo(i);
		}
		System.out.println("======================================");
	}
	static void toggleStatus(LinkedList list){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter job ID");
		int index = scan1.nextInt();
		Todo element = (Todo) list.get(index);
		element.toggleStatus();
		showAll(list);
	}
	static void addToList(LinkedList list){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("ENTER TODO");
		String body = scan1.nextLine();
		Todo temp = new Todo(body);
		list.add(temp);
		showAll(list);
	}
	static void removeTodo(LinkedList list){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter job ID");
		int index = scan1.nextInt();
		list.remove(index);
		showAll(list);	
	}
	static void showOnlyActive(LinkedList list){
		for (int i = 0; i < list.size(); i++) {
			Todo element = (Todo) list.get(i);
			if (element.status==1) {
				element.printTodo(i);	
			}
		}
	}
	public static void main(String args[]) throws IOException, InterruptedException 
	{ 
		LinkedList<Todo> list = new LinkedList<Todo>(); 
		Scanner scan1 = new Scanner(System.in);
		int choice;
		boolean run = true;
		while (run) {
			System.out.println("| 1 to Show all \n| 2 to Add \n| 3 to toggle active status \n| 4 to remove Todo \n| 5 to show Only Active Todos\n|0 to exit");
			choice = scan1.nextInt();
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			switch (choice) {
				case 1:
					showAll(list);
					break;
				case 2:
					addToList(list);
					break;
				case 3:
					toggleStatus(list);
					break;
				case 4:
					removeTodo(list);
					break;
				case 5:
					showOnlyActive(list);
					break;
				default:
					run=!run;
					break;
			}
		}
	} 
} 
