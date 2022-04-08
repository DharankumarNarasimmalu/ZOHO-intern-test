package solid;
import java.util.*;
class User{                                               //Single responsibility principle
	String name;
	String address;
	String mobileNo;
	public User(String[] curruser){
		this.name=curruser[0];
		this.address=curruser[1];
		this.mobileNo=curruser[2];
	}
	void findLocation() {
		System.out.println("Finding user address location by using googlemap");
		
	}
	
	void changeDetails(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 to change mobile no||Press 2 to change Address");
		int commend=sc.nextInt();
		sc.nextLine();

		if(commend==1) {
			String mobileno=sc.nextLine();
			this.mobileNo=mobileno;

		}
		else if(commend==2) {
			String address=sc.nextLine();
			this.address=address;
		}
		
	}
	String[] savingdetails() {
		System.out.println("Your details are updated successfully");
		String changedDetails[]= {name,mobileNo,address};
		return changedDetails;
	}
	
}

class FoodItems{
	Shop shopname;
	FoodCart cart;
	
	String preferedfood;
	public FoodItems() {
		System.out.println("welcome to food delivery app");

	}
	public FoodItems(Shop shop,String food,FoodCart cart) {
		this.shopname=shop;
		this.preferedfood=food;
		this.cart=cart;
	}
	String southIndianFood() {
		List<String>items=new ArrayList<>();
		items.add("iddly");
		items.add("Pongal");
		items.add("poori");
		System.out.println("1=>iddly\n2=>pongal\n3=>poori");
		Scanner sc=new Scanner(System.in);
		int preference=sc.nextInt();
		return items.get(preference+1);
		
	}
	
	String northIndianFood() {
		List<String>items=new ArrayList<>();
		items.add("rotee");
		items.add("chapathi");
		System.out.println("1=>rotee\n2=>chapathi");
		Scanner sc=new Scanner(System.in);
		int preference=sc.nextInt();
		return items.get(preference+1);
	}
	
	String fastFood() {
		List<String>items=new ArrayList<>();
		items.add("pizza");
		items.add("burger");
		System.out.println("1=>pizza\n2=>burger");
		Scanner sc=new Scanner(System.in);
		int preference=sc.nextInt();
		return items.get(preference+1);
	}
	void order() {
		String foodname=preferedfood;
		System.out.println(preferedfood);
		int amount=shopname.fooditems(foodname);
		shopname.shoplocation();
		System.out.println("Rs "+amount);
		cart.orderedFood(foodname,amount);
		float  amountAfterDiscount=cart.discount(amount);
		cart.payment(amountAfterDiscount);

	}
	
}
interface Shop{                                             //open closed principle
	int fooditems(String preferedfood);
	void shoplocation();
}
class Shop1 implements Shop{

	@Override
	public int fooditems(String preferedfood) {
		Map<String,Integer>itemlist=new HashMap<>();
		itemlist.put("poori",80);
		itemlist.put("pongal", 100);
		itemlist.put("idly", 150);
		itemlist.put("chapathi", 30);
		itemlist.put("roti",50);
		if(itemlist.get(preferedfood)>0) {
			return itemlist.get(preferedfood);
		}
		else {
			return 0;
		}
	}
	
	@Override
	public void shoplocation() {
		System.out.println("Shop1 Chennai");
		
	}
	
}
class Shop2 implements Shop{

	@Override
	public int fooditems(String preferedfood) {
		Map<String,Integer>itemlist=new HashMap<>();
		itemlist.put("poori",80);
		itemlist.put("pongal", 100);
		itemlist.put("idly", 150);
		itemlist.put("chapathi", 30);
		itemlist.put("roti",50);
		if(itemlist.get(preferedfood)>0) {
			return itemlist.get(preferedfood);
		}
		else {
			return 0;
		}
	
	}

	@Override
	public void shoplocation() {
		System.out.println("Shop2 Aavadi");
		
	}
	
}
class Shop3 implements Shop{

	@Override
	public int fooditems(String preferdfood) {
		Map<String,Integer>itemlist=new HashMap<>();
		itemlist.put("poori",80);
		itemlist.put("pongal", 100);
		itemlist.put("idly", 150);
		itemlist.put("chapathi", 30);
		itemlist.put("roti",50);
		if(itemlist.get(preferdfood)>0) {
			return itemlist.get(preferdfood);
		}
		else {
			return 0;
		}

	}

	@Override
	public void shoplocation() {
		System.out.println("Shop3 Guindy");
		
	}
	
}
class FoodCart{
	String foodname;
	float amount;
	Discounts dis;
	Paymentgate gate;

	public FoodCart() {
		System.out.println("your ordered food");
	}
	public FoodCart(Discounts dis, Paymentgate gate) {
		this.dis=dis;
		this.gate=gate;
	}


	void orderedFood(String foodname, float  amount) {
		this.foodname=foodname;
		this.amount=amount;
		System.out.println(foodname+" "+amount);
	}

	float  discount(int amount2) {
		float discountamount= dis.discountamount(amount2);
		return discountamount;
	}
	
	void payment(float amountAfterDiscount) {
		float netAmount=gate.paymentgate(amountAfterDiscount);//dependency inversion principle
		System.out.println("your order "+foodname+" of rs "+amount+"is payed");
	}
	
}
interface Discounts {                                        //open closed principle
	float  discountamount(float amount);
}
class GreatDiscount implements Discounts{
	public float discountamount(float amount) {
		float discountAmount=amount-amount*0.02f;
		return discountAmount;
		
	}
}
class PongalDiscount implements Discounts{
	public float discountamount(float amount) {
		float discountAmount=amount-amount*0.05f;
		return discountAmount;
	}
}
interface Paymentgate{
	float paymentgate(float amount);
}
class UPI implements Paymentgate{
	public float paymentgate(float amount) {
		float netamount=amount;
		return netamount;
	}
}
class Criditcard implements Paymentgate{

	public float paymentgate(float amount) {
		float netamount;
		if(amount>500) {
			netamount=amount+5;
		}
		else {
			netamount=amount;
		}
		return netamount;
	}
	
}
class CashOnDelivery implements Paymentgate{
	public float paymentgate(float amount) {
		return amount;
	}
}

public class FoodDelivery {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		Map<String,String>pass=new HashMap<>();
		pass.put("Dharan","1234");
		pass.put("Kumar","4567");
		pass.put("Karthic", "7894");
		List<String[]>userdetails=new ArrayList<>();
		String user1[]= {"Dharan","XXXXXXXXXX","0000000000"};
		String user2[]= {"Kumar","yyyyyyyyyy","1111111111"};
		String user3[]= {"Karthic","zzzzzzzzzz","2222222222"};
		userdetails.add(user1);
		userdetails.add(user2);
		userdetails.add(user3);
		System.out.println("Enter user name");
		String username=sc.nextLine();
		String[]curruser=new String[3];
		for(String[] s:userdetails) {
			if(username.equals(s[0])) {
				System.out.println("Enter password");
				String password=sc.nextLine();
				if(password.equals(pass.get(username))) {
					for(int i=0;i<3;i++) {
						curruser[i]=s[i];
					}
				}
			}
		}
//		for(int i=0;i<3;i++) {
//			System.out.println(curruser[i]);
//		}
		User user=new User(curruser);
		System.out.println("press 1 to change details");
		int commend =sc.nextInt();
		if(commend==1) {
			user.changeDetails();
			curruser=user.savingdetails();
		}
//		for(int i=0;i<3;i++) {
//			System.out.println(curruser[i]);
//		}
		
//		List<String>fooditems=new ArrayList<>();
//		fooditems.add("eddly");
//		fooditems.add("Pongal");
//		fooditems.add("poori");
//		fooditems.add("rotee");
//		fooditems.add("chapathi");
//		fooditems.add("pizza");
		Shop shop = null;
		FoodItems food=new FoodItems();
		System.out.println("for order food press 1 or press 2 to exit");
		int order=sc.nextInt();
		String fooditem = null;
		if(order==1) {
			System.out.println("press 1 for south indian food press 2 for north indian food press 3 for fastfood");
			int type=sc.nextInt();
			
			if(type==1) {
				fooditem=food.southIndianFood();
			}
			else if(type==2) {
				fooditem=food.northIndianFood();
			}
			else if(type==3) {
				fooditem=food.fastFood();
			}
		}
		System.out.println("1=>shop1\n2=>shop2\n3=>shop3");
		int shopPreference=sc.nextInt();
		switch(shopPreference) {
		case(1):
			shop=new Shop1();
		    break;
		case(2):
			shop=new Shop2();
		    break;
		case(3):
			shop=new Shop3();
		    break;
		}
		System.out.println("press 1 for UPI || press 2 for depit card || press 3 for casho on delivery");
		int paymentmethod=sc.nextInt();
		Paymentgate gate=null;
		switch(paymentmethod) {
		case(1):
			gate=new UPI();
		    break;
		case(2):
			gate=new Criditcard();
		    break;

		case(3):
			gate=new CashOnDelivery();
		    break;
		}
		Discounts dis=new GreatDiscount();
		FoodCart cart=new FoodCart(dis,gate);
		FoodItems food1=new FoodItems(shop,fooditem,cart);
		food1.order();

		
	}
}