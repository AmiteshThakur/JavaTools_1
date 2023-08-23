package com.ami.tech.util;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.*;

import com.amit.tech.util.ATArrayList.ATArrayListIterator;

import java.io.*;

public class settergetter {
    public static void main(String args[]) {
        if (args.length != 1 && args.length != 2) {
            System.out.println(
                    "  1  Usage: java classpath path_to_jar_file;. com.ami.tech.util.settergetter [class_name] constructor=true/false");
            return;
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("constructor=true") == false
                    && args[1].equalsIgnoreCase("construtor=false") == false) {
                System.out.println(
                        "2   Usage: java classpath path_to_jar_file;. com.ami.tech.util.settergetter [class_name] constructor=true/false");
                return;

            }
        }

        String className = args[0];
        try {
            Class c = Class.forName(className);
            Field fields[] = c.getDeclaredFields();
            Field field;
            List<String> list = new ArrayList<String>();
            String setterName;
            String getterName;
            String tmp;
            String fieldName;
            Class fieldType;
            String line;
            if (args.length==1 || (args.length == 2 && args[1].equalsIgnoreCase("constructor=true"))) {
                line = "public " + c.getSimpleName() + "()";
                list.add(line);
                list.add("{");
                for (int e = 0; e < fields.length; e++) {
                    field = fields[e];
                    line = "this." + field.getName() + "=" + getDefaultValue(field.getType()) + ";";
                    list.add(line);
                }

                list.add("}");
            }
            for (int e = 0; e < fields.length; e++) {
                field = fields[e];
                fieldName = field.getName();
                fieldType = field.getType();
                if (fieldName.charAt(0) >= 97 && fieldName.charAt(0) <= 122) {
                    tmp = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                } else {
                    tmp = fieldName;
                }
                setterName = "set" + tmp;
                getterName = "get" + tmp;
                line = "public void " + setterName + "(" + fieldType.getName() + " " + fieldName + ")";
                list.add(line);
                list.add("{");
                line = "this." + fieldName + "=" + fieldName + ";";
                list.add(line);
                list.add("}");
                line = "public " + fieldType.getName() + " " + getterName + "()";
                list.add(line);
                list.add("{");
                line = "return this." + fieldName + ";";
                list.add(line);
                list.add("}");

            }
            File file = new File("tmp.tmp");
            if (file.exists())
                file.delete();
            RandomAccessFile randomAccessFile;
            randomAccessFile = new RandomAccessFile(file, "rw");
            Iterator<String> iterator;
            iterator = list.iterator();
            while (iterator.hasNext()) {
                line = iterator.next();
                randomAccessFile.writeBytes(line + "\r\n");

            }
            randomAccessFile.close();
            System.out.println("Setter Getters for " + c.getName() + "generated in tmp.tmp");

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("unable to load to class");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("file not found");
        } catch (IOException ioException) {
            System.out.println("Input Output Exception");
        }

    }

    private static String getDefaultValue(Class c) {
        String className = c.getName();
        if (className.equals("java.lang.Long") || className.equals("long"))
            return "0";
        if (className.equals("java.lang.Float") || className.equals("float"))
            return "0.0f";
        if (className.equals("java.lang.Double") || className.equals("double"))
            return "0.0";
        if (className.equals("java.lang.Integer") || className.equals("int"))
            return "0";
        if (className.equals("java.lang.Byte") || className.equals("byte"))
            return "0" ;
        if (className.equals("java.lang.Character") || className.equals("char"))
            return "' '";
        if (className.equals("java.lang.Boolean") || className.equals("boolean"))
            return "false";
            if (className.equals("java.lang.Short") || className.equals("short"))
            return "0";
        if (className.equals("java.lang.String"))
            return "\"\"";
        return null;
    }
}
