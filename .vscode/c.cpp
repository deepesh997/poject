#include<iostream>
#include<string.h>
using namespace std;
class String
{
	char p[50];
	int len;

public:
	String();
	String(char *s);
	String(String &t);
	void display()
	{
		cout << p;
		cout << len;
	}
};
String::String()
{
	char p[20]="Welcome";
}
String::String(char *s)
{
	//p = s;
	len = strlen(s);
//	p = new char[len + 1];
		strcpy(p,s);
}
String ::String( String &t)
{
	len=t.len;
//	p=new char[len+1];
	strcpy(p,t.p);

}
int main()
{
	String s1;
	s1.display();
	//char
	String s2;
	s2.display();
	String s3(s2);
	s3.display();
	
	return 0;
}