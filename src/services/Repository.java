package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();

        if (type.getSuperclass() != null) {
            fields.addAll(getAllFields(type.getSuperclass()));
        }

        for (Field field : type.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                fields.add(field);
            }
        }

        return fields;
    }

    public static <T> void write(T obj, boolean erase) throws Exception {
        String filename = obj.getClass().getField("FILENAME").get(obj).toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, erase));

        List<Field> fields = getAllFields(obj.getClass());
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    sb.append(value.toString());
                    sb.append(",");
                } catch (Exception e) {
                    System.err.println("Error getting field value: " + e.getMessage());
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1); // Remove last comma
        sb.append(System.lineSeparator());
        writer.write(sb.toString());
        writer.close();
    }

    public static <T> void writeList(ArrayList<T> list) throws Exception {
        for (T obj : list) {
            Repository.write(obj, false);
        }
    }

    public static <T> void refresh(ArrayList<T> list) throws Exception {
        boolean db_erase = false;
        boolean programing_erase = false;
        boolean network_erase = false;

        for (T obj : list) {
            String filename = obj.getClass().getField("FILENAME").get(obj).toString();

            if (filename.contains("db") && !db_erase) {
                Repository.write(obj, true);
                db_erase = true;
            } else {
                Repository.write(obj, false);
            }

            if (filename.contains("programing") && !programing_erase) {
                Repository.write(obj, true);
                programing_erase = true;
            } else {
                Repository.write(obj, false);
            }

            if (filename.contains("network") && !network_erase) {
                Repository.write(obj, true);
                network_erase = true;
            } else {
                Repository.write(obj, false);
            }
        }
    }

    public static <T> ArrayList<T> read(String filename, Class<T> cls) throws IOException {
        ArrayList<T> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            try {
                Constructor<T> constructor = cls.getConstructor(String.class);
                T obj = constructor.newInstance(line);
                list.add(obj);
            } catch (Exception e) {
                Console.print("Error creating object: " + e.getMessage());
            }

            line = reader.readLine();
        }
        reader.close();

        return list;
    }

}
