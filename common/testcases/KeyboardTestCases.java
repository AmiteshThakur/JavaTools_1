import com.ami.tech.util.*;
class KeyboardTestCases
{
public static void main(String ami[])
{
Keyboard k=new Keyboard();
String a;
a=k.getString("Enter a String");

char b;
b=k.getCharacter("Enter a Character");

int c;
c=k.getInt("Enter an Integer");

short d;
d=k.getShort("Enter a Short");

byte e;
e=k.getByte("Enter a Byte");

double f;
f=k.getDouble("Enter a Double");

float g;
g=k.getFloat("Enter a Float");

boolean h;
h=k.getBoolean("Enter a Boolean");

System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);

}
}