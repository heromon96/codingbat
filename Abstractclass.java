package myproject;

interface  Account119
{
	 public void credit(int amt);
	 public void debit(int amt);
}
class SavingAccounts implements Account119 
{
	final int minbal=1000;
	 int bal=minbal;
	 int Accno;
	 long phone;
	 String name;
	@Override
	public void credit(int amt) {
		// TODO Auto-generated method stub
		bal+=amt;
	}
	@Override
	public void debit(int amt) {
		// TODO Auto-generated method stub
		if(bal<minbal)
		{
			System.out.println("minimum balance sholud be "+minbal);
		}
		else
		{
			bal-=amt;
		}
	}
	public SavingAccounts(int accno, long phone, String name) {
		super();
		Accno = accno;
		this.phone = phone;
		this.name = name;
	}
	@Override 
	public String toString()
	{
		return Accno+" "+phone+" "+name;
	}
}
class CurrentAccounts implements Account119
{
	int bal;
	final int roi=10;
	int Accno;
	 long phone;
	 String name;
	@Override
	public void credit(int amt) {
		// TODO Auto-generated method stub
		bal+=amt;
	}

	@Override
	public void debit(int amt) {
		// TODO Auto-generated method stub
		if(bal>=0)
		{
			bal-=amt;
		}
	}

	public CurrentAccounts(int accno, long phone, String name) {
		super();
		Accno = accno;
		this.phone = phone;
		this.name = name;
	}
	@Override
	public String toString()
	{
		return Accno+" "+phone+" "+name;
	}
}
class Admin119
{
	static Account119 [] ac=new Account119[10];
	static int count;
	public static Account119 createAccount(Account119 type)
	{
		Account119 ref =type;
		if(count<ac.length)
		{
			ac[count]=type;
			count++;
		}
		else
		{
			System.out.println("account has been not created");
		}
		if(type instanceof SavingAccounts)
		{
			SavingAccounts ref1=(SavingAccounts)ref;
			return ref1;
		}
		else
		{
			CurrentAccounts ref1=(CurrentAccounts)ref;
			return ref1;
		}
	}
	public static void toDisplayAcc()
	{
		for(int j=0;j<ac.length;j++)
		{
			System.out.println(ac[j]);
		}
	}
}
public class Abstractclass
{
	public static void main(String[]args)
	{
		System.out.println("program starts...");
		SavingAccounts s1=new SavingAccounts(1,99645673,"monesh");
		SavingAccounts s2=new SavingAccounts(2,99645673,"monesh");
		SavingAccounts s3=new SavingAccounts(3,99645673,"monesh");
		SavingAccounts s4=new SavingAccounts(4,99645673,"monesh");
		SavingAccounts s5=new SavingAccounts(5,99645673,"monesh");
		
		
		CurrentAccounts c1=new CurrentAccounts(6,1234567891,"Vinay");
		CurrentAccounts c2=new CurrentAccounts(7,1234567891,"Vinay");
		CurrentAccounts c3=new CurrentAccounts(8,1234567891,"Vinay");
		CurrentAccounts c4=new CurrentAccounts(9,1234567891,"Vinay");
		CurrentAccounts c5=new CurrentAccounts(10,1234567891,"Vinay");
		
		Admin119.createAccount(s1);
		Admin119.createAccount(s2);
		Admin119.createAccount(s3);
		Admin119.createAccount(s4);
		Admin119.createAccount(s5);
		
		
		Admin119.createAccount(c1);
		Admin119.createAccount(c2);
		Admin119.createAccount(c3);
		Admin119.createAccount(c4);
		Admin119.createAccount(c5);
		Admin119.createAccount(new CurrentAccounts(11,5678,"bhahubali"));
		
		Admin119.toDisplayAcc();
			
	}
}