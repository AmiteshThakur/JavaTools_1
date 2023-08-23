package com.ami.tech.util;
import java.lang.reflect.*;
class Analyzer
{
public static void main(String ami[])
{
if(ami.length!=1)
{
System.out.println("Usage : java Analyzer class_name");
return;
}
String classToAnalyze=ami[0];
try{
Class c=Class.forName(classToAnalyze);
System.out.println("Name(include package name): "+c.getName());
System.out.println("Simple Name: "+ c.getSimpleName());
Method methods[];
//methods=c.getMethods(); // this will give all the methods which are added by the compiler;
methods=c.getDeclaredMethods();
Method m;
String methodName;
Class methodReturnType;
Class parameters[];
int e;
for (e=0; e<methods.length; e++)
{
m=methods[e];
methodName=m.getName();
System.out.println("Name of method: "+methodName);  
methodReturnType=m.getReturnType();
System.out.println("Return Type: "+methodReturnType.getName());
parameters=m.getParameterTypes();
System.out.println("Number of parameters : "+parameters.length);
for(int j=0; j<parameters.length; j++)
{
System.out.printf("Parameter Number: %d, Type %s \n",j+1,parameters[j].getName());
 
}
Field fields[];
fields=c.getDeclaredFields();
System.out.println( "Number of Fields :" +fields.length);
String fieldName;
Class fieldType;
for(int k=0; k<fields.length; k++)
{
fieldName=fields[k].getName();
fieldType=fields[k].getType();
System.out.printf("Field number %d, Name %s, Type %s \n",e+1,fieldName,fieldType);
}

System.out.println("**************************************************");
}
}catch(ClassNotFoundException cse)
{
System.out.println("Class:" +cse.getMessage()+"Not Found");
}
}

}